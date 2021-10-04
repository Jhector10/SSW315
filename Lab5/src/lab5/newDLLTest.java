package lab5;

import static org.junit.Assert.*;


import org.junit.Test;

public class newDLLTest {

	@Test
	public void testConstructor() {
		MyDLLImpl<Integer> dll0 = new MyDLLImpl<Integer>();
		
		assertTrue(dll0.isEmpty());
		assertEquals(0, dll0.getSize());
	}

}
