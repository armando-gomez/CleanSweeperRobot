package com.groupseven.floorplan;

public class Cell {
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
	private int dirt;
	private String type;
	private boolean hasChargingStation;
	private boolean hasRobot;

	public Cell(boolean north, boolean south, boolean east, boolean west, int dirt, String type) {
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.dirt = dirt;
		this.type = type;
		this.hasChargingStation = false;
		this.hasRobot = false;
	}

	public Cell() {
		this.hasChargingStation = false;
		this.hasRobot = false;
	}

	public void setDirt(int dirt) {
		this.dirt = dirt;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public void setWest(boolean west) {
		this.west = west;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean checkHasChargingStation() {
		return this.hasChargingStation;
	}

	public void setHasChargingStation(boolean chargingStation) {
		this.hasChargingStation = chargingStation;
	}

	public boolean checkHasRobot() {
		return this.hasRobot;
	}

	public void setHasRobot(boolean robot) {
		this.hasRobot = robot;
	}

}
