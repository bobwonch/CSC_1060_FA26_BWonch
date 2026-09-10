/*
 * For this assignment, you will write a program 
 * that reads in a temperature in Fahrenheit, and 
 * converts it to Celsius and Kelvin. 
 * To convert from Fahrenheit to Celsius, 
 * you should subtract 32, then multiply by 5/9. 
 * To convert from Celsius to Kelvin, you should 
 * simply add 273.15.
 */

import java.util.Scanner;

public class TempConverter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter temperature in F:");
		
		double f = input.nextDouble();
		double c = (f - 32) * 5 / 9;
		double k = c + 273.15;
		
		System.out.printf("%.2fF is %.2fC and %.2fK", f, c, k);

	}

}
