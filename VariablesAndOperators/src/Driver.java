
public class Driver {

	public static void main(String[] args) throws InterruptedException {
		String message;
		char letter;
		int x = 10;
		float real = 9.9f;
		double y = 99.9; 
		
		message = "Hello World!";
		letter = 'c';
		
		String fName = "Bob";
		String lName = "Wonch";
		int hour, minute;
		hour = 6;
		minute = 30;
		
		System.out.println(fName + hour + minute);
		System.out.print("Number of minutes since noon:");
		System.out.println(hour * 60 + minute);
		
		double half = 1 / 2;
		System.out.println(half);
		System.out.println("////////////////////////////////////");
		System.out.println(.1 * 10);
		System.out.println(.1 + .1 + .1 +.1 + .1 +
						    .1 + .1 + .1 + .1 + .1);
		//System.out.println(1/0);
		x = 10;
		System.out.println(999999999.0 * 999999999);
//		while (true)
//		{
//			
//			
//			Thread.sleep(333);
//		}
		 
	}

}
