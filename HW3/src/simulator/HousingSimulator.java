package simulator;

import java.util.ArrayList;
import java.util.Scanner;
import simulator.*;

public class HousingSimulator {
    //Functions for generating random double
    public static double randomDouble(int from, int to) {
        return Math.random() * to + from;
    }

    //Functions for generating random int
    public static int randomInt(int from, int to) {
    return (int) Math.floor(Math.random() * (to-from+1) + from);
    }
    
    public static MyQueue<Student> students = new MyQueue<>();
	public static ArrayList<Apartment> apartments = new ArrayList<>();

	// create of a class that states if all apartments are vacant
	public static boolean AptsVacant() {
		return false;
	}
	
	//To be completed by you
    public static void runSimulation(int k, int N) {
    	// ArrayList<Apartments>
    	// MyQueue<Student> (USE MYQUEUE)
    	
    	for (int i = 0; i < k; i++) {
    		students.offer(new Student(randomDouble(0,1), i));
    	}
    	
    	for (int j = 0; j < N; j++) {
    		apartments.add(new Apartment(randomDouble(0,1), j, 0));
    	}
    	
    	int yearsOfSchool = 0;
    	while (apartments.size() != 0 || students.size() != 0) {
    		
    	}
    	
    }

    //Main method for simulation
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students to run simulation with: ");
        int k = sc.nextInt();

        System.out.print("Enter number of apartments to run simulation with: ");
        int N = sc.nextInt();

        runSimulation(k, N);
    }
}
