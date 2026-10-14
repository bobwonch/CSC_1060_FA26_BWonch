import java.util.Random;

public class Dice {
	 static Random rand = new Random();
	
	public static int roll4(int T)
	{
		int sum = 0;
		for(int i = 0; i < T; i++)
		{
			sum += rand.nextInt(4)+ 1;
		}
		return sum;
	}
	public static int roll6(int T)
	{
		int sum = 0;
		for(int i = 0; i < T; i++)
		{
			sum += rand.nextInt(6)+ 1;
		}
		return sum;
	}
	public static int roll8(int T)

	{
		int sum = 0;
		for(int i = 0; i < T; i++)
		{
			sum += rand.nextInt(8)+ 1;
		}
		return sum;
	}	
	public static int roll10(int T)
	{
		int sum = 0;
		for(int i = 0; i < T; i++)
		{
			sum += rand.nextInt(10)+ 1;
		}
		return sum;
	}
	public static int roll12(int T)
	{
		int sum = 0;
		for(int i = 0; i < T; i++)
		{
			sum += rand.nextInt(12)+ 1;
		}
		return sum;
	}	
	public static int roll20(int T)
	{
		int sum = 0;
		for(int i = 0; i < T; i++)
		{
			sum += rand.nextInt(20)+ 1;
		}
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
