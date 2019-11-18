package com.groupseven.robot;

import com.groupseven.SensorSimulator.SensorSimulator;
import com.groupseven.floorPlan.Layout;

import java.awt.Point;
import java.util.*;

import static com.groupseven.CleanSweeperRobot.*;

public class Robot implements PowerMgmt{
    // interface variables
    private PowerMgmt powerManager;
    private PowerMgmtFactory powerMgmtFactory = new PowerMgmtFactory();

    private double chargeLeft;
    private final double chargeMin;

    private int dirtCapacity;
    private final int dirtCapacityMax;

    private SensorSimulator sim;
    private Point pos;
    private Point nxtPos;

    private List<Point> chargingStations;
    private List<Point> cleaned;
    private boolean cleaning;
    private List<Point> pathHistory;
    private boolean stuck;
    private boolean emptyMe;

    public Robot(Double chargeMin, int dirtCapacityMax, Point startingPoint, ArrayList<Point> alp) {
        this.setCharge(250.00);
        this.chargeMin = chargeMin;
        this.dirtCapacityMax = dirtCapacityMax;
        this.setPos(startingPoint);
        this.chargingStations = alp;
        this.sim = SensorSimulator.getInstance(Layout.getInstance());
        this.cleaned = new ArrayList<Point>();
        this.pathHistory = new ArrayList<Point>();
        this.emptyMe = false;
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

    public void start() {
        this.cleaning = true;
        int counter = 0;
        do {
            System.out.println(this.getCellString(this.pos));
            senseSurroundings();
            move();

            if (this.stuck) {
                cleaning = false;
            }
            counter++;
        } while(this.cleaning && counter < 40 );

        System.out.println();
        System.out.println("Returning to charge");
        if(!this.pos.equals(getClosestChargingStation(this.pos))) {
            moveToCharge();
        }
    }

    private void senseSurroundings() {
        List<Point> newStations = sim.sense(this.pos);
        for(Point p: newStations) {
            if(!this.chargingStations.contains(p)) {
                this.chargingStations.add(p);
            }
        }
    }

    private String getCellString(Point p) {
        return sim.getCellString(p);
    }

    public void moveToCharge() {
        Point target = getClosestChargingStation(this.pos);
        for(Point next: getPathToObj(this.pos, target)) {
            System.out.println(this.getCellString(this.pos));
            setNxtPos(next);
            addNextMoveToPathHistory(getNxtPos());
            this.setPos(getNxtPos());
            Double prevCharge = robot.getCharge();
            powerManager = powerMgmtFactory.build('m');
            powerManager.changePower(this.pos);
            logger = loggerFactory.build('p');
            logger.log(prevCharge + " to " + robot.getCharge(), "Robot");
        }

        this.cleaned = new ArrayList<>();
        this.pathHistory = new ArrayList<>();
        this.rechargePower();

        if(isDirtFull()) {
            this.emptyMe = true;
            Scanner in = new Scanner(System.in);
            do {
                System.out.print("Robot is full, please type empty: ");
                String response = in.next();
                if(response.equals("empty")) {
                    this.emptyMe = false;
                    start();
                    break;
                } else {
                    System.out.println();
                }
            } while(this.emptyMe);
        }
    }

    public void move(){
        /*nxtPos needs to be set for the intended move, then robot needs to ask simulator
        * if it can move, if it can move then do this power stuff
        * */
        if(cellHasDirt(this.pos)) {
            System.out.println("Cleaning dirt: " + sim.currDirt(this.pos) + " at " + this.getCellString(this.pos));
            cleanDirt(this.pos);
            return;
        }

        setNxtPos(getNextObj(this.pos));

        if(getNxtPos() == null) {
            this.stuck = true;
            return;
        }

        setNxtPos(getPathToObj(pos, getNxtPos()).get(0));
        addNextMoveToPathHistory(getNxtPos());

        if(this.pos.equals(getNxtPos())) {
            this.cleaning = false;
            return;
        }
        Point oldPos = this.pos;
        this.cleaned.add(oldPos);
        this.setPos(getNxtPos());

        Double prevCharge = robot.getCharge();
        powerManager = powerMgmtFactory.build('m');
        powerManager.changePower(pos);

        logger = loggerFactory.build('p');
        logger.log(prevCharge + " to " + robot.getCharge(), "Robot");
    }

    private List<Point> getPathToObj(Point from, Point to) {
        if (from.equals(to)) {
            return new ArrayList<Point>();
        }
        if (neighbors(from).contains(to)) {
            List<Point> res = new ArrayList<Point>();
            res.add(to);
            return res;
        }
        ArrayList<Point> path = new ArrayList<Point>();
        ArrayList<Point> visited = new ArrayList<Point>();
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(from);
        visited.add(from);

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            Point next = null;
            int distance = Integer.MAX_VALUE;
            for (Point p : neighbors(temp)) {
                if (!visited.contains(p)) {
                    visited.add(p);
                    if (p.equals(to)) {
                        path.add(p);
                        return path;
                    }
                    if (distance > distance(p, to)) {
                        distance = distance(p, to);
                        next = p;
                    }
                }
            }
            queue.add(next);
        }
        Collections.reverse(path);
        return path;
    }

