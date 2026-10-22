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

	
	public Attributes(int strength, int dexterity, int constitution,
			int intelligence,int wisdom, int charisma, Race race) {
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

	public int getBonus(int i)
	{
		if(i < 0 || i > 5) 
			throw new IllegalArgumentException("\nIndex must be "
					+ "between 0 and 5");
		return bonuses[i];
	}
	
	private String formatBonus(int bonus)
	{
		if(bonus >= 0)
		{
			return " + " + bonus;
		}else
		{
			return " - " + Math.abs(bonus);
		}
	}
	
	public int getStrength() {return strength;}
	public int getDexterity() {return dexterity;}
	public int getConstitution() {return constitution;}
	public int getIntelligence() {return intelligence;}
	public int getWisdom() {return wisdom;}
	public int getCharisma() {return charisma;}

	@Override
	public String toString() {
		return "Strength: " + strength +  formatBonus(bonuses[0]) 
				+ "\nDexterity: " +	dexterity + formatBonus(bonuses[1]) 
				+ "\nConstitution: " + constitution + formatBonus(bonuses[2])  
				+ "\nintelligence:"	+ intelligence +  formatBonus(bonuses[3])  
				+ "\nWisdom: " + wisdom +  formatBonus(bonuses[4])  
				+ "\nCharisma: " + charisma +  formatBonus(bonuses[5]) ;
	}
}
