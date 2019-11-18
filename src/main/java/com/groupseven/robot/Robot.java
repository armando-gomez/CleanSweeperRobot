package com.groupseven.robot;



import com.groupseven.SensorSimulator.SensorSimulator;
import com.groupseven.floorPlan.Layout;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static com.groupseven.CleanSweeperRobot.*;


public class Robot implements PowerMgmt{

    // interface variables
    private PowerMgmt powerManager;
    private PowerMgmtFactory powerMgmtFactory = new PowerMgmtFactory();

    private double chargeLeft;
    private final double chargeMin;

    private int dirtCapacity;
    private final int dirtCapacityMax;

    private SensorSimulator simulator;
    private Point pos;
    private Point nxtPos;

    private java.util.List<Point> chargingStations;

    public Robot(Double chargeMin, int dirtCapacityMax, Point startingPoint, ArrayList<Point> alp) {
        this.setCharge(250.00);
        this.chargeMin = chargeMin;
        this.dirtCapacityMax = dirtCapacityMax;
        this.setPos(startingPoint);
        this.chargingStations = alp;
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

    public Point getNxtPos() {
        return this.nxtPos;
    }

    public void setNxtPos(Point _pos) {
        this.nxtPos = _pos;
    }

    public void move(){
        /*nxtPos needs to be set for the intended move, then robot needs to ask simulator
        * if it can move, if it can move then do this power stuff
        * */


        Double prevCharge = robot.getCharge();
        powerManager = powerMgmtFactory.build('m');
        powerManager.changePower(pos);

        logger = loggerFactory.build('p');
        logger.log(prevCharge + " to " + robot.getCharge(), "Robot");
    }

    private void senseSurroundings() {

    }

    public void rechargePower() {
        this.setCharge(250.00);
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

    public boolean canMove(String dir) {
        return simulator.askDir(nxtPos, dir);
    }

    //clean method to be written later
    public void clean() {
        //do cleaning stuff
        // decrement power level
       changePower(pos);
    }

    //power methods
    //@Override
    public void changePower(Point p) {
        Double prevCharge = robot.getCharge();
        powerManager = powerMgmtFactory.build('c');
        powerManager.changePower(p);

        logger = loggerFactory.build('p');
        logger.log(prevCharge + " to " + robot.getCharge(), "Robot");
    }
}

