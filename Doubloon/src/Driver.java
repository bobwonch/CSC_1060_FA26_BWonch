import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a dubloon, or try to anyway...");
		String word = input.next();
		if(isDoubloon(word))
		{
			System.out.println(word + " is a doubloon!");
		}
		else
		{
			System.out.println(word + " is not a doubloon!");
		}

	}

	private static boolean isDoubloon(String word) {
		int count;
		
		return false;
	}

}
