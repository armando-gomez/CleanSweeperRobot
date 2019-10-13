package com.groupseven.robot;

import java.awt.Point;

import com.groupseven.simulator.*;

public class Robot {
	private double chargeLeft;
	private double startingCharge = 100.00;
	private final double chargeMin = 20.0;
	
	private int dirtCapacity = 0;
	private final int dirtCapacityMax = 50;
	
	private SensorSimulator simulator;
	private Point pos;
	
	public Robot(SensorSimulator _simulator) {
		this.setCharge(startingCharge);
		this.simulator = _simulator;
		this.setPos(new Point());
		//this.setStartingPos(simulator.getStartingPos());


	}
	
	public double getCharge() {
		return this.chargeLeft;
	}
	
	public void setCharge(double charge) {
		this.chargeLeft = charge;
	}
	
	public int getDirtCapacity() {
		return this.dirtCapacity;
	}
	
	public void setDirtCapacity(int _dirtCapacity) {
		this.dirtCapacity = _dirtCapacity;
	}

	public boolean isDirtCapacityFull() {
		return this.getDirtCapacity() == dirtCapacityMax;
	}

	public void emptyRobot() {
		this.setDirtCapacity(0);
	}
	
	public Point getPos() {
		return this.pos;
	}

	public void setPos(Point _pos) {
		this.pos = _pos;
	}

	public void move(){

	}
	
	
}
