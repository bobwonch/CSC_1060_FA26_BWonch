
public class Treasure extends Item {
	private final Rarity rarity;
	private final boolean isConsumable;
	
	
	public Treasure(String name, double weight, int value, Rarity rarity, boolean isConsumable) {
		super(name, weight, value);
		this.rarity = rarity;
		this.isConsumable = isConsumable;
	}

	@Override
	public String getDescription() {
		//unary command is like an if/else statement
		String type = isConsumable ? "Consumable" : "Valuable Loot";
		return "[Treasure] \n" + getName() + " is a " + rarity + " " + type + ".";
	}

}
