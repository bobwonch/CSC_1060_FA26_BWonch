import java.util.Scanner;

public class Fibonacci2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What factor of fibonacci do you want?");
		
		
		int count = input.nextInt();
		
		int num1 = 0;
		int num2 = 1;
		if(count >= 1)
		{
			System.out.print(num1 + ", ");
		}
		if(count >= 2)
		{
			System.out.print(num2 + ", ");
		}
		for(int i = 3; i <= count; i++)
		{
			int num3 = num1 + num2;
			System.out.print(num3 +", ");
			num1 = num2;
			num2 = num3;
			if(i % 10 == 0)
			{
				System.out.println();
			}
		}
		
		

	}

}
