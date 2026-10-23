import java.util.Iterator;
import java.util.Random;

public class Dice {
	public static Random rand = new Random();	public static int roll4(int i) {
		return roll(i, 4);
	}
	public static int roll6(int i) {
		return roll(i, 6);
	}
	public static int roll8(int i) {
		return roll(i, 8);
	}
	public static int roll10(int i) {
		return roll(i, 10);
	}
	public static int roll12(int i) {
		return roll(i, 12);
	}
	public static int roll20(int i) {
		return roll(i, 20);
	}
	private static int roll(int times, int sides) {
		int sum = 0;
		for (int i = 0; i < times; i++) {
			sum += rand.nextInt(sides)+1;			
		}
		return sum;
	}

}
