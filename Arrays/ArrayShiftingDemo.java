import java.util.Arrays;

public class ArrayShiftingDemo {
	
	public static void swap(int[] arr, int i, int j) { // input of an array, and two elements
		int temp = arr[i]; // inital the first input
		arr[i] = arr[j]; // the swap
		arr[j] = temp; // place the second element with the initial input
	}
	
	public static void reverse(int[] arr) {
		for (int i=0; i <= arr.length/2; i++) 
			swap(arr, i, arr.length - i -1); // you swap as you go down the array
	}
	
	public static void main(String[] argv) throws Exception {
	      int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
	      System.out.println("Initial array...\n"+Arrays.toString(arr));
	      System.arraycopy(arr, 0, arr, 1, arr.length - 1);
	      System.out.println("Array after shifting to the right...");
	      System.out.println(Arrays.toString(arr));
	      
	      //Test swap
	      swap(arr, 0, 8);
	      System.out.println(Arrays.toString(arr));
	      
	      //Test reverse
	      reverse(arr);
	      System.out.println(Arrays.toString(arr));
	      
	   }
}
