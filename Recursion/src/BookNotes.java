
public class BookNotes {

	public static void main(String[] args) {
		for(int i = 0; i < 21; i++)
		{
			System.out.print(fibonacci(i));
			if(i < 20)System.out.print(", ");
		}
		System.out.println();
		countDown(10);
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
