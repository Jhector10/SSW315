import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) throws FileNotFoundException { // can also add the exception 
																			// at the top
		// can surround the operation in a try/catch block
		// with the exception being captured and printed
		try {
			Scanner io = new Scanner(new File("test.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
