
public class Arrays {
	
	public static boolean isPrime(int n) {
		//isPrime using white loop
		int divisor = 2;
		while (divisor < n) {
			if (n % divisor == 0) {
				return false;
			}
			divisor++;
		}
		return true;
	}
	
	public static boolean isPrime2(int n) {
	//isPrime using for loop
	for (int divisor = 2; divisor < n; divisor++) {
		if (n % divisor == 0) {
			return false;
		}
	}
	return true;
}
	
	// Declaring Array Variables
	
	double[] data = new double[10];
	/** Left: Declaring a double Array variable, and 
	 * Right: use "new" to construct a new array of a specific 
	 * number of doubles
	 * @param args
	 */
	
	// Cloning arrays
	
	// Shallow Copy
	double[] price = data;
	
	// Deep Copy
	double[] prices = (double[])data.clone();
	
	public static void printPrimes3(int n) {
		boolean[] prime = new boolean[n + 1]; 
		int i;
		for (i = 2; i <= n;  i++) {
			prime[i] = true;
		}
		
		for (int divisor = 2; divisor * divisor <=n; divisor++) {
			if (prime[divisor]) {
				for (i = 2 * divisor; i <= n; i = i * divisor) { // i  is divisble by divisor
					prime[i] = false;
				}
			}
		}
		
		for (i = 2; i <= n; i++) {
			if (prime[i]) {
				System.out.print(" " + i);
			}
		}
		
		System.out.println();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
