// Java program to show why collection framework was needed
import java.io.*;
import java.util.*;

class CollectionDemo{
/*	public static void main (String[] args){
		// Creating instances of array, vector and hashtable
		int arr[] = new int[] {1, 2, 3, 4};
		Vector<Integer> v = new Vector();
		Hashtable<Integer, String> h = new Hashtable();
		
		v.addElement(1);
		v.addElement(2);
		h.put(1,"geeks");
		h.put(2,"4geeks");

		// Accessing first element of array, vector and hashtable
		System.out.println(arr[0]);
		System.out.println(v.elementAt(0));
		System.out.println(h.get(1));
	}*/
	
	
	public static void main(String[] args) {
		Collection c;
		c = new ArrayList();
				
		System.out.println(c.getClass().getName());
		
		for (int i=1; i <= 10; i++) { 
			c.add(i + " * " + i + " = "+i*i);
		}
		
		Iterator iter = c.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
	}

}