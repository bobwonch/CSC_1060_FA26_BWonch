import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
	
	public static void writeCourses(ArrayList<Course>courseList, String filename)
	{
		try(PrintWriter write = new PrintWriter(filename))
		{
			for(Course crs : courseList)
			{
				String baseData = crs.getCourseNum() + ","
								+ crs.getNumStudents() + ","
								+ crs.getMaxStudents() + ","
								+ crs.getCredits() + ",";
				if(crs instanceof InPersonCourse) {
					InPersonCourse ipc = (InPersonCourse) crs;
					write.println("IN_PERSON," + baseData + ipc.getRoomNum());
				}else if(crs instanceof FullRemoteCourse)
				{
					FullRemoteCourse frc = (FullRemoteCourse) crs;
					write.println("FULL_REMOTE," + baseData + frc.getEmail());
				}else if(crs instanceof RealTimeRemoteCourse)
				{
					RealTimeRemoteCourse rtrc = (RealTimeRemoteCourse)crs;
					write.println("REAL_TIME," + baseData + rtrc.getZoomInfo());
				}		  
			}
			System.out.println("Courses successfully written to " + filename);
	}catch(FileNotFoundException e)
		{
			System.out.println("Error: Could not write to the file " + filename);
		}
	}

	public static ArrayList<Course> readCourses(String filename)
	{
		ArrayList<Course> courselist = new ArrayList<Course>();
		File file = new File(filename);
		if(!file.exists())
		{
			System.out.println("File doesn't exist, starting from scratch!");
			return courselist;
		}
		try(Scanner in = new Scanner(file))
		{
			while(in.hasNextLine())
			{
				String line = in.nextLine();
				String[] parts = line.split(",");
				
				if(parts.length == 6)
				{
					String type = parts[0];
					String courseNum = parts[1];
					int numStudents = Integer.parseInt(parts[2]);
					int maxStudents = Integer.parseInt(parts[3]);
					int credits = Integer.parseInt(parts[4]);
					String extra = parts[5];
					
					if(type.equals("IN_PERSON"))
					{
						courselist.add(new InPersonCourse(courseNum, numStudents, maxStudents, credits, extra));
					}else if (type.equals("FULL_REMOTE"))
					{
						courselist.add(new FullRemoteCourse(courseNum, numStudents, maxStudents, credits, extra));
					}else if (type.equals("REAL_TIME"))
					{
						courselist.add(new RealTimeRemoteCourse(courseNum, numStudents, maxStudents, credits, extra));
					}
				}
			}
			System.out.println("Loaded " + courselist.size() + " course from " + filename);
			
		} catch (FileNotFoundException e) {
			// catch the error
			System.out.println("Error " + filename + " not found.");
		}
		return courselist;
	}	
}
