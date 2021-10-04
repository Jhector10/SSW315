package lab5;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class newDLLTestDelete {

	@Test
	public void testDelete() {
		MyDLLImpl<Integer> dll0 = new MyDLLImpl<Integer>();
		
		Exception ex = new NoSuchElementException("The node is not in this list");
		
		assertTrue(dll0.isEmpty());
		
		dll0.insert(20);
		dll0.insert(30);
		
		assertFalse(dll0.isEmpty());
		
		dll0.delete(20);
		
		assertEquals(1, dll0.getSize());
	}

}
