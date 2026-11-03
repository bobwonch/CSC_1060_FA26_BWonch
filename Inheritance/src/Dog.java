
public class Dog extends Animal{
	private String breed;

	public Dog() {
		super();
		breed = "";
	}

	public Dog(int height, int weight, String breed) {
		super(height, weight);
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public void sound()
	{
		System.out.println("Dog barks");
	}
	
	@Override
	public String toString() {
		return "Dog [breed=" + breed + "] " + super.toString();
	}
	
	

}
