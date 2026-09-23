import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String one = "hello";
		String two = "hello";
		String three = input.next();
		three = three.toLowerCase();
		if(one.equals(three))System.out.println("They are the same");
		else System.out.println("They are not the same");
		
		String fruit = "bananas";
		
		for(int i = 0; i < fruit.length(); i++)
		{
			char letter = fruit.charAt(i);
			System.out.print(letter + "_");
		}
		System.out.println();
		String backwards = reverse(fruit);
		System.out.println(backwards);
		System.out.println(fruit.indexOf('a'));
		String small = fruit.substring(0,fruit.indexOf('a'))+
				fruit.substring(fruit.indexOf('a')+1);
		System.out.println(small);
		
		String name1 = "Ada Lovelace";
		String name2 = "Ada Lovelace";
		
		int diff = name1.compareTo(name2);
		System.out.println(diff);
		if(diff < 0)
		{
			System.out.println(name1 +" is before " + name2);
		}
		else if (diff > 0)
		{
			System.out.println(name2 +" is before " + name1);
		}
		else
		{
			System.out.println("The names are the same!");
		}
		int hour = 18;
		int minute = 57;
		String time = timeString(hour, minute);
		System.out.println(time);
				
	}

	private static String timeString(int hour, int minute) {
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
			hour = hour - 12;
		}
		return String.format("%02d:%02d %s", hour, minute, ampm);
	}

	private static String reverse(String fruit) {
		String ret = "";
		for(int i = fruit.length()-1; i >= 0; i--)
		{
			ret += fruit.charAt(i);
		}
		return ret;
	}

}
