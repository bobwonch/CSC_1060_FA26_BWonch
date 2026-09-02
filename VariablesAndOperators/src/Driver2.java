import java.util.Scanner;

public class Driver2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inch;
		double cm;	
		final double CM_PER_INCH = 2.54;
		String line;
//		System.out.println(System.out);
//		
//		
//		System.out.println("Type something");
//		line = input.nextLine();
//		System.out.println("You said " + line);
//		
//		System.out.println("Type something else");
//		line = input.nextLine();
//		System.out.println("You also said " + line);
//		
		
//		System.out.println("How many inches?");
//		inch = input.nextInt();
//		cm = inch * CM_PER_INCH;
//		System.out.printf("%d inches is %.2f cm\n", inch, cm);
//		
//		System.out.printf("Four thirds is %.2f", 4.0/3.0);
		
//		System.out.println("Enter a whole number");
//		inch = input.nextInt();
//		System.out.println("Enter a real number");
//		cm = input.nextDouble();
//		System.out.println("Enter a word");
//		input.nextLine();
//		line = input.nextLine();
//		
//		System.out.println(cm);
//		cm = (int)cm;
//		System.out.println(cm);
//		
//		System.out.println();
		
		System.out.println("What is your first name?");
		String name = input.next();
		System.out.println("What is your age?");
		int age = input.nextInt();
		System.out.printf("Hello %s you are %d years old", name , age);
		
	}

}
