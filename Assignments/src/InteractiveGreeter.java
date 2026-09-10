import java.util.Scanner;

public class InteractiveGreeter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your first name?");
		String name = input.next();
		
		System.out.println("What is your age?");
		String age = input.next();
		
		System.out.println("Where are you from?");
		String hometown = input.next();
		
		System.out.printf("Hello %s, from %s who is %s-years-old\n"
		+ "What is something your like to do in your freetime?", name, hometown, age);
		//gets the left over "enter" character 
		//out of the buffer
		input.nextLine();
		String hobby = input.nextLine();
		
		System.out.printf("\nHave fun next time you %s!", hobby);
	}

}
