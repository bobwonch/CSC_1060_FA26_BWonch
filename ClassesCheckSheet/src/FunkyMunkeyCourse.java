
public class FunkyMunkeyCourse extends Course {
	String fruit;

	public FunkyMunkeyCourse() {
		super();
		fruit = "";
	}

	public FunkyMunkeyCourse(String courseNum, int numStudents, int maxStudents, int credits,String fruit) {
		super(courseNum, numStudents, maxStudents, credits);
		this.fruit = fruit;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	@Override
	public String toString() {
		return "FunkyMunkeyCourse \nFruit:" + fruit + super.toString();
	}
	
	
}
