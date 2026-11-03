
public class Weapon extends Item {
	private final int diceCount;
	private final int diceSides;
	private final DamageType damageType;	
	
	public Weapon(String name, double weight, 
			int value, int diceCount, int diceSides,
			DamageType damageType) {
		
		super(name, weight, value);
		this.diceSides = diceSides;
		this.diceCount = diceCount;
		this.damageType = damageType;
	}

	@Override
	public String getDescription() {
		return "[Weapon] \n" + getName() + " deals " + 
				diceCount + "d" + diceSides + " " + 
				damageType + " damage.";
	}
	
	public int rollDamage() {
		return Dice.roll(diceCount, diceSides);
	}

}
