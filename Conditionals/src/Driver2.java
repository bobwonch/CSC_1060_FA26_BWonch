import java.util.Scanner;

public class Driver2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/*
		 * relational operators
		 * 
		 * x == y -> x is equal to y x != y -> x not equal y x > y x < y x >= y x <= y
		 * 
		 * logical operators && -> and || -> or ! -> not
		 */
		System.out.println("Enter a number");
		int num = input.nextInt();
		if (num > 0) {
			System.out.println("The number is positive");
			System.out.println("We don't know yet, if it is even or odd");
		} else if (num < 0) {
			System.out.println("The number is negative");
		} else {
			System.out.println("The number is zero");
		}

		if (num % 2 == 0) {
			System.out.println("The number is even");
		} else
			System.out.println("The number is odd");
		
		System.out.println("Enter the numeric grade:");
		int grade = input.nextInt();
		String letter;
		
		if(grade >= 90)
		{
			letter = "A";
		}else if (grade >= 80)
		{
			letter = "B";
		}else if (grade >= 70)
		{
			letter = "C";
		}else if (grade >= 60)
		{
			letter = "D";
		}else 
		{
			letter = "F";
			if(grade == 42)
			{
				letter = " the answer to life, the universe, and everything";
			}
		}
		System.out.printf("Your letter grade is %s%n", letter);
		
		System.out.println("Enter a number between 1 and 3");
		num = input.nextInt();
		String word;
		
		switch(num)
		{
		case 1://switch on
			word = "one";
			break;
		case 2:
			word = "two";
			break;
		default:
			word = "three";
		}
		System.out.println(word);
		
		String food = "asparagus";
		switch (food) {
		    case "apple":
		    case "banana":
		    case "cherry":
		        System.out.println("Fruit!");
		        break;
		    case "asparagus":
		    case "broccoli":
		    case "carrot":
		        System.out.println("Vegetable!");
		        break;
		}
		
		int x = 0;
		int y = 0;
		if(x == 0 || y == 0)
		{
				System.out.println("Either x or y or both are zero");
		}
		/*
		 * !(A && B) is the same as !A || !B
		 * !(A || B) is the same as !A && !B
		 * 
		 */
		
		if(isSingleDigit(9))
		{
			System.out.println("It is a single digit");
		}
		else
		{
			System.out.println("It's not a single digit");
		}
		
		double real;
		
		System.out.println("Enter a number it can be a double");
		if(!input.hasNextDouble())
		{
			word = input.next();
			System.err.println(word + " is not a number");
		}
	}

	private static boolean isSingleDigit(int i) {
		// TODO Auto-generated method stub
		
		return i > -10 && i < 10;
	}

}
