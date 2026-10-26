import java.util.Arrays;
import java.util.Scanner;

public class Sand {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] arr = new int[100];
		
		Arrays.fill(arr, -1);
		
		int num = 0;
		int count = 0;
		
		System.out.println("Enter numbers, -1 to quit");
		
		while(num != -1)
		{
			num = in.nextInt();
			if(num != -1)
			{
				arr[count] = num;
				count++;
			}
		}
		System.out.println("Your numbers reversed.");
		for(int i = count-1; i >= 0; i--)
		{
			System.out.println(arr[i]);
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
