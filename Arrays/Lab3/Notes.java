package Lab3;

import java.util.Arrays;

public class Notes {
	public static void main(String[] args) {
	
		int[] data = new int[8];
		data[0] = 3;
		data[7] = -18;
		data[4] = 5;
		data[1] = data[0];

		int x = data[4];
		data[4] = 6;
		data[x] = data[0] * data[1];
		
		System.out.println(Arrays.toString(data));
		
		int[] list = {2, 18, 6, -4, 5, 1};
		for (int i = 0; i < list.length; i++) {
		    list[i] = list[i] + (list[i] / list[0]);
		}
		
		System.out.println(Arrays.toString(list));
	
	}
	
	

}
