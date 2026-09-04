import java.util.Scanner;

public class GasPump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String card = "y";
		String phone = "333-333-4444";
		String grade = "Mid-Grade";
		double gallons = 22.45;
		
		
		final String LINE = "*****************************************************************************";
		final String WALL = String.format("%-76s*\n", "*");
		final String PAGE = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n";
		
		//Asks if the customer is a loyalty card holder
		
//		System.out.println(LINE);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		
//		System.out.printf("*%53s %23s", "Are you a loyalty card holder? y/n", "*\n");
//		
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.println(LINE);
//		
//		card = input.next();
//		
//		System.out.println(PAGE);
//		
//		//gets phone number associated with the loyalty card
//		
//		System.out.println(LINE);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		
//		System.out.printf("*%48s %28s", "Enter your phone number", "*\n");
//		
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.println(LINE);
//		
//		phone = input.next();
//		
//		System.out.println(PAGE);
//		
//		//Gets the grade of the gas regular, mid, premium
//		
//		System.out.println(LINE);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		
//		System.out.printf("*%51s %25s", "Regular, Mid-Grade, or Premium", "*\n");
//		
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.println(LINE);
//		
//		grade = input.next();
//		
//		System.out.println(PAGE);
//		
//	//Gets the grade of the gas regular, mid, premium
//		
//		System.out.println(LINE);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		
//		System.out.printf("*%51s %25s", "How many gallons?", "*\n");
//				
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.printf(WALL);
//		System.out.println(LINE);
//		
//		gallons = input.nextDouble();
//		
//		System.out.println(PAGE);
		
	//Output
		grade = "Premium";
		System.out.println(LINE);
		System.out.printf(WALL);
		System.out.printf(WALL);
		System.out.printf(WALL);
		System.out.printf(WALL);
		
		System.out.printf("*%51s %25s", "Thank for your purchase!", "*\n");
		System.out.printf("*%42s %34s", "DETAILS:", "*\n");
		System.out.print(WALL);
		System.out.printf("*%49s %s %25s", "Loyalty Car Holder:", card, "*\n");
		System.out.printf("*%41s %-23s %11s", "Phone Number: ", phone, "*\n");
		System.out.printf("*%41s %-9s %25s", "Fuel Grade: ", grade, "*\n");
		System.out.printf("*%46s %.2f %24s", "Number of gallons: ", gallons, "*\n");
		
		System.out.printf(WALL);
		System.out.printf(WALL);
		System.out.printf(WALL);
		System.out.printf(WALL);
		System.out.println(LINE);
		
		grade = input.next();
		
		System.out.println(PAGE);
	}

}
