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

public class CellTest {
	
	
	@Test
	public void setTypeBareTest(){
		Cell testCell = new Cell(false, true, true, true, 0, "bare");
		testCell.setType("bare");
		assertEquals(testCell.getType(), "bare");
	}
		
	// Set <direction> to already existing opposite direction
	
	@Test 
	public void setForwardTrueTest() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setNorth(true);
		assertEquals(testCell.getNorth(),true);
	}
	
	@Test 
	public void setForwardFalseTest() {
		Cell testCell = new Cell(true, false, false, false, 0, "bare");
		testCell.setNorth(false);
		assertEquals(testCell.getNorth(),false);
	}
	
	@Test 
	public void setBackTrueTest() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setSouth(true);
		assertEquals(testCell.getSouth(),true);
	}
	
	@Test 
	public void setBackFalseTest() {
		Cell testCell = new Cell(false, true, false, false, 0, "bare");
		testCell.setSouth(false);
		assertEquals(testCell.getSouth(),false);
	}
	
	@Test 
	public void setRightTrueTest() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setEast(true);
		assertEquals(testCell.getEast(),true);
	}
	
	@Test 
	public void setRightFalseTest() {
		Cell testCell = new Cell(false, false, true, false, 0, "bare");
		testCell.setEast(false);
		assertEquals(testCell.getEast(),false);
	}
	
	@Test 
	public void setLeftTrueTest() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setWest(true);
		assertEquals(testCell.getWest(),true);
	}
	
	@Test 
	public void setLeftFalseTest() {
		Cell testCell = new Cell(false, false, false, true, 0, "bare");
		testCell.setWest(false);
		assertEquals(testCell.getWest(),false);
	}
	
	// Set <direction> to already existing direction 
	
	@Test 
	public void setForwardTrueTest2() {
		Cell testCell = new Cell(true, false, false, false, 0, "bare");
		testCell.setNorth(true);
		assertEquals(testCell.getNorth(),true);
	}
	
	@Test 
	public void setForwardFalseTest2() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setNorth(false);
		assertEquals(testCell.getNorth(),false);
	}
	
	@Test 
	public void setBackTrueTest2() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setSouth(true);
		assertEquals(testCell.getSouth(),true);
	}
	
	@Test 
	public void setBackFalseTest2() {
		Cell testCell = new Cell(true, false, false, false, 0, "bare");
		testCell.setSouth(false);
		assertEquals(testCell.getSouth(),false);
	}
	
	@Test 
	public void setRightTrueTest2() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setEast(true);
		assertEquals(testCell.getEast(),true);
	}
	
	@Test 
	public void setRightFalseTest2() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setEast(false);
		assertEquals(testCell.getEast(),false);
	}
	
	@Test 
	public void setLeftTrueTest2() {
		Cell testCell = new Cell(false, false, false, true, 0, "bare");
		testCell.setWest(true);
		assertEquals(testCell.getWest(),true);
	}
	
	@Test 
	public void setLeftFalseTest2() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setWest(false);
		assertEquals(testCell.getWest(),false);
	}
	
	//TODO assert each one capital letter
	
//	@Test(expected = InvalidEntryException.class)
//	public void testCapitalTypeSet() {
//		Cell testCell = new Cell(false, false, false, false, 0, "bare");
//		testCell.setType("Bare");
//	}
	
	@Test
	public void testGetType() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		assertEquals(testCell.getType(),"bare");
	}
	
//	@Test
//	public void testPutInvalidGetType() {
//		Cell testCell = new Cell(false, false, false, false, 0, "aaa");
//		assertEquals(testCell.getType(),"aaa");
//	}
	
	@Test
	public void toStringTest() {
//		Cell testCell = new Cell(false, false, false, false, 0, "bare");
//		String testString = testCell.toString();
//		System.out.println(testString);
	}
	
	@Test
	public void testDirt() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		assertEquals(testCell.getDirt(),0);
	}
	
	@Test 
	public void testDirtSetPositive() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setDirt(999);
		assertEquals(testCell.getDirt(),999);
	}
	
//	@Test 
//	public void testDirtSetNegative() {
//		Cell testCell = new Cell(false, false, false, false, 0, "bare");
//		testCell.setDirt(-12);
//		assertEquals(testCell.getDirt(),0);
//	}
	
	
	//TODO assert different type
	
	
	
	
	//TODO assert false settype invalid
//	@Test(expected = InvalidEntryException.class)
//	public void setTypeInvalidTest() {
//		Cell testCell = new Cell(false, true, true, true, 0, "bare");
//		testCell.setType("invalid");
//	}
	
	@Test
	public void checkCellForDirtTrue() {
		Layout layout = new Layout();
		Cell cell = new Cell(
				true,true,true,true,3,null);
		assertEquals(cell.getDirt(),3);
	}
	
	@Test
	public void checkCellForDirtFalse() {
		Layout layout = new Layout();
		Cell cell = new Cell(
				true,true,true,true,0,null);
		assertEquals(cell.getDirt(),0);

	}
	
	@Test 
	public void checkChargeFalse() {
		Cell cell = new Cell(
				true,true,true,true,0,null);
		assertEquals(cell.checkHasChargingStation(),false);
	}
	
	@Test 
	public void checkChargeTrue() {
		Cell cell = new Cell(
				true,true,true,true,0,null);
		cell.setHasChargingStation(true);
		assertEquals(cell.checkHasChargingStation(),true);
	}
	
	@Test 
	public void checkRobotFalse() {
		Cell cell = new Cell(
				true,true,true,true,0,null);
		assertEquals(cell.checkHasRobot(),false);
	}
	
	@Test 
	public void checkRobotTrue() {
		Cell cell = new Cell(
				true,true,true,true,0,null);
		cell.setHasRobot(true);

		assertEquals(cell.checkHasRobot(),true);
	}

	
	
}
