package com.groupseven.sensorsimulator;

import com.groupseven.floorplan.Layout;

import java.awt.*;

public class SensorSimulator {
	private static SensorSimulator sim;
	private Layout layout;

	public static SensorSimulator getInstance(Layout layout) {
		if(sim == null) {
			sim = new SensorSimulator(layout);
		}
		return sim;
	}

	private SensorSimulator(Layout layout) {
		this.layout = layout;
	}

	public Point getStartingPos() {
		return layout.getRobotStartingPos();
	}

	public boolean canMove(Point p, String dir) {
		return layout.getCellNeighbor(p, dir);
	}

	public String askType(Point p) {
		return layout.getCellType(p);
	}

	public boolean cellHasDirt(Point p) {
		return layout.cellHasDirt(p);
	}

	public void updateDirt(Point p) {
		layout.updateDirt(p, -1);
		return;
	}

	public int currDirt(Point p) {
		return layout.getDirt(p);
	}

	public int width() {
		return layout.getNumCols();
	}

	public int height() {
		return layout.getNumRows();
	}
}
