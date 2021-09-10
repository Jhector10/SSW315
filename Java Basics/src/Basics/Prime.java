package Basics;

public class Prime {
    /** Print all primes up to ARGS[0] (interpreted as an
     * integer), 10 to a line. */
    public static void main(String[] args) {
        printPrimes(Integer.parseInt(args[10]));
    }
    
    /** Print all primes up to and including LIMIT, 10 to
     * a line. */
    private static void printPrimes(int limit) {
        /*{ For every integer, x, between 2 and LIMIT, print it if
        isPrime(x), 10 to a line. }*/
        int numP = 0;     /* counting total number of prime numbers printed, for nice layout*/
        
        for (int p = 2; p < limit; p += 1){
        	if (isPrime(p)) {
        		System.out.print(p + " ");
        		numP += 1;
        		if (numP % 10 == 0)
        			System.out.println();  //start from a new line after printing 10 numbers;
        	}
        }
        System.out.println();        
    }
    
    /** True iff X is prime */
    private static boolean isPrime(int x) {
        if (x <= 1)
        	return false;
		else return !isDivisible(x, 2); // means not-prime;
    }
    
    /** True iff X is divisible by any positive number >= k 
     *  and <X, given K > 1. */
    private static boolean isDivisible(int x, int k) {
		int limit = (int) Math.round(Math.sqrt(x));
		for (int j = k; j <= limit; j++){
			if (x % j == 0)
				return true;
		}
		return false;
	}
}
