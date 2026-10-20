
public class StatRoller {

	public static Attributes rollStats()
	{
		int strength = rollStat();
		int dexterity = rollStat();
		int constitution = rollStat();
		int intelligence = rollStat();
		int wisdom = rollStat();
		int charisma = rollStat();
		
		return new Attributes(strength, dexterity, 
				constitution,intelligence, wisdom, charisma);
	}
	private static int rollStat() {
		int sum = 0;
		int low = 6;
		for (int i = 0; i < 4; i++) {
			int num = Dice.roll6(1);
			if(num < low)low = num;
			sum += num;
		}
		return sum - low;
	}
}
