package complexityAlgorithm;

import java.util.Arrays;

public class SumOfNumbers {
	
	/**
	 * 
	 * @param arr: array of ints
	 * @param k: sum of numbers
	 * @return true if ints in the array can add up exactly to k
	 * This will be on O(n^2)
	 */
	public boolean sumNum(int[] arr, int k) {
		// check each element in array
		for (var i = 0; i < arr.length; i++) {
			// check each other element in the array
			for (var j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == k) {
					return true;
				}
				
			}
		}
		return false;
	}
	
	public boolean sumNumEff(int[] arr, int k) {
		
		Arrays.sort(arr);
		
		int i = 0;
		int j = arr.length - 1;
		
		while (i < j) {
			if (arr[i] + arr[j] == k) {
				return true;
			} else if (arr[i] + arr[j] < k) {
				i++;
			} else {
				j--;
			}
 		}
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		SumOfNumbers s = new SumOfNumbers();
		
		int[] arr = {8, 4, 1, 6};
		
		boolean answer = s.sumNum(arr, 10);
		boolean answer2 = s.sumNumEff(arr, 10);
		
		System.out.println(answer);
		System.out.println(answer2);
	}
}
