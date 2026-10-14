import java.util.Iterator;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		/*
		 * Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
		 * 
		 * Initially, let p equal 2, the smallest prime number.
		 * 
		 * Enumerate the multiples of p by counting in increments 
		 * of p from 2p to n, and mark them in the list 
		 * (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
		 * 
		 * Find the smallest number in the list greater than p that is not marked.
		 * If there was no such number, stop. 
		 * 
		 * Otherwise, let p now equal this new number (which is the next prime), 
		 * and repeat from step 3.
		 * 
		 * When the algorithm terminates, the numbers remaining not marked in the
		 *  list are all the primes below n.
		 */
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number you want "
				+ "all of the primes up to.");
		int n = input.nextInt();
		
		int[] values = fillArray(n);
		boolean[] pOrNot = findPrimes(values);
		
		primesPrint(values, pOrNot);
	}

	

	private static void primesPrint(int[] values, boolean[] pOrNot) {
		for (int i = 0; i < pOrNot.length; i++) {
			System.out.printf("%d -> %b%n",values[i], pOrNot[i]);
		}
		
	}

	private static boolean[] findPrimes(int[] values) {
		boolean[] ret = new boolean[values.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = isPrime(i);
		}
		return ret;
	}

	private static boolean isPrime(int n) {
		if(n <= 1)return false;
		if(n == 2)return true;
		if(n % 2 == 0)return false;
		
		for (int i = 3; i * i <= n; i += 2) {
			if(n % i == 0)return false;
		}
		
		return true;
	}

	private static int[] fillArray(int n) {
		int[] a = new int [n];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		return a;
	}

	

}
