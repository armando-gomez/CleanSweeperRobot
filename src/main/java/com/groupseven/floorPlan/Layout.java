package com.groupseven.floorplan;

import java.awt.*;
import java.util.ArrayList;

public final class Layout {
	private static Layout layout;
	private int numRows;
	private int numCols;
	private Cell[][] grid;
	private ArrayList<Point> chargingStations;
	private Point robotStartingPos;

	public static Layout getInstance() {
		if(layout == null) {
			layout = new Layout();
		}
		return layout;
	}

	public void populateGrid(Cell[][] cells) {
		grid = cells;
	}

	public void setNumRows(int rows) {
		if(rows > 0) {
			numRows = rows;
		}
	}

	public void setNumCols(int cols) {
		if(cols > 0) {
			numCols = cols;
		}
	}

	public int getNumRows() {
		return this.numRows;
	}

	public int getNumCols() {
		return this.numCols;
	}

	public void setChargingStationPos(Point p) {
		chargingStations.add(p);
		Cell cell = grid[(int) p.getX()][(int) p.getY()];
		cell.setHasChargingStation(true);
	}

	public void setRobotStartingPos(Point p) {
		this.robotStartingPos = p;
		Cell cell = grid[(int) p.getX()][(int) p.getY()];
		cell.setHasRobot(true);
	}

	public Point getRobotStartingPos() {
		return this.robotStartingPos;
	}
}
