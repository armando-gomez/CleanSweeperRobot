import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
		Assertions.assertThrows(InvalidEntryException.class, () -> {
			layout.setNumRows(-3);
		});
	}
	
	@Test	
	public void setNumRowsTest3() {
		Layout layout = new Layout();
		Assertions.assertThrows(InvalidEntryException.class, () -> {
			layout.setNumRows(0);
		});
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
		Assertions.assertThrows(InvalidEntryException.class, () -> {
			layout.setNumCols(-3);
		});
	}
	
	@Test	
	public void setNumColTest3() {
		Layout layout = new Layout();
		Assertions.assertThrows(InvalidEntryException.class, () -> {
			layout.setNumCols(0);
		});
	}
	
	@Test	
	public void setNumColTest4() {
		Layout layout = new Layout();
		layout.setNumCols(999999999);
		assertEquals(layout.getNumCols(),999999999);
	}

	@Test
	public void populateGridTest1() {
		
	}

}
