import java.util.Arrays;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner((System.in));
		System.out.println("What level of the Fibonacci do you want?");
		int n =input.nextInt();
		for (int i = 0; i < n; i++) {
			//System.out.println(fib(i));
			System.out.println(fibM(i));
		}
	}

	private static long fibM(int i) {
		long[] memo = new long[i + 1];
		
		Arrays.fill(memo, -1);
		return fibHelper(memo, i);
	}

	private static long fibHelper(long[] memo, int i) {
		if( i <= 1) return i; //if i is 1 or zero return it.
		
		if(memo[i] != -1)return memo[i];//check to see if we have already 
										//solved for this i
		//if we havn't solved for memo[i] yet
		//solve that one instance it i
		memo[i] = fibHelper(memo, i - 1) + fibHelper(memo, i-2);
		
		return memo[i];
	}

	private static int fib(int i) {
		if(i == 0) return 0;
		if(i <= 2)return 1;		
		return fib(i-1) + fib(i-2);
	}

}
