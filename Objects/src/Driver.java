import java.awt.Point;
import java.awt.Rectangle;
import java.math.BigInteger;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String num = "123";
		
		int myNum = Integer.valueOf(num);
		
		myNum++;
		
		System.out.println(myNum);
		
		Integer num2 = 123;
		System.out.println(num2 == myNum);
		
		BigInteger bigNum = BigInteger.valueOf(102*93854*91283745*893274);
		System.out.println(bigNum);
		
		Point blank = new Point(3,4);
		
		blank.x = 4;
		System.out.println(blank);
		Point made = new Point(1, 12);
		
		double dist = blank.distance(made);
		System.out.println(dist);
		
		Rectangle myRect = new Rectangle(0,0, 100, 200);
		Rectangle rect2 = myRect;
		
		rect2.x = 300;
		System.out.println(myRect);
		
		String text = "";
		System.out.println("Enter three words each followed by an enter");
		for(int i = 0; i < 3; i++)
		{
			String line = input.next();
			text = text + line + "\n";
		}
		System.out.println(text);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			String line = input.next();
			sb.append(line);
			sb.append("\n");			
		}
		System.out.println(sb);
	}

}
