package wk5_InClass;

import java.util.Scanner;

public class RightAngleLoop {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int num = getUserNumber();	
		char symbol = getSymbol();
		for (int i = 1; i <= num; i++) {
			for(int k = 0;k < num - i; k++)
			{
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++)
			{
				System.out.print(symbol + " ");
			}
			System.out.println();
		}
	}

	private static char getSymbol() {
		System.out.println("What is the symbol?");
		char sym = input.next().charAt(0);
		return sym;
	}

	private static int getUserNumber() {
		
		System.out.println("How many rows?");
		int num = input.nextInt();
		return num;
	}

}
