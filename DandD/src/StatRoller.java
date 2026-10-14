import java.util.Random;

public class StatRoller {
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	//stat bonus
	private int[] bonuses = new int[6];

	public StatRoller() {
		this.strength = rollStat();
		this.dexterity = rollStat();
		this.constitution = rollStat();
		this.intelligence = rollStat();
		this.wisdom = rollStat();
		this.charisma = rollStat();
		
		addBonus();
	}

	private void addBonus() {
		bonuses[0] = (strength - 10)/2;
		bonuses[1] = (dexterity - 10)/2;
		bonuses[2] = (constitution - 10)/2;
		bonuses[3] = (intelligence - 10)/2;
		bonuses[4] = (wisdom - 10)/2;
		bonuses[5] = (charisma - 10)/2;		
	}

	private int rollStat() {
		Random rand = new Random();
		int sum = 0;
		int low = 6;
		for (int i = 0; i < 4; i++) {
			int num = rand.nextInt(6) + 1;
			if(num < low)low = num;
			sum += num;
		}
		return sum - low;
	}

	private int getBonus(int i)
	{
		if(i > 5)System.out.println("Must be less that 6");
		else return bonuses[i];
		return 0;
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
		return "StatRoller: \nStrength: " + strength + 	" + " + bonuses[0] 
				+ "\nDexterity: " +	dexterity + " + " + bonuses[1] 
				+ "\nConstitution: " + constitution + " + " + bonuses[2] 
				+ "\nintelligence:"	+ intelligence + " + " + bonuses[3] 
				+ "\nWisdom: " + wisdom + " + " + bonuses[4] 
				+ "\nCharisma: " + charisma + " + " +  bonuses[5];
	}
}
