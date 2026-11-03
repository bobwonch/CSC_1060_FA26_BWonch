
public class Cat extends Animal {

	private String color;
	
	public Cat() {
		super();
		color = "Orange";
	}

	public Cat(int height, int weight, String color) {
		super(height, weight);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void sound()
	{
		System.out.println("Cat meows.");
	}
	
	@Override
	public String toString() {
		return "Cat [color=" + color + "] " + super.toString();
	}
	
	
}
