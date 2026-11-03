public class Animal {
	private int height;
	private int weight;

	public Animal() {
		this.height = 0;
		this.weight = 0;
	}

	public Animal(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void sound()
	{
		System.out.println("Animal makes a noise");
	}

	@Override
	public String toString() {
		return "Animal [height=" + height + ", weight=" + weight + "]";
	}
	
	
}
