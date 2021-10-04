package lab5;

import static org.junit.Assert.*;

import org.junit.Test;

public class newDLLTestInsert {

	@Test
	public void testInsert() {
		MyDLLImpl<Integer> dll0 = new MyDLLImpl<Integer>();
		
		assertTrue(dll0.isEmpty());
		
		dll0.insert(20);
		
		assertFalse(dll0.isEmpty());
		
		assertEquals(1, dll0.getSize());
	}

}
