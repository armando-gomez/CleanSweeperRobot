package com.groupseven.robot;



import com.groupseven.SensorSimulator.SensorSimulator;
import com.groupseven.floorPlan.Layout;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Robot {
    private double chargeLeft;
   /* private double startingCharge /*= 100.00;*/
    private final double chargeMin;

    private int dirtCapacity;
    private final int dirtCapacityMax;

    private SensorSimulator simulator;
    private Point pos;

    private java.util.List<Point> chargingStations;

    public Robot(Double chargeMin, int dirtCapacityMax, Point startingPoint, ArrayList<Point> alp) {
        this.setCharge(/*startingCharge*/100.00);
        this.chargeMin = chargeMin;
        this.dirtCapacityMax = dirtCapacityMax;
        this.setPos(startingPoint);
        chargingStations = alp;
        this.simulator = SensorSimulator.getInstance(Layout.getInstance());

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

    public void emptyDirt() {
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

    private void senseSurroundings() {

    }

    public void rechargePower() {
        this.setCharge(/*startingCharge*/100.00);
    }

    public void addChargingStation(Point p) {
        this.chargingStations.add(p);
    }

    public List<Point> getChargingStations() {
        return this.chargingStations;
    }

    public Point getClosestChargingStation() {
        double closestDistance = Integer.MAX_VALUE;
        Point closestStation = this.getPos();
        for(Point p: this.getChargingStations()) {

        }
        return closestStation;
    }

    public boolean canMove(Point curr, String dir) {
        return simulator.askDir(curr, dir);
    }

}
