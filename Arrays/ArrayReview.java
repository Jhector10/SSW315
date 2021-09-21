
public class ArrayReview {
	public static void main(String[] args) {
		
		String[] stringArray = new String[10];
		
		String[] stringArray2 = stringArray;
		
		String[] stringArray3 = stringArray.clone();
		
		System.out.println(stringArray[0]);
		
		String[] stringArray1 = {"Alice", "Bob", "Carl", "Donale"};
		
		System.out.println(stringArray1[1]);
		
		stringArray1[1] = "Tom";
		
		System.out.println(stringArray1[1]);
		
		}
	}

