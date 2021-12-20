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
	public static boolean NoAptsVacant() {
		for (int i = 0; i < apartments.size(); i++) {
			if (apartments.get(i).getYearsLeft() != 0) {
				return false;
			}
		}
		return true;
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
    	while (students.size() > 0 || !NoAptsVacant()) {
    		// Print the statistics of the years in school and apartments
    		System.out.println();
    		System.out.println("Year: " + yearsOfSchool);
    		System.out.println();
    		
    		// print the quality of the apts and their IDs
    		for(Apartment apts : apartments) {
    			if(apts.getYearsLeft() == 0) {
    				System.out.println("Apartment " + apts.getIDNum() + ", Quality Score: " + apts.getQuality());
    				System.out.println();
    			}
    		}
    		
    		for (Apartment apts : apartments) {
    			if (students.size() > 0) {
    				Student applicant = students.peek();
    				
    				// if apartment quality is above applicant threshold and it's vacant, applicant accepts
    				if (apts.getQuality() > applicant.getQualityThreshold() && apts.getYearsLeft() == 0) {
    					apts.setYearsLeft(randomInt(1, 3));
    					students.poll();
    					
    					System.out.println("Student " + applicant.getIDNum() + " accepted Apartment " + 
    							applicant.getIDNum() + " after waiting " + applicant.getYearsOnList() + " year. \n" +
    							"The Apartment will be held for " + apts.getYearsLeft() + " years.");
    				} 
    				
    				// check if student rejects the apartment
    				else {
    					System.out.println("Student " + applicant.getIDNum() + " rejected Apartment " + 
    							applicant.getIDNum() + " with quality threshold " + applicant.getQualityThreshold() + ". \n" +
    	    					"The Apartment had a quality of " + apts.getQuality() + ".");
    					
    					applicant.addDesperation(); // multiples student threshold by 0.9
    					applicant.addYear(); // add a year onto the waiting for the applicant
    					students.offer(students.poll()); // dequeue and enqueue the student back on list
    				}
    			}
    		
    		// after each year, decrement the number of years remaining for each apt
    		for (int i = 0; i < apartments.size(); i++) { 
    			int aptYears = apartments.get(i).getYearsLeft();
				if (aptYears > 0) {
					apartments.get(i).setYearsLeft(aptYears - 1);
				}
			}
    		}
    		
    		yearsOfSchool += 1;
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
        
        sc.close();
    }
}
