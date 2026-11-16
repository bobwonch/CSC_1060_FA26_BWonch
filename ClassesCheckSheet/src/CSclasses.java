import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSclasses {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String filename = "courses.txt";		
		ArrayList<Course> courseList = FileHandler.readCourses(filename);
		
		char ans = 'y';
		
		while (ans == 'y') {

			System.out.println("Course number?");
			String crsNum = input.next();

			System.out.println("Number of students?");
			int numStudents = input.nextInt();

			System.out.println("Max students?");
			int maxStudents = input.nextInt();

			System.out.println("Number of credits?");
			int credits = input.nextInt();

			System.out.println("What type of course is this? " + "\n(1) In-person" + "\n(2) Full Online"
					+ "\n(3) Real-Time Remote");
			int type = input.nextInt();

			Course course;

			if (type == 1) {
				System.out.println("What is the room number?");
				String roomNum = input.next();
				course = new InPersonCourse(crsNum, numStudents, maxStudents, credits, roomNum);
			} else if (type == 2) {
				System.out.println("What is the instructors email address?");
				String email = input.next();
				course = new FullRemoteCourse(crsNum, numStudents, maxStudents, credits, email);
			} else {
				System.out.println("What is the Zoom link?");
				String zoomInfo = input.next();
				course = new RealTimeRemoteCourse(crsNum, numStudents, maxStudents, credits, zoomInfo);
			}

			courseList.add(course);
			
			System.out.println("Is there another course to enter?");
			ans = input.next().charAt(0);
		} // End while
		
		FileHandler.writeCourses(courseList, filename);
		
		
		for (Course crse : courseList) {
			getPrint(crse);
			System.out.println("**************************");
		}

	}// end of main

	public static void print(Course course) {
		System.out.println(course);
	}

	public static void getPrint(Course course) {
		String type;
		String addIn;
		String addInType;
		if (course instanceof InPersonCourse) {
			type = "In-Person Course";
			addIn = ((InPersonCourse) course).getRoomNum();
			addInType = "Room Number:";
		} else if (course instanceof RealTimeRemoteCourse) {
			type = "Real-Time-Remote Course";
			addIn = ((RealTimeRemoteCourse) course).getZoomInfo();
			addInType = " Zoom Info:";
		} else {
			type = "Full Remote Course";
			addIn = ((FullRemoteCourse) course).getEmail();
			addInType = "Email:";
		}

		System.out.println(type + "\nCourse Number: " + course.getCourseNum() + "\nNumber of Students: "
				+ course.getNumStudents() + "\nMax Students: " + course.getMaxStudents() + "\nCredits: "
				+ course.getCredits() + "\n" + addInType + addIn);

	}

}
