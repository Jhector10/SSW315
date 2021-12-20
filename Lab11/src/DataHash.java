import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataHash {

	public static void main(String[] args) throws FileNotFoundException { // can also add the exception 
		
		File text = new File("/Users/joshuahector/Downloads/School Classes/SSW315/Lab11/src/huckleberry_short.txt");
		File text2 = new File("/Users/joshuahector/Downloads/School Classes/SSW315/Lab11/src/linuxwords_rand.txt");
		File text3 = new File("/Users/joshuahector/Downloads/School Classes/SSW315/Lab11/src/linuxwords.txt");
			
		Scanner io = new Scanner(text);
		Scanner io2 = new Scanner(text2);
		Scanner io3 = new Scanner(text3);
		
		QuadraticProbingHashTable Scan = new QuadraticProbingHashTable();
		QuadraticProbingHashTable Scan2 = new QuadraticProbingHashTable();
		QuadraticProbingHashTable Scan3 = new QuadraticProbingHashTable();
		
		while (io.hasNext()) {
			Scan.insert(new MyInteger(Scan.hash(io.nextLine(), Scan.getTable().length)));
		}
		
		while (io2.hasNext()) {
			Scan2.insert(new MyInteger(Scan2.hash(io2.nextLine(), Scan2.getTable().length)));
		}
		
		while (io3.hasNext()) {
			Scan3.insert(new MyInteger(Scan3.hash(io3.nextLine(), Scan3.getTable().length)));
		}
		
		System.out.println("Huckleberry Probe Count: " + Scan.getProbeCount());
		System.out.println("Huckleberry Probe Count: " + Scan3.getProbeCount());
		System.out.println("Huckleberry Probe Count: " + Scan3.getProbeCount());
		

	}
}
