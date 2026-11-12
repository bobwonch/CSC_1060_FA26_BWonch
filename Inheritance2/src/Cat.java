
public class Cat extends Animal {

	private String color;
	
	public Cat(int height, int weight, String color) {
		super(height, weight);
		this.color = color;
	}
	
	@Override
	public void makeSound()
	{
		System.out.println("Cats meow");
	}

	@Override
	public String toString() {
		return super.toString() + "Cat [color=" + color + "]";
	}

	
}
