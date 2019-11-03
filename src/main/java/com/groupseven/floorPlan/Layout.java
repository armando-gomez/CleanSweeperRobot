package com.groupseven.floorPlan;

import com.groupseven.exceptions.InvalidEntryException;
import com.groupseven.logger.Logger;
import com.groupseven.logger.LoggerFactory;

import java.awt.*;

import static com.groupseven.floorPlan.ConfigMngr.logger;

public final class Layout {

	private static Layout l;
	private long numRows;
	private long numCols;
	private Cell[][] grid;
	private Logger logger;
	private LoggerFactory loggerFactory = new LoggerFactory();


	public static Layout getInstance() {

		if (l == null)
			l = new Layout();
		return l;
	}

	private Layout() {
		System.out.println("making singleton Layout");
	}

	public void setNumRows(long rows) {
		try {
			if ( rows > 0 ) {
				numRows = rows;
			}
			else { 
				throw new InvalidEntryException("Invlid entry");
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
			if ( cols > 0 )
				numCols = cols;
			else { 
				throw new InvalidEntryException("Invlid entry");
			}
		} catch (InvalidEntryException e) {
			e.printStackTrace();
		}
	}

	public long getNumCols() {
		return this.numCols;
	
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
			}
		}
	}
}
