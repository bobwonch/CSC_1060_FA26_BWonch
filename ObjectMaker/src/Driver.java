import java.awt.Point;
import java.awt.Rectangle;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Strings are immutable
		String num = "123";
		
		int number = Integer.valueOf(num);
		number++;
		System.out.println(number);
		Integer num2 = 123;
		
		//Mutable Objects
		
		Point blank;
		blank = new Point(3, 4);
		Point filled = new Point(1, 12);
		
		double dist = blank.distance(filled);
		
		
		System.out.println(blank.y);
		blank.y = 5;
		System.out.println(blank);
		
		System.out.printf("%.3f", dist);
		
		Rectangle rect = new Rectangle(0, 0, 100, 200);
		Rectangle rect2 = rect;
		System.out.println(rect);
		rect2.height = 150;
		System.out.println(rect);
		
		String text = "";
		for(int i = 0; i < 3; i++)
		{
			String line = input.next();
			text = text + line + "\n";
		}
		System.out.println("You entered " + text);
		
		StringBuilder sbText = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			String line = input.next();
			sbText.append(line);
			sbText.append("\n");
		}
		
		System.out.println("You entered " + sbText);
	}

}
