import java.awt.im.InputContext;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("First line.");
		threeLine();
		System.out.println("Second line.");
		printTwice("Don't make me say it again!");
		printTime(9, 45);
		
		double num = 17;
		double root = Math.sqrt(num);
		double angle = 1.5;
		double height = Math.sin(angle);
		double rounded = Math.round(Math.PI * 20);
		double power = Math.pow(2.0,  10.0);
		
		System.out.printf("num = %.2f%nroot = %.2f\nangle = %.2f\nheight = %.2f\nrounded = %.2f\npower = %.2f\n ",num, root, angle, height, rounded, power);
		angle = 180;
		System.out.println(Math.cos(angle + Math.PI / 2.0));
		
		System.out.println("Enter two numbers");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		System.out.println(mult(num1, num2));
		
	}
	
	private static int mult(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	private static int add(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}

	//Methods
	
	public static void printTime(int hour, int minute)
	{
		System.out.println(hour + ":" + minute);
	}
	
	public static void newLine()
	{
		System.out.println();
	}
	
	public static void threeLine()
	{
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public static void printTwice(String s)
	{
		System.out.println(s);
		System.out.println(s);
	}
}
