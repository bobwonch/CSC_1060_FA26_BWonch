import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String word = "";
		while (!word.equals("quit")) {
			System.out.println("Enter a dubloon, or try to anyway...\n"
					+ "Type \"quit\" to exit");
			word = input.next();
			if (isDoubloon(word)) {
				System.out.println(word + " is a doubloon!");
			} else {
				System.out.println(word + " is not a doubloon!");
			}
		}

	}

	private static boolean isDoubloon(String word) {
		int count;
		for (int i = 0; i < word.length(); i++) {
			count = 0;
			for (int j = 0; j < word.length(); j++) {
				if (word.charAt(i) == word.charAt(j))
					count++;
			}
			if (count != 2)
				return false;
		}
		return true;
	}
}
