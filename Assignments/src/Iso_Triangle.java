import java.util.Scanner;

public class Iso_Triangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input number of rows.");
		int rows = input.nextInt();
		
		System.out.println("Which symbol");
		
		char symbol = input.next().charAt(0);
		
		for (int i = 1; i <= rows; i++) {
			for(int s = rows - i; s > 0; s--)
			{
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(symbol + " ");
			}
			System.out.println();
		}
	}
}
