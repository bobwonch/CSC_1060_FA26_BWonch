import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int feet;
		int inch;
		int inches;
		double cm;
		final double CM_PER_INCH = 2.54;
		
//		System.out.println("Type something");
//		String line = input.nextLine();
//		System.out.println("You said " + line);
//		
//		System.out.println("Type something else");
//		line = input.nextLine();
//		System.out.println("Now you said " + line);
		
//		System.out.println("Enter inches");
//		inch = input.nextInt();
//		
//		cm = inch * CM_PER_INCH;//no more magic number
//		System.out.println("Centimeters: " + cm);
		
//		System.out.println(4.0/3);
//		System.out.printf("%s = %.2f","Four thirds", 4.0/3);
//		System.out.println("Enter a whole number");
//		int num = input.nextInt();
//		
//		System.out.println("Enter a real number");
//		double real = input.nextDouble();
//		
//		System.out.println("Enter a single character");
//		char ch = input.next().charAt(0);
//		
//		System.out.println("Enter a word");
//		String word = input.next();
//		input.nextLine();
//		System.out.println("Enter a sentence");
//		String words = input.nextLine();	
		
		System.out.println("Enter inches");
		inch = input.nextInt();
		feet = inch / 12;
		inches = inch % 12;
		
		System.out.printf("%d'%d\"",feet,inches);
	}
}
