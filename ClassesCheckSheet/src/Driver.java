import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Course> courseList = new ArrayList<>();
		Course course;
		String again = "yes";
		
		
		while(again.equals("yes"))
		{
			System.out.println("What is the course num?");
			String courseNum = input.next();
			
			System.out.println("How many students?");
			int numStudents = input.nextInt();
			
			System.out.println("Max students?");
			int maxStudents = input.nextInt();
			
			System.out.println("How many credits?");
			int credits = input.nextInt();
			
			System.out.println("What type of course (1) In Person, (2) Full Remote"
					+ "(3)Real-Time Remote");
			int choice = input.nextInt();
			
			if(choice == 1) {
				System.out.println("Room num?");
				String roomNum = input.next();
				course = new InPersonCourse(courseNum, numStudents, maxStudents, credits, roomNum);
				courseList.add(course);
			}else if(choice == 2)
			{
				System.out.println("Email?");
				String email = input.next();
				course = new FullRemoteCourse(courseNum, numStudents, maxStudents, credits, email);
				courseList.add(course);
			}else
			{
				System.out.println("Zoom Info?");
				String zoom = input.next();
				course = new RealTimeRemoteCourse(courseNum, numStudents, maxStudents, credits, zoom);
				courseList.add(course);
			}
			System.out.println("Is there another course to enter?");
			again = input.next();
		}
		input.close();
		for(Course crs : courseList)
		{
			getPrint(crs);
		}
	}
	public static void print(Course course)
	{
		System.out.println(course);
	}
	public static void getPrint(Course course)
	{
		System.out.println("Course Number: " + course.getCourseNum() 
							+ "\nNumber of Students: " + course.getNumStudents());
		if(course instanceof InPersonCourse)
		{
			System.out.println("Room Number:" + ((InPersonCourse)course).getRoomNum());
		}else if(course instanceof FullRemoteCourse)
		{
			System.out.println("Room Number:" + ((FullRemoteCourse)course).getEmail());
		}
	}
	
}
