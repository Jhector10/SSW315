package sortLab;

import java.util.Arrays;
import java.util.Random;

/**
 * Modify this implementation of Quicksort.
 * Change the private method quicksort() so it is implemented WITHOUT the two vectors,
 * and it their place uses a single array named "extra".
 * 
 */
public class QuicksortLab {
    
    public void quickSort(int[] arrayToSort)
    {
        sort(arrayToSort, 0, arrayToSort.length - 1);
    }
    
   private static void swap(int[] array, int x, int y) {
	   int temp = array[x];
	   array[x] = array[y];
	   array[y] = temp;
   }
   
   private void sort(int [] array, int lo, int hi) {
	   if (lo < hi) {
		   int pivot = quicksort(array, lo, hi); 
		   sort(array, lo, pivot - 1);
		   sort(array, pivot + 1, hi);
	   }
   }
   
    
   private int quicksort(int[] arrayToSort, int from, int to)
   {
       int pivot = from;
       int pivotValue = arrayToSort[pivot];
       
       int lo = from;
       int hi = to;
       
       while(lo < hi) {
    	   while (lo < arrayToSort.length && arrayToSort[lo] <= pivotValue) {
    		   lo++;
    	   } 
    	   
    	   while (arrayToSort[hi] > pivotValue && hi > 0) {
    		   hi--;
    	   } 
    	   
    	   if (lo < hi) {
    		   swap(arrayToSort, lo, hi);
    	   }
       }
       
       swap(arrayToSort, pivot, hi);
       
       return hi;

    }
   
   public static void main( String [] args) {
	   int[] array = new int[10];
	   
	   Random randomInt = new Random();
	   
	   for (int i = 0; i < array.length; i++) {
		   array[i] = randomInt.nextInt(100);
	   }
	   
	   System.out.println(Arrays.toString(array));
	   
	   QuicksortLab ArraySort = new QuicksortLab();
	   
	   ArraySort.quickSort(array);
	   
	   System.out.println(Arrays.toString(array));
	   
   }
        
}

