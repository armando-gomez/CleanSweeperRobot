package com.groupseven.sensorsimulator;

import com.groupseven.floorplan.Layout;

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
}