    private List<Point> neighbors(Point p) {
        List<Point> neighbors = new ArrayList<Point>();
        if (p.y > 0 && sim.askDir(p, "f")) {
            neighbors.add(new Point(p.x, p.y - 1));
        }
        if (p.y < sim.width() && sim.askDir(p, "b")) {
            neighbors.add(new Point(p.x, p.y + 1));
        }
        if (p.x < sim.height() && sim.askDir(p, "r")) {
            neighbors.add(new Point(p.x + 1, p.y));
        }
        if (p.x > 0 && sim.askDir(p, "l")) {
            neighbors.add(new Point(p.x - 1, p.y));
        }
        return neighbors;
    }

    private void addNextMoveToPathHistory(Point p) {
        this.pathHistory.add(p);
    }

    private Point getNextObj(Point p) {
        if (isDirtFull()) {
            return null;
        }
        if (sim.askDir(p, "f") && !cleaned.contains(new Point(p.x+1, p.y))) {
            return new Point(p.x+1, p.y);
        } else if (sim.askDir(p, "b") && !cleaned.contains(new Point(p.x-1, p.y))) {
            return new Point(p.x-1, p.y);
        } else if (sim.askDir(p, "r") && !cleaned.contains(new Point(p.x, p.y+1))) {
            return new Point(p.x, p.y+1);
        } else if (sim.askDir(p, "l") && !cleaned.contains(new Point(p.x, p.y-1))) {
            return new Point(p.x, p.y-1);
        }
        return null;
    }

    private boolean isDirtFull() {
        return this.dirtCapacity == this.dirtCapacityMax;
    }

    private void cleanDirt(Point p) {
        this.dirtCapacity += 1;
        this.sim.updateDirt(p);
    }

    private boolean cellHasDirt(Point p) {
        return this.sim.currDirt(p) > 0;
    }

    public void rechargePower() {
        this.setCharge(250.00);
    }

    public List<Point> getChargingStations() {
        return this.chargingStations;
    }

    public Point getClosestChargingStation(Point p) {
        if (chargingStations.size() == 1) {
            return chargingStations.get(0);
        }

        Point closestPoint = chargingStations.get(0);
        int closestDistance = distance(p, closestPoint);
        for (int i = 1; i < chargingStations.size(); i++) {
            Point p2 = chargingStations.get(i);
            if (closestDistance > distance(p2, p2)) {
                closestDistance = distance(p2, p2);
                closestPoint = p2;
            }
        }
        return closestPoint;
    }

    private int distance(Point p, Point q) {
        return (int) Math.sqrt((q.y - p.y) * (q.y - p.y) + (q.x - p.x) * (q.x - p.x));
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

