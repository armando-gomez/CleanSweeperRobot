import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Point;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import src.main.java.com.groupseven.floorPlan.Cell;
import src.main.java.com.groupseven.floorPlan.Layout;

import org.junit.Assert.*;
import org.junit.*;

public class LayoutTest {
	
	
	@Test 
	public void setNumRowsTest() {
		Layout layout = new Layout();
		layout.setNumRows(30);
		assertEquals(layout.getNumRows(),30);
	}
	
	@Test	
	public void setNumRowsTest2() {
		Layout layout = new Layout();
		layout.setNumRows(0);
		assertEquals(layout.getNumRows(),0);
	}
	
	@Test	
	public void setNumRowsTest3() {
		Layout layout = new Layout();
		layout.setNumRows(3);
		assertEquals(layout.getNumRows(),3);
	}
	
	@Test	
	public void setNumRowsTest4() {
		Layout layout = new Layout();
		layout.setNumRows(999999999);
		assertEquals(layout.getNumRows(),999999999);
	}

	@Test 
	public void setNumColTest() {
		Layout layout = new Layout();
		layout.setNumCols(30);
		assertEquals(layout.getNumCols(),30);
	}
	
	@Test	
	public void setNumColTest2() {
		Layout layout = new Layout();
		layout.setNumCols(3);
		assertEquals(layout.getNumCols(),3);
	}
	
	@Test	
	public void setNumColTest3() {
		Layout layout = new Layout();		
	}
	
	@Test	
	public void setNumColTest4() {
		Layout layout = new Layout();
		layout.setNumCols(999999999);
		assertEquals(layout.getNumCols(),999999999);
	}

	@Test
	public void populateGridTest1() {
		Layout layout = new Layout();
		Cell cell = new Cell(true,true,false,false,2,null);
		Cell cell2 = new Cell(false,true,false,false,1,null);
		Cell cell3 = new Cell(false,false,false,false,1,null);
		Cell[] cellList = new Cell[3];
		Cell[][] cellList2 = new Cell[1][3];
		cellList[0] = cell;
		cellList[1] = cell2;
		cellList[2] = cell3;
		cellList2[0] = cellList;
		layout.populateGrid(cellList2);
	}
	
	@Test
	public void setRobotStartPointTest() {
		Layout layout = new Layout();
		Point point = new Point(2,3);
		layout.setRobotStartingPos(point);
		assertEquals(layout.getRobotStartingPos(),point);
	}
	
	@Test
	public void setRobotStartPointTest2() {
		Layout layout = new Layout();
		Point point = new Point(2222,333333);
		layout.setRobotStartingPos(point);
		assertEquals(layout.getRobotStartingPos(),point);
	}

	@Test
	public void setRobotStartPointTest3() {
		Layout layout = new Layout();
		Point point = new Point(-2222,-333333);
		layout.setRobotStartingPos(point);
		assertEquals(layout.getRobotStartingPos(),point);
	}

	
		
}
