
public class Dog extends Animal {

	private String breed;
	
	public Dog(int height, int weight, String breed) {
		super(height, weight);
		this.breed = breed;
	}
	@Override
	public void makeSound()
	{
		System.out.println("Dogs bark");
	}

	@Override
	public String toString() {
		return super.toString() + "Dog [breed=" + breed + "]";
	}
	
	

}
