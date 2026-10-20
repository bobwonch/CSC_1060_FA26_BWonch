import java.util.Random;

public class Attributes {
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	//stat bonus
	private int[] bonuses = new int[6];

	
	public Attributes(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		addBonus();
	}

	private void addBonus() {
		bonuses[0] = (int) Math.floor((strength - 10)/2.0);
		bonuses[1] = (int) Math.floor((dexterity - 10)/2.0);
		bonuses[2] = (int) Math.floor((constitution - 10)/2.0);
		bonuses[3] = (int) Math.floor((intelligence - 10)/2.0);
		bonuses[4] = (int) Math.floor((wisdom - 10)/2.0);
		bonuses[5] = (int) Math.floor((charisma - 10)/2.0);	
	}

	private int rollStat() {
		int sum = 0;
		int low = 6;
		for (int i = 0; i < 4; i++) {
			int num = Dice.roll6(1);
			if(num < low)low = num;
			sum += num;
		}
		return sum - low;
	}

	public int getBonus(int i)
	{
		if(i < 0 || i > 5) 
			throw new IllegalArgumentException("\nIndex must be between 1 and 5");
		return bonuses[i];
	}
	
	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	@Override
	public String toString() {
		return "Strength: " + strength + 	" + " + bonuses[0] 
				+ "\nDexterity: " +	dexterity + " + " + bonuses[1] 
				+ "\nConstitution: " + constitution + " + " + bonuses[2] 
				+ "\nintelligence:"	+ intelligence + " + " + bonuses[3] 
				+ "\nWisdom: " + wisdom + " + " + bonuses[4] 
				+ "\nCharisma: " + charisma + " + " +  bonuses[5];
	}
}
