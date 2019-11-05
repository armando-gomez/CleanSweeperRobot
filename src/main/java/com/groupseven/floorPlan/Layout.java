package com.groupseven.floorPlan;

import com.groupseven.exceptions.InvalidEntryException;
import java.awt.*;
import java.util.ArrayList;

import static com.groupseven.CleanSweeperRobot.loggerFactory;
import static com.groupseven.CleanSweeperRobot.logger;


public final class Layout {

	private static Layout l;
	private long numRows;
	private long numCols;
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

	public void setNumRows(long rows) {
		try {
			if (rows <= 0 ) {
				throw new InvalidEntryException("Invalid entry");
			}
			else {
				numRows = rows;
			}
				
		} catch (InvalidEntryException e) {
			e.printStackTrace();
		}
	}

	public long getNumRows() {
		return this.numRows;
	
	}

	public void setNumCols(long cols) {
		try {
			if (cols <= 0 ) {
				throw new InvalidEntryException("Invalid entry");
			}
			else {
				numCols = cols;
			}
		} catch (InvalidEntryException e) {
			e.printStackTrace();
		}
	}

	public long getNumCols() {
		return this.numCols;
	
	}

	public void setDoors(Door[] ds) {
		this.doors = ds;
		logger = loggerFactory.build('M');
		String txt = Integer.toString(ds.length) + ",doors,";
		for (Door d : ds) {
			txt += d.getPCoords() + ",";
		}
		logger.log(txt, "Layout");
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
		logger = loggerFactory.build('M');
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

	//	Change Cell Data
	public void setCellDirt(Point p, long num) {
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
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
