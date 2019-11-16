package com.groupseven.robot;

import com.groupseven.sensorsimulator.SensorSimulator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Robot {
	private SensorSimulator sim;
	private int maxDirtCapacity;
	private double maxCharge;
	private double minCharge;
	private Point startPos;
	private ArrayList<Point> chargingStations;
	private boolean emptyMe;

	private Point currPos;
	private int currDirtCapacity;
	private double currCharge;
	private ArrayList<Point> visited;

	public Robot(SensorSimulator sim) {
		this.sim = sim;
		initializeRobot();
	}
	
	private void initializeRobot() {
		this.maxDirtCapacity = 50;
		this.maxCharge = 250.0;
		this.minCharge = 20.0;
		setStartingPos();
		this.chargingStations = new ArrayList<Point>();
		this.chargingStations.add(startPos); //always starts cleaning from a chargingStation
		this.emptyMe = false;
	}

	private void setStartingPos() {
		this.startPos = sim.getStartingPos();
		this.currPos = this.startPos;
		this.visited.add(this.currPos);
	}

	public void start() {
		Scanner in = new Scanner(System.in);
		String input;
		do {
			Point oldPos = this.currPos;
			if(currPosHasDirt(currPos)) {
				cleanDirt(currPos);
				continue;
			}
			input = in.next();
			if(sim.canMove(this.currPos, input)) {
				move(input);
				System.out.println("Robot moved: " + currPosString());
			} else if (!input.equals("exit")) {
				System.out.println("Cannot move " + input);
			}
		} while(!emptyMe);

	}

	private boolean currPosHasDirt(Point p) {
		return this.sim.cellHasDirt(p);
	}

	private void cleanDirt(Point p) {
		this.currDirtCapacity += 1;
		this.sim.updateDirt(p);
		if(this.currDirtCapacity == this.maxDirtCapacity) {
			emptyMe = true;
		}
	}

	private void move(String dir) {
		if(dir.equals("n")) {
			this.currPos.y = this.currPos.y - 1;
		} else if(dir.equals("s")) {
			this.currPos.y = this.currPos.y + 1;
		} else if(dir.equals("e")) {
			this.currPos.x = this.currPos.x + 1;
		} else if(dir.equals("w")){
			this.currPos.x = this.currPos.x - 1;
		}
		this.visited.add(this.currPos);
	}

	private String currPosString () {
		return "[x: " + this.currPos.x + ", y: " + this.currPos.y + "]";
	}
}
