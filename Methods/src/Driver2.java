
public class Driver2 {

	public static void main(String[] args) {
		double root = Math.sqrt(17);
		double angle = 1.5;
		double height = Math.sin(angle);
		long rounded = Math.round(Math.PI * 20);
		double power = Math.pow(2.0, 10.0);
		System.out.println(Math.max(20, 21));
		
		System.out.printf("%.2f %n %.2f %n %.2f %n %d %n %.2f %n", root,angle,height,rounded,power);
		
		
		
		System.out.println("Line one");
		newLine();
		newLine();
		System.out.println("Line two");
		threeLine();
		System.out.println("Line three");
		printTwice("Don't make me say this again!");
		
		printTime(6,  37);
		
		int sum = add(3, 4);
		System.out.println(sum);
		
		double diam = findDiam(10.0);
		System.out.println(diam);
	}
	
	private static double findDiam(double r) {
		// TODO Auto-generated method stub
		return 2 * r;
	}

	public static int add(int i, int j) {
		// TODO Auto-generated method stub
		return i + j;
	}



	public static void printTime(int hour, int min) {
		System.out.print(hour);
		System.out.print(":");
		System.out.println(min);		
	}
	
	public static void printTwice(String s) {
		System.out.println(s);
		System.out.println(s);
	}
	
	public static void threeLine()
	{
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public static void newLine() {
		System.out.println();
	}
}
