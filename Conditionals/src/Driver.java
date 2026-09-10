import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		/*
		 * works for all numeric types x == y ->x is equal to y x != y ->x is not equal
		 * to y x > y ->x is greater than y x < Y ->x is less than y x <= y x >= y
		 */
//		int x = 10;
//		System.out.println("Enter a num");
//		int y = input.nextInt();
//
//		if (x < y) {
//			System.out.println("X is smaller than Y");
//		} else if (x > y) {
//			System.out.println("X is greater than Y");
//		} else {
//			System.out.println("X and Y are equal");
//		}
//
//		if (y > 0) {
//			System.out.println("Y is positive!");
//		} else if (y < 0) {
//			System.out.println("Y is negative");
//		} else {
//			System.out.println("Y is Zero");
//		}
//		if (y % 2 == 0)
//			System.out.println("Y is even");
//		else
//			System.out.println("Y is odd");

		String letGrade = null;

		System.out.println("Enter the numeric grade:");
		int numGrade = input.nextInt();

		if (numGrade >= 90)
			letGrade = "A";
		else if (numGrade >= 80)
			letGrade = "B";
		else if (numGrade >= 70)
			letGrade = "C";
		else if (numGrade >= 60)
			letGrade = "D";
		else
			letGrade = "F";

		System.out.printf("Letter grade = %s%n", letGrade);
		
		System.out.println("Enter a number between 1 and 3");
		int num = input.nextInt();
		
		switch(num)
		{
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three!");
			break;
		default:
			System.out.println("That is not between 1 and 3...");
		}
		String food;
		System.out.println("Enter a fruit or veggie name");
		food = input.next();
		
		switch(food)
		{
			case "apple":
			case "banana":
			case "cherry":
				System.out.println("FRUIT!");
				break;
			case "asparagus":
			case "broccoli":
			case "carrot":
				System.out.println("VEGGIE!");
				break;
		}
		
		System.out.println("Enter a positive even number:");
		num = input.nextInt();
		
		if(num > 0 && num % 2 == 0)
			System.out.println("You did it!");
		else
			System.out.println("Wow, you suck...");		
		
		System.out.println("Enter a positive or an even number:");
		num = input.nextInt();
		
		if(num > 0 || num % 2 == 0)
			System.out.println("You did it!");
		else
			System.out.println("Wow, you suck...");	
		
		/*
		 * !(A && B) is the same as !A || !B
		 * !(A || B) is the same as !A && !B
		 * !(x < 5 && y == 3) is the same as x >= 5 || y != 3
		 */
		
		System.out.println("Enter another number I will tell you if is is a single digit.");
		if(!input.hasNextInt())
			System.out.println("That is not a number!!");
		else
			num = input.nextInt();
		
		System.out.println(isSingleDigit(num));
		
	}

	private static boolean isSingleDigit(int num) {
//		if(num > -10 && num < 10)
//			return true;
//		return false;
		
		return num > - 10 && num < 10;
	}

}
