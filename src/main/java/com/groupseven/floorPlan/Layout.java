package com.groupseven.floorPlan;

import com.groupseven.exceptions.InvalidEntryException;
import java.awt.*;
import java.util.ArrayList;

import static com.groupseven.CleanSweeperRobot.loggerFactory;
import static com.groupseven.CleanSweeperRobot.logger;


public final class Layout {

	private static Layout l;
	private int numRows;
	private int numCols;
	private Cell[][] grid;
	private Door[] doors;
	private Point[] chargingStations;


	public static Layout getInstance() {

		if (l == null)
			l = new Layout();
		return l;
	}

	private Layout() {
		logger = loggerFactory.build('m');
		logger.log("making singleton Layout", "Layout");
	}

	public void setNumRows(int rows) throws InvalidEntryException{
        if (rows <= 0 ) {
            throw new InvalidEntryException("Invalid entry");
        }
        else {
            numRows = rows;
            logger = loggerFactory.build('m');
            logger.log("number of rows", "Layout");
        }
	}

	public long getNumRows() {
		return this.numRows;
	}

	public void setNumCols(int cols) throws InvalidEntryException{
        if (cols <= 0 ) {
            throw new InvalidEntryException("Invalid entry");
        }
        else {
            numCols = cols;
            logger = loggerFactory.build('m');
            logger.log("number of rows", "Layout");
        }
	}

	public long getNumCols() {
		return this.numCols;
	
	}

	public void setDoors(Door[] ds) {
		this.doors = ds;
		logger = loggerFactory.build('z');
		String txt = Integer.toString(ds.length) + ",doors,";
		for (Door d : ds) {
			txt += d.getPCoords() + ",";
		}
		logger.log(txt, "Layout");
	}

	public void changeDoor(int door) {
        logger = loggerFactory.build('c');
        Boolean previous = doors[door].getOpen();
	    char[] cs = doors[door].getS().toCharArray();
	    if(doors[door].getOpen()) {
	        switch (cs[0]) {
                case 'r' :
                    grid[(int) doors[door].getP().getX()][(int) doors[door].getP().getY()].setRight(false);
                    grid[(int) doors[door].getNeighbor().getX()][(int) doors[door].getNeighbor().getY()].setLeft(false);
                case 'f' :
                    grid[(int) doors[door].getP().getX()][(int) doors[door].getP().getY()].setForward(false);
                    grid[(int) doors[door].getNeighbor().getX()][(int) doors[door].getNeighbor().getY()].setBack(false);
                case 'l' :
                    grid[(int) doors[door].getP().getX()][(int) doors[door].getP().getY()].setLeft(false);
                    grid[(int) doors[door].getNeighbor().getX()][(int) doors[door].getNeighbor().getY()].setRight(false);
                case 'b' :
                    grid[(int) doors[door].getP().getX()][(int) doors[door].getP().getY()].setBack(false);
                    grid[(int) doors[door].getNeighbor().getX()][(int) doors[door].getNeighbor().getY()].setForward(false);
            }
            doors[door].setOpen(false);
	        logger.log(doors[door].getPCoords() + " from " + previous + " to " + doors[door].getOpen(),"Layout");
        } else {
            switch (cs[0]) {
                case 'r' :
                    grid[(int) doors[door].getP().getX()][(int) doors[door].getP().getY()].setRight(true);
                    grid[(int) doors[door].getNeighbor().getX()][(int) doors[door].getNeighbor().getY()].setLeft(true);
                case 'f' :
                    grid[(int) doors[door].getP().getX()][(int) doors[door].getP().getY()].setForward(true);
                    grid[(int) doors[door].getNeighbor().getX()][(int) doors[door].getNeighbor().getY()].setBack(true);
                case 'l' :
                    grid[(int) doors[door].getP().getX()][(int) doors[door].getP().getY()].setLeft(true);
                    grid[(int) doors[door].getNeighbor().getX()][(int) doors[door].getNeighbor().getY()].setRight(true);
                case 'b' :
                    grid[(int) doors[door].getP().getX()][(int) doors[door].getP().getY()].setBack(true);
                    grid[(int) doors[door].getNeighbor().getX()][(int) doors[door].getNeighbor().getY()].setForward(true);
            }
            doors[door].setOpen(true);
            logger.log(doors[door].getPCoords() + " from " + previous + " to " + doors[door].getOpen(),"Layout");
        }
    }

	public void setChargingStations(ArrayList<Point> ps) {
		this.chargingStations = new Point[ps.size()];
		String txt = Integer.toString(ps.size()) + ",charging stations,";
		int i = 0;
		for (Point p : ps ) {
			this.chargingStations[i] = p;
			String s = Double.toString(p.getX())+","+Double.toString(p.getY());
			txt += s;
			i++;
		}
		logger = loggerFactory.build('z');
		logger.log(txt, "Layout");
	}

	//get Cell information from grid
	public String getCellType(Point p) {
		return grid[(int) p.getX()][(int) p.getY()].getType();
	}
	public Boolean getCellRight(Point p) {
		return grid[(int) p.getX()][(int) p.getY()].getRight();
	}
	public Boolean getCellLeft(Point p) {
		return grid[(int) p.getX()][(int) p.getY()].getLeft();
	}
	public Boolean getCellBack(Point p) {
		return grid[(int) p.getX()][(int) p.getY()].getBack();
	}
	public Boolean getCellForward(Point p) {
		return grid[(int) p.getX()][(int) p.getY()].getForward();
	}
	public String getCellName(Point p) {
		return grid[(int) p.getX()][(int) p.getY()].getName();
	}
	public int getCellDirt(Point p) { return Math.toIntExact(grid[(int) p.getX()][(int) p.getY()].getDirt());}

	//	Change Cell Data
	public void setCellDirt(Point p, int num) {
		logger = loggerFactory.build('d');
		logger.log(Integer.toString((int)p.getX()) + "," + Integer.toString((int)p.getY()) + "," + Long.toString(num), "Layout");
		grid[(int)p.getX()][(int)p.getY()].setDirt(num);
	}


	//get Cell string from Grid
	public String getCellString(Point p) {
		return grid[(int)p.getX()][(int)p.getY()].toString();
	}

	//make 2D-matrix out of cell array
	public void populateGrid(Cell[] g) {
		int k = 0;
		for (int z = 0; z < g.length; z++)
		grid = new Cell[(int) numRows][(int) numCols];
		for (int i = (int)numRows-1; i >= 0; i--) {
			for ( int j = 0; j < numCols; j++, k++) {
				g[k].setName(i,j);
				grid[i][j] = g[k];
				logger = loggerFactory.build('m');
				logger.log(grid[i][j].toString(), "Layout");
				/*try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
			}
		}
	}

}
