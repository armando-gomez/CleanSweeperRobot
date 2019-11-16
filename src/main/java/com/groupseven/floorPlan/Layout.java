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
		if (layout == null) {
			layout = new Layout();
		}
		return layout;
	}

	private Layout() {
		chargingStations = new ArrayList<Point>();
	}

	public void populateGrid(Cell[][] cells) {
		grid = cells;
	}

	public void setNumRows(int rows) {
		if (rows > 0) {
			numRows = rows;
		}
	}

	public void setNumCols(int cols) {
		if (cols > 0) {
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
	}

	public Point getRobotStartingPos() {
		return this.robotStartingPos;
	}

	public String getCellType(Point p) {
		Cell c = grid[(int) p.getX()][(int) p.getY()];
		return c.getType();
	}

	public boolean getCellNeighbor(Point p, String dir) {
		if(dir.equals("n")) {
			return grid[(int) p.getX()][(int) p.getY()].getNorth();
		} else if(dir.equals("s")) {
			return grid[(int) p.getX()][(int) p.getY()].getSouth();
		} else if(dir.equals("e")) {
			return grid[(int) p.getX()][(int) p.getY()].getEast();
		} else if(dir.equals("w")){
			return grid[(int) p.getX()][(int) p.getY()].getWest();
		}
		return false;
	}

	public boolean cellHasDirt(Point p) {
		int dirt = grid[(int) p.getX()][(int) p.getY()].getDirt();
		return dirt > 0;
	}

	public void updateDirt(Point p, int change) {
		Cell c = grid[(int) p.getX()][(int) p.getY()];
		c.setDirt(c.getDirt() + change);
		return;
	}

}
