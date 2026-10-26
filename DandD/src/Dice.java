import java.util.Random;

public class Dice {
	 static Random rand = new Random();
	
	public static int roll4(int T)
	{
		int sum = roll(T, 4);		
		return sum;
	}
	public static int roll6(int T)
	{
		int sum = roll(T, 6);
		return sum;
	}
	public static int roll8(int T)
	{
		int sum = roll(T, 8);
		return sum;
	}	
	public static int roll10(int T)
	{
		int sum = roll(T, 10);
		return sum;
	}
	public static int roll12(int T)
	{
		int sum = roll(T, 12);
		return sum;
	}	
	public static int roll20(int T)
	{
		int sum = roll(T, 20);
		return sum;
	}
//variable
	public static int roll(int t, int sides)
	{
		int sum = 0;
		for(int i = 0; i < t; i++)
		{
			sum += rand.nextInt(sides)+ 1;
		}
		return sum;
	}

}
