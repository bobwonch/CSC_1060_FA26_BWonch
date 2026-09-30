import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("What tiles do you have?");
		String tiles = input.next();
		
		System.out.println("What do you want to spell?");
		String word = input.next();
		
		if(canSpell(tiles, word))
		{
			System.out.printf("You can spell %s with %s.", word , tiles);
		}else
		{
			System.out.println(" is missing from your tiles");
		}

	}

	private static boolean canSpell(String tiles, String word) {
		for(int i = 0; i < word.length(); i++)
		{
			int index = tiles.indexOf(word.charAt(i));
			if (index < 0) 
			{
				System.out.print(word.charAt(i));
				return false;
			}
			
			tiles = tiles.substring(0, index) + tiles.substring(index +1);	
		}
		return true;
	}

}
