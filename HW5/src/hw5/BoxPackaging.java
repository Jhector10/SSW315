/*
 * Name: Joshua Hector
 * I pledge my honor that I have abided by the Stevens Honor System
 */

package hw5;

import java.util.*;

public class BoxPackaging {

	public static String packageSystem(double[] weights, int numberOfItems, double boxSize) {
		
		Arrays.sort(weights); // now have all of the weights given to fill the main box
		
		double[] bins = new double[numberOfItems];
		
		int count = 0; 
		// count variable to keep track of boxes
		// i to keep track of indexes of the weights array
		
		for (int i = 0; i < numberOfItems; i++) {
			int currentBin; // number of overall items, goes to every item 
			for (currentBin = 0; currentBin < count; currentBin++) {
				if (bins[currentBin] >= weights[i]) {
					bins[currentBin] = bins[currentBin] - weights[i];
					break;
				}
			}
			
			if (currentBin == count) {
				bins[count] = boxSize - weights[i];
				count++; // adds another bin so that we can hold all the items
			}
		}
		
		return "You would need a total of " + count + " boxes.";
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("How many items?: ");
		int numberOfItems = input.nextInt();
		double[] items = new double[numberOfItems];
		
		for (int i = 0; i < numberOfItems; i++) {
			System.out.println("Enter the weight of item " + (i + 1) + ": ");
			double weightOfItem = input.nextDouble();
			
			if (weightOfItem > 1.0 || weightOfItem < 0.0) {
				throw new IllegalArgumentException("Weight of items must be between 0.0 and 1.0.");
			}
			
			items[i] = weightOfItem;
		}
		
		input.close();
		
		System.out.println(BoxPackaging.packageSystem(items, numberOfItems, 1.0));

	}
}
