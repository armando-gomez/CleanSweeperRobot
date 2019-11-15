package com.groupseven.floorPlan;

import java.awt.*;

public class Door {

    private Point p;
    private String s;
    private Point neighbor;
    private String neighborS;
    private Boolean open = false;

    public Door(Point p1, Point p2, String s1, String s2) {
        setP(p1); setNeighbor(p2); setS(s1); setNeighborS(s2);
    }

    public String getPCoords() {
        return Double.toString(this.p.getX()) + ","+ Double.toString(this.p.getY());

    }

    public void setP(Point p) {
        this.p = p;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Point getNeighbor() {
        return new Point((int) neighbor.getX(), (int) neighbor.getY());
    }

    public Point getP() {
        return new Point((int) p.getX(), (int) p.getY());
    }
    public void setNeighbor(Point neighbor) {
        this.neighbor = neighbor;
    }

    public String getNeighborS() {
        return neighborS;
    }

    public void setNeighborS(String neighborS) {
        this.neighborS = neighborS;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String toString() {
        return p.toString() + "Door is open : " + open;
    }
}
