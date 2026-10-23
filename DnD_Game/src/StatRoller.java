
public class StatRoller {

	public static Attributes rollStats(Race race) {
		int strength = rollStat();
		int dexterity = rollStat();
		int constitution = rollStat();
		int intelligence = rollStat();
		int wisdom = rollStat();
		int charisma = rollStat();

		return new Attributes(strength, dexterity, constitution, intelligence, wisdom, charisma, race);
	}

	private static int rollStat() {
		int sum = 0;
		int low = 6;
		for (int i = 0; i < 4; i++) {
			int num = Dice.roll6(1);
			if (num < low)
				low = num;
			sum += num;
		}
		return sum - low;
	}

	public static Race suggestRace(int str, int dex, int con, int intel, int wis, int cha) {
		int highest = str;
		
		Race recommended = Race.HUMAN;
		if(dex > highest)
		{
			highest = dex;
			recommended = Race.HALFLING;
		}
		if(con > highest)
		{
			highest = con;
			recommended = Race.DWARF;
		}
		if(intel > highest)
		{
			highest = intel;
			recommended = Race.ELF;
		}
		if(wis > highest)
		{
			highest = wis;
			recommended = Race.HUMAN;
		}
		if(cha > highest)
		{
			highest = cha;
			recommended = Race.HUMAN;
		}
		return recommended;
	}
}
