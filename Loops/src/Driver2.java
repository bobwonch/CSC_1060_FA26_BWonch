import java.util.Scanner;

public class Driver2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = 10;//intializer
		System.out.println("T minus:");
		while(n >= 1)//condition
		{
			System.out.println(n);
			n--;//changer
		}
		System.out.println("Blast-off!!");	
		String again = "y";
		//while(again.equals("y"))
		while(again.charAt(0) == 'y')
		{
			System.out.println("It looks like you did something");
			System.out.println("Want to do it again?");
			again = input.next();
		}
		System.out.println("T minus:");
		for(int i = 10; i > 0; i--)
		{
			System.out.println(i);
			
		}
		System.out.println("Blast-off!!");
		
		for(int i = 2; i <= 8; i += 2)
		{
			System.out.print(i + ", ");
		}
		System.out.println("Who do we appreciate!!");
		
		//nested loops
		
		for(int row = 1;row <= 10; row++)//
		{
			for(int col = 1; col <= 10; col++)
			{
				System.out.printf("%4d", row * col);
			}
			System.out.println();
		}
		
		System.out.println("Roman Alphabet");
		for(char c = 'A';c <= 'Z'; c++)
		{
			System.out.print(c);
		}
		System.out.println();
		
		System.out.println("Greek Alphabet");
		for (int i = 913; i <= 937 ; i++) {
			if(i != 930)
			{
			  System.out.print((char) i);
			}
		}
		System.out.println();
	}

}
