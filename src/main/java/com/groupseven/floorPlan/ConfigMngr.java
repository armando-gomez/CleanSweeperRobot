package com.groupseven.floorPlan;

import java.awt.*;
import java.io.*;

import com.groupseven.SensorSimulator.SensorSimulator;
import com.groupseven.exceptions.InvalidEntryException;
import com.groupseven.robot.Robot;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import static com.groupseven.CleanSweeperRobot.logger;
import static com.groupseven.CleanSweeperRobot.loggerFactory;

public class ConfigMngr {
	private JSONParser parser;
	private JSONObject jObject;
	private JSONArray jArray;
	private FileReader in;
	private String fileName;
	private SensorSimulator sensor;
	private Cell[] cell;
	private Door[] doors;
	private Long[] ints;
	private ArrayList<Point> points = new ArrayList<Point>();
	private Iterator<JSONObject> iterator;
    private int dirtCapacityMax;
    private Double chargeMin;
    private Point startingPoint;

    public ConfigMngr(String s) {
		this.fileName = s;
		logger = loggerFactory.build('m');
		logger.log("Configuration Manager", "ConfigMngr");
		makeLayout();
	}

	public void makeLayout() {
		parser = new JSONParser();
		Layout layout = Layout.getInstance();
		try {
			in = new FileReader(fileName);
			logger = loggerFactory.build('r');
			logger.log(fileName, "Layout");
			String c = in.toString();
			jObject = (JSONObject) parser.parse(in);

			//get matrix dimensions
			try {
				layout.setNumRows(Integer.parseInt(jObject.get("numRows").toString()));
				layout.setNumCols(Integer.parseInt(jObject.get("numRows").toString()));
			} catch (InvalidEntryException e) {
				e.getMessage();
			}

			//get robot "chargeMin" and "dirtCapacityMax"
            chargeMin =	Double.parseDouble(jObject.get("chargeMin").toString());
			dirtCapacityMax = Integer.parseInt(jObject.get("dirtCapacityMax").toString());


			jArray = (JSONArray) jObject.get("cells");
			iterator = jArray.iterator();
			long l = layout.getNumRows() * layout.getNumCols();
			cell = new Cell[(int) l];
			int i = 0;
			while (iterator.hasNext() && jArray.size() > 0) {
				JSONObject n = iterator.next();
                Long d = (Long) n.get("dirt");
                int dirt = d.intValue();
				cell[i] = new Cell((Boolean) n.get("forward"),(Boolean) n.get("back"),(Boolean)  n.get("right"),(Boolean)  n.get("left"),  dirt, (String) n.get("type"));
				i++;
			}
			layout.populateGrid(cell);
			jArray = (JSONArray) jObject.get("doors");
			iterator = jArray.iterator();
			doors = new Door[jArray.size()];
			i = 0;

			while(iterator.hasNext() && jArray.size() > 0) {
				JSONObject o = iterator.next();
				Point p1 = new Point();
				Point p2 = new Point();
				p1.x = Math.toIntExact((Long)o.get("p1x"));
				p1.y = Math.toIntExact((Long)o.get("p1y"));
				p2.x = Math.toIntExact((Long)o.get("p2x"));
				p2.y = Math.toIntExact((Long)o.get("p2y"));
				doors[i] = new Door(p1, p2, (String) o.get("s"), (String) o.get("nS"));
				i++;
			}
			layout.setDoors(doors);
			jArray = (JSONArray) jObject.get("chargingStation");
			iterator = jArray.iterator();
			while(iterator.hasNext() && jArray.size() > 0) {
				JSONObject o = iterator.next();
				Point p = new Point();
				p.x =  Integer.parseInt(o.get("x").toString());
				p.y =  Integer.parseInt(o.get("y").toString());
				points.add(p);

			}
			layout.setChargingStations(points);

			jArray = (JSONArray) jObject.get("robotStartingPos");
			iterator = jArray.iterator();
			while(iterator.hasNext()) {
				JSONObject o = iterator.next();
				Point p = new Point();
				p.x = Integer.parseInt(o.get("x").toString());
				p.y = Integer.parseInt(o.get("y").toString());
				startingPoint = p;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sensor = sensor.getInstance(layout);
	}

	public Robot makeRobot() {
        logger = loggerFactory.build('m');
        logger.log("Clean Sweeper Robot", "ConfigMngr");
        return new Robot(chargeMin, dirtCapacityMax, startingPoint, points);
    }
	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd 'at' HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}

    //change all doors in Array
	public void changeDoorArray() {
        for (int i = 0; i < doors.length; i++) {
            Layout.getInstance().changeDoor(i);
        }
    }

	//	Add Dirt to size number of random cells and random amounts of dirt
	public void addDirt(int size) {
		//make a Point array of inputted size and add random amounts of dirt to cells
		//	method variables
		ArrayList<Point> points = new ArrayList<Point>();
		int control = 0;
		Random r = new Random();

		//get unique random cells to add dirt to
		while(control < size) {
			Point p = new Point();
			p.x = r.nextInt((int) Layout.getInstance().getNumRows());
			p.y = r.nextInt((int) Layout.getInstance().getNumCols());
			if (!points.contains(p)) {
				points.add(p);
				control++;
			}
		}

		//access cells in grid and add dirt in range of one and four
		int max = 4;
		int min = 1;
		int range = max - min + 1;
		for(Point p : points) {
			Layout.getInstance().setCellDirt(p, (int) ((Math.random() * range) + min));
		}
	}

    public static Double getValue(char c) {
        switch (c) {
            case 'b':
                return 1.0;
            case 'l':
                return 2.0;
            case 'h':
                return 3.0;
            default :
                return 0.0;
        }
    }


}
