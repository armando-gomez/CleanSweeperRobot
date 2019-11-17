package com.groupseven.floorplan;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileParser {
	private static FileReader in;
	private static JSONParser jsonParser;
	private static JSONObject jsonObject;
	private static JSONArray jsonArray;
	private static Iterator<JSONObject> iterator;

	private static Cell[][] cells;

	public static Layout parseFile(String fileName) throws IOException {
		Layout layout = Layout.getInstance();
		try {
			jsonParser = new JSONParser();
			in = new FileReader(fileName);
			jsonObject = (JSONObject) jsonParser.parse(in);

			int rows = Integer.parseInt(jsonObject.get("numRows").toString());
			int cols = Integer.parseInt(jsonObject.get("numCols").toString());
			layout.setNumRows(rows);
			layout.setNumCols(cols);

			jsonArray = (JSONArray) jsonObject.get("cells");
			iterator = jsonArray.iterator();
			cells = new Cell[layout.getNumRows()][layout.getNumCols()];
			while (iterator.hasNext()) {
				JSONObject o = iterator.next();
				Cell cell = new Cell();
				cell.setNorth(Boolean.parseBoolean(o.get("north").toString()));
				cell.setSouth(Boolean.parseBoolean(o.get("south").toString()));
				cell.setEast(Boolean.parseBoolean(o.get("east").toString()));
				cell.setWest(Boolean.parseBoolean(o.get("west").toString()));
				cell.setDirt(Integer.parseInt(o.get("dirt").toString()));
				cell.setType(o.get("type").toString());
				int x = Integer.parseInt(o.get("x").toString());
				int y = Integer.parseInt(o.get("y").toString());
				cells[x][y] = cell;
			}
			layout.populateGrid(cells);

			jsonArray = (JSONArray) jsonObject.get("chargingStations");
			iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				JSONObject o = iterator.next();
				Point p = new Point();
				p.x = Integer.parseInt(o.get("x").toString());
				p.y = Integer.parseInt(o.get("y").toString());
				layout.setChargingStationPos(p);
			}

			jsonArray = (JSONArray) jsonObject.get("robot");
			iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				JSONObject o = iterator.next();
				Point p = new Point();
				p.x = Integer.parseInt(o.get("x").toString());
				p.y = Integer.parseInt(o.get("y").toString());
				layout.setRobotStartingPos(p);
			}

		} catch (IOException e) {
			throw e;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return layout;
	}
}
