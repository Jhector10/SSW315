package sortLab;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class QuicksortLabTest {

	@Test
	public void test() {
		
		int[] input1 = {44, 75, 23, 43, 55, 12, 64, 77, 33};  //a test input array;
		
		QuicksortLab Sorter = new QuicksortLab();
		
		Sorter.quickSort(input1);

		String expected1 = "[12, 23, 33, 43, 44, 55, 64, 75, 77]"; //expected results from quicksort();

		assertEquals(expected1, Arrays.toString(input1));   
	}

}
