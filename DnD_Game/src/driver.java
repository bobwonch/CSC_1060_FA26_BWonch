
public class driver {

	public static void main(String[] args) {
		Attributes stats = StatRoller.rollStats(null);
		System.out.println("Suggested: " + StatRoller.suggestRace(stats.getStrength(),stats.getDexterity(), stats.getConstitution(), stats.getIntelligence(), stats.getWisdom(), stats.getCharisma()));
		
		Character myChar = new Character("Trebor",Archetype.ROGUE,StatRoller.suggestRace(stats.getStrength(),stats.getDexterity(), stats.getConstitution(), stats.getIntelligence(), stats.getWisdom(), stats.getCharisma()), "Forest Dweller");
		System.out.println(myChar);
		System.out.println(myChar.getStats());
	}

}
