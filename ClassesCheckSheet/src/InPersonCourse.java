
public class InPersonCourse extends Course {
	
	private String roomNum;
	
	public InPersonCourse() {
		super();
		roomNum = "";
	}

	public InPersonCourse(String courseNum, int numStudents, int maxStudents, int credits, String roomNum) {
		super(courseNum, numStudents, maxStudents, credits);
		this.roomNum = roomNum;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	@Override
	public String toString() {
		return "In Person Course \nRoom:" + roomNum + "\n" + super.toString();
	}
	
	
}
