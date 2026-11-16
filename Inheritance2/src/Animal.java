public class Animal {
	private int height;
	private int weight;
	
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

	public void makeSound()
	{
		 System.out.println("Animals make sounds");
	}
	@Override
	public String toString() {
		return "Animal [height=" + height + ", weight=" + weight + "]";
	}
	
	

}
