//an abstract class can't be implemented on it's own.
//only the concrete sub-classes can create objects
public abstract class Item {
	
	private final String name;
	private final double weight;
	private final int value;
	
	public Item(String name, double weight, int value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
	}
	//every class that extends this class must implement
	public abstract String getDescription();

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return name + "\nweight: " + weight + "\nvalue:" + value;
	}
}
