import java.util.Scanner;

public class Doubloon {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a word");
		String word = input.next();
		
		word = word.toLowerCase();
		
		if(isDoubloon(word))
		{
			System.out.println(word + " is a Doubloon.");
		}
		else
		{
			System.out.println(word + " is not a Doubloon.");
		}

	}

	private static boolean isDoubloon(String word) {
		int count;
		for (int i = 0; i < word.length(); i++) {
			count = 0;
			for (int j = 0; j < word.length(); j++) {
				if(word.charAt(i) == word.charAt(j))
				{
					count++;
				}
			}			
			if(count != 2) return false;
		}
		return true;
	}

}
