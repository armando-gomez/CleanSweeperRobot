
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.Assert.*;
import org.junit.*;
public class CellTest {
	
	
	@Test
	public void setTypeBareTest(){
		Cell testCell = new Cell(false, true, true, true, 0, "bare");
		testCell.setType("bare");
		System.out.println(testCell.getType());
		assertEquals(testCell.getType(), "bare");
	}
	
	//TODO set each direction set and get
	
	@Test 
	public void setForwardTrueTest() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setForward(true);
		assertEquals(testCell.getForward(),true);
	}
	
	@Test 
	public void setForwardFalseTest() {
		Cell testCell = new Cell(true, false, false, false, 0, "bare");
		testCell.setForward(false);
		assertEquals(testCell.getForward(),false);
	}
	
	@Test 
	public void setBackTrueTest() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setBack(true);
		assertEquals(testCell.getBack(),true);
	}
	
	@Test 
	public void setBackFalseTest() {
		Cell testCell = new Cell(true, false, false, false, 0, "bare");
		testCell.setBack(false);
		assertEquals(testCell.getBack(),false);
	}
	
	@Test 
	public void setRightTrueTest() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setRight(true);
		assertEquals(testCell.getRight(),true);
	}
	
	@Test 
	public void setRightFalseTest() {
		Cell testCell = new Cell(true, false, false, false, 0, "bare");
		testCell.setRight(false);
		assertEquals(testCell.getRight(),false);
	}
	
	@Test 
	public void setLeftTrueTest() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setLeft(true);
		assertEquals(testCell.getLeft(),true);
	}
	
	@Test 
	public void setLeftFalseTest() {
		Cell testCell = new Cell(true, false, false, false, 0, "bare");
		testCell.setLeft(false);
		assertEquals(testCell.getLeft(),false);
	}
	
	
	

	
	//TODO assert each one capital letter
	
	
	
	//TODO assert different type

	//TODO assert false settype invalid
//	@Test(expected = InvalidEntryException.class)
//	public void setTypeInvalidTest() {
//		Cell testCell = new Cell(false, true, true, true, 0, "bare");
//		testCell.setType("invalid");
//	}
	
}
