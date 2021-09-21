package Lab3;

import java.util.Arrays;
import java.util.Scanner;

/*This program prompts the user to enter several numbers,
stores the numbers into an array,
then prints the numbers in forwards and backwards order.

Expected example output:

How many numbers will you enter? 4
Type a number: 12
Type a number: 8
Type a number: -2
Type a number: 39

Your numbers in forward order:
12
8
-2
39

Your numbers in backward order:
39
-2
8
12
*/

public class PromptNumbers {
	
	public static void printArray(int[] arr) {
		for (int x = 0; x < arr.length; x++) {
			System.out.println(arr[x]);
		}
	}
	
	public static void swapAll(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			int temp = arr1[i]; // inital the first input
			arr1[i] = arr2[i]; // the swap
			arr2[i] = temp; // place the second element with the initial input
		}
		System.out.println("arr1: " + Arrays.toString(arr1));
		System.out.println("arr2: " + Arrays.toString(arr2));
	}
	
	public static void main(String[] args) {
		
		int[] a1 = {11, 42, -5, 27, 0, 89};
		int[] a2 = {10, 20, 30, 40, 50, 60};
		swapAll(a1, a2);
		
		Scanner console = new Scanner(System.in);
		System.out.print("How many numbers will you enter? ");
		int count = console.nextInt();
		
		int[] store = new int[count];
		
		for (int i = 0; i < count; i++) {
			// your code goes here; store the numbers
			System.out.print("Type a number: ");
			int num = console.nextInt();
			store[i] = num;
		}
		
		System.out.println();
		System.out.println("Your numbers in forward order:");
		
		printArray(store);
		
		/* for (int i = 0; i < store.length; i++) {
			// your code goes here; print the numbers in forward order
			System.out.println(store[i]);
		}
		*/

		System.out.println();
		System.out.println("Your numbers in backward order:");
		
		for (int i = store.length; i > 0; i--) {
			// your code goes here; print the numbers in backward order
			System.out.println(store[i-1]);
		}
		
	}

}
