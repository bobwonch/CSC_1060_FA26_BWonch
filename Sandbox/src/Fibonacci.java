import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1, num2,count;
		num1 = 0;
		num2 = 1;
		int choice;
		
		System.out.println("Which factor of the Fibonacci do you want?");
		count = input.nextInt();
		
		System.out.println("While(1) or For(2)");
		choice = input.nextInt();
		
		if(count >= 1)
		{
			System.out.print(num1 + ", ");
		}
		if(count >= 2)
		{
			System.out.print(num2 + ", ");
		}	
		
		if(choice == 1)
		{
			forFibonacci(count, num1, num2);
		}else
		{
			whileFibonacci(count, num1, num2);
		}
		
		System.out.println("\nAll Done!");		
	}

	private static void whileFibonacci(int count, int num1, int num2) {
		int num3;
		int i = 2;
		while(i < count)
		{	
			num3 = num1 + num2;
			if(i < count -1)
			{
				System.out.print(num3 + ", ");
			}
			else
			{
				System.out.print(num3);
			}
			num1 = num2;
			num2 = num3;
			i++;
		}
		
	}

	private static void forFibonacci(int count, int num1, int num2) {
		int num3;
		for(int i = 2;i < count; i++)
		{	
			num3 = num1 + num2;
			if(i < count -1)
			{
				System.out.print(num3 + ", ");
			}
			else
			{
				System.out.print(num3);
			}
			num1 = num2;
			num2 = num3;
		}
		
	}

}
