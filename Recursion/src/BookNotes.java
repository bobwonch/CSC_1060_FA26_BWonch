import java.util.Arrays;

public class BookNotes {

	public static void main(String[] args) {
		for(int i = 0; i < 100; i++)
		{
			//System.out.print(fibonacci(i));
			System.out.print(fibM(i));
			System.out.print(", ");
			if(i % 10 == 0) System.out.println();
		}
		System.out.println();
		//countDown(10);
	}
		
	private static long fibM(int n) {
		//an array that will hold the calculated values
		long[] memo = new long[n+1];
		
		Arrays.fill(memo, -1);
		
		return fibHelper(n, memo);
	}

	private static long fibHelper(int n, long[] memo) {
		if(n <= 1) return n;
		
		if(memo[n] != -1)return memo[n];
		
		memo[n] = fibHelper(n-1, memo) + fibHelper(n-2, memo);
		   
		return memo[n];
	}

	private static void countDown(int i) {
		
		if(i == 0)System.out.println("Blast off!!");
		else countDown(i - 1);
		System.out.println(i);
	}

	public static int fibonacci(int n) {
		if ( n == 0) return 0;
	    if (n == 1 || n == 2) {
	        return 1;
	    }
	    return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
