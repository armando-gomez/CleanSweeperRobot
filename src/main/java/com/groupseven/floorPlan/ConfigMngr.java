package com.groupseven.floorPlan;

import java.io.*;

import com.groupseven.SensorSimulator.SensorSimulator;
import com.groupseven.logger.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Iterator;

public class ConfigMngr {

	private JSONParser parser;
	private JSONObject o;
	private JSONArray jArray;
	private FileReader in;
	private String fileName;
	private SensorSimulator sensor;
	private Cell[] cell;
	private Iterator<JSONObject> iterator;
	public static Logger logger;

	public ConfigMngr(String s) { 
		this.fileName = s;
		parser = new JSONParser();
		Layout layout = Layout.getInstance();
		try {
			in = new FileReader(s);
			o = (JSONObject) parser.parse(in);
			layout.setNumRows( Long.parseLong(o.get("numRows").toString()) );
			layout.setNumCols( Long.parseLong(o.get("numRows").toString()) );
			jArray = (JSONArray) o.get("cells");
			iterator = jArray.iterator();
			long l = layout.getNumRows() * layout.getNumCols();
			cell = new Cell[(int) l];
			int i = 0;
			while (iterator.hasNext()) {
				JSONObject n = iterator.next();
				cell[i] = new Cell((Boolean) n.get("forward"),(Boolean) n.get("back"),(Boolean)  n.get("right"),(Boolean)  n.get("left"), (Long) n.get("dirt"), (String) n.get("type"));
				i++;
			}
			layout.populateGrid(cell);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sensor = sensor.getInstance(layout);
		
	}


}
