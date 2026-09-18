import java.util.Scanner;

public class Rt_Triangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input number of rows.");
		
		int rows = input.nextInt();
		
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("%3d", j);
			}
			System.out.println();
		}

	}

}
