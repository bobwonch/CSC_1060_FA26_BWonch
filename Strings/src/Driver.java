import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
//		System.out.println("Enter a number:");
//		while(!input.hasNextDouble())
//		{
//			String word = input.next();
//			System.err.println(word + " is not a number!");
//			System.err.println("Enter a number");
//		}
//		double num = input.nextDouble();
		
		System.out.println("Enter a single word");
		String word = input.next();
		for(int i = 0; i < word.length(); i++)
		{
			char letter = word.charAt(i);
			System.out.print(letter + "_");
		}
		
		int len = word.length();
		char lastLetter = word.charAt(len - 1);
		
		System.out.println("\n" + word +"'s last letter is " + lastLetter);
		System.out.println(reverse(word));
		
		int midIndex = word.length()/2;
		
		System.out.println(word.charAt(midIndex));
		
		System.out.println(word.charAt(word.indexOf("lo") + word.length()/2));
		
		String subFirst = word.substring(0, midIndex );
		String subLast = word.substring(midIndex);
		System.out.println(subLast + subFirst);
		
		System.out.println(word.substring(2,5));
		
		if(word.equals("bananas"))
		{
			System.out.println("Nanners!");
		}
		
		String name1 = "Alan Turing";
		String name2 = "Ada Lovelace";
		
		int diff = name1.compareTo(name2);
		
		if(diff < 0)
		{
			System.out.println(name1 + " \n" + name2);
		}else if (diff > 0)
		{
			System.out.println(name2 + " \n" + name1);
		}else
		{
			System.out.println("The names are the same.");
		}
		
		String s = timeStringer(10, 15);
		System.out.println(s);
		
	}

	private static String timeStringer(int hour, int min) {
		String ampm;
		if(hour < 12)
		{
			ampm = "AM";
			if(hour == 0)
			{
				hour = 12;
			}
		}else
		{
			ampm = "PM";
			hour -= 12;
		}
		return String.format("%02d:%02d %s", hour, min, ampm);
	}

	private static String reverse(String word) {
		String r = "";
		for(int i = word.length() - 1; i >= 0; i--)
		{
			r += word.charAt(i);
		}
		return r;
	}

}
