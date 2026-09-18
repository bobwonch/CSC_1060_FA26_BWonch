
public class Sand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printThreeTimes("World");
		System.out.println(add(2,3));
		String word = "banana";
		for(char letter : word.toCharArray())
		{
			System.out.println(letter);
		}
		

	}

	private static int add(int i, int j) {
		// TODO Auto-generated method stub
		return i + j;
	}

	private static void printThreeTimes(String s) {
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
	}

}
