import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = 0;
		System.out.println("Enter a number");
		n = input.nextInt();

		while (n < 4) {
			System.out.println("Enter a higher num");
			n = input.nextInt();
		}

		n = 10;
		while (n > 0) {
			System.out.println(n);
			n--;
		}
		System.out.println("Blast-off!");

		char c = 'A';
		while (c <= 'Z') {
			System.out.print(c + ", ");
			c++;
		}
		System.out.println("\n///////////////////////");
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			if (ch != 'Z')
				System.out.print(ch + ", ");
			else
				System.out.println(ch);
		}
		newLines(20);
		makeTable(100, 100);
		int sum = 0;
		for(int num = 0; num < 10; num++)
		{
			sum += num;
		}
		System.out.println(sum);
		
		sum = 0;
		int num2 = 0;//Initializer 
		while(num2 < 10)//condition
		{
			sum += num2;
			num2++; //changer
		}
		System.out.println(sum);
		
	}

	private static void makeTable(int i, int j) {
		for (int row = 1; row <= i; row++) {
			for (int col = 1; col <= j; col++) {
				if (i * j < 999) {
					System.out.printf("%4d", row * col);
				} else {
					System.out.printf("%6d", row * col);
				}
			}
			System.out.println();
		}

	}

	private static void newLines(int l) {
		for (int i = 0; i < l; i++) {
			System.out.println();
		}

	}

}
