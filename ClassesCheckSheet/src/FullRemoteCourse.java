
public class FullRemoteCourse extends OnlineCourse {

	private String email;
	
	public FullRemoteCourse() {
		super();
		email = "";
	}

	public FullRemoteCourse(String courseNum, int numStudents, int maxStudents, int credits, String email) {
		super(courseNum, numStudents, maxStudents, credits);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FullRemoteCourse \nEmail:" + email + "\n" + super.toString();
	}
	
	

}
