import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		/*
		 * Create a list of consecutive integers from 
		 * 2 through n: (2, 3, 4, ..., n). 
		 * 
		 * Initially, let p equal 2, the smallest prime number.
		 * 
		 *  Enumerate the multiples of p by counting in increments 
		 *  of p from 2p to n, and mark them in the list(these will be 2p, 
		 *  3p, 4p, ...; the p itself should not be marked). 
		 *  
		 *  Find the smallest number in the list greater than p that is not
		 *  marked.If there was no such number, stop. Otherwise, let p now equal 
		 *  this new number (which is the next prime), and repeat from step 3.
		 *   
		 *   When the algorithm terminates, the numbers remaining not marked 
		 *   in the list are all the primes below n.
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number to see all the primes up to it...");
		int num = input.nextInt();
		
		int[] values = new int[num];
		
		//fillRandArray(values);
		fillArray(values);
	
		boolean[] primeOrNot = findPrimes(values);
		printAllPrimes(values);
		//System.out.println(Arrays.toString(primeOrNot));
	}

	private static void printAllPrimes(int[] values) {
		for (int i = 0; i < values.length; i++) {
			if(isPrime(values[i]))System.out.print(values[i] + ", ");
			if(i != 0 && i % 10 == 0) System.out.println();
		}
		
	}

	private static boolean[] findPrimes(int[] values) {
		boolean[] pOrNot = new boolean[values.length];
		
		for (int i = 0; i < pOrNot.length; i++) {
			pOrNot[i] = isPrime(values[i]);
		}
		return pOrNot;
	}

	private static void fillArray(int[] values) {
		for (int i = 0; i < values.length; i++) {
			values[i] = i;
		}
		
	}

	private static void fillRandArray(int[] values) {
		Random random = new Random();
		
		for(int i = 0; i < values.length; i++)
		{
			values[i] = random.nextInt(1000);
		}
		
	}

	private static boolean isPrime(int n) {
		if(n <= 1) return false;
		if(n == 2)return true;
		if(n % 2 == 0)return false;
		
		for(int p = 3; p * p <= n; p += 2)
		{
			if(n % p == 0) return false;
		}
		return true;
	}

}
