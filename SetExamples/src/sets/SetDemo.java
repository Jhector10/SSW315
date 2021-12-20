package sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		int count[] = {34, 22, 10, 60, 30, 22};
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		Set<Integer> set = new HashSet<>();

		
		for (int i = 0; i < count.length; i++) {
			arrList.add(count[i]); // add int values as integer objects in collection
			
			set.add(count[i]);
		}
		
		System.out.println("Content of the set is " + set); // the set ignores the duplicate 22 in the array
		System.out.println("Content of the array list is " + arrList);
		
		TreeSet<Integer> set2 = new TreeSet<>(set); // makes it in a ordered list
		
		System.out.println("Content of the tree set is " + set2);
		
		System.out.println("The first element of the the set is " + (Integer) set2.first());
		System.out.println("The last element of the the set is " + (Integer) set2.last());
	}

}
