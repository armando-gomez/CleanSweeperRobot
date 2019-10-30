
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
		assertEquals(testCell.getType(), "bare");
	}
		
	// Set <direction> to already existing opposite direction
	
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
		Cell testCell = new Cell(false, true, false, false, 0, "bare");
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
		Cell testCell = new Cell(false, false, true, false, 0, "bare");
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
		Cell testCell = new Cell(false, false, false, true, 0, "bare");
		testCell.setLeft(false);
		assertEquals(testCell.getLeft(),false);
	}
	
	// Set <direction> to already existing direction 
	
	@Test 
	public void setForwardTrueTest2() {
		Cell testCell = new Cell(true, false, false, false, 0, "bare");
		testCell.setForward(true);
		assertEquals(testCell.getForward(),true);
	}
	
	@Test 
	public void setForwardFalseTest2() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setForward(false);
		assertEquals(testCell.getForward(),false);
	}
	
	@Test 
	public void setBackTrueTest2() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setBack(true);
		assertEquals(testCell.getBack(),true);
	}
	
	@Test 
	public void setBackFalseTest2() {
		Cell testCell = new Cell(true, false, false, false, 0, "bare");
		testCell.setBack(false);
		assertEquals(testCell.getBack(),false);
	}
	
	@Test 
	public void setRightTrueTest2() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setRight(true);
		assertEquals(testCell.getRight(),true);
	}
	
	@Test 
	public void setRightFalseTest2() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setRight(false);
		assertEquals(testCell.getRight(),false);
	}
	
	@Test 
	public void setLeftTrueTest2() {
		Cell testCell = new Cell(false, false, false, true, 0, "bare");
		testCell.setLeft(true);
		assertEquals(testCell.getLeft(),true);
	}
	
	@Test 
	public void setLeftFalseTest2() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setLeft(false);
		assertEquals(testCell.getLeft(),false);
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
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		String testString = testCell.toString();
		System.out.println(testString);
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
	
	@Test 
	public void testDirtSetNegative() {
		Cell testCell = new Cell(false, false, false, false, 0, "bare");
		testCell.setDirt(-12);
		assertEquals(testCell.getDirt(),0);
	}
	
	
	//TODO assert different type

	//TODO assert false settype invalid
//	@Test(expected = InvalidEntryException.class)
//	public void setTypeInvalidTest() {
//		Cell testCell = new Cell(false, true, true, true, 0, "bare");
//		testCell.setType("invalid");
//	}
	
}
