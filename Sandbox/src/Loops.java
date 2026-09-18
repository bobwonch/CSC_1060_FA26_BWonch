
public class Loops {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 0; i < 10; i++)
		{
			sum += i;
		}
		System.out.println("For loop: " + sum);
		
		int i = 0;
		sum = 0;
		while(i < 10)
		{
			sum += i;
			i++;
		}
		System.out.println("While loop: " + sum);		 

	}

}
