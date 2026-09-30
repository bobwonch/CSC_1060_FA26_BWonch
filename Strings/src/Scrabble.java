import java.util.Scanner;

public class Scrabble {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		System.out.println("What tiles do you have?");		
		String tiles = input.next();
		
		System.out.println("What are you trying to spell?");		
		String word = input.next();
		
		if(canSpell(tiles, word))
		{
			System.out.printf("You can spell %s with %s", word, tiles);
		}else
		{
			System.out.println(" is not in your tiles");
		}
	
	}

	private static boolean canSpell(String tiles, String word) {
		for(int i = 0; i < word.length(); i++)
		{
			int index = tiles.indexOf(word.charAt(i));
			if(index == -1)
			{
				System.out.printf("%s", word.charAt(i));
				return false;
			}
			tiles = tiles.substring(0,index) + tiles.substring(index + 1);			
		}
		return true;
	}
}
