
public class Driver {

	public static void main(String[] args) {
		Attributes stats = StatRoller.rollStats(null);
		System.out.println("Suggested: " + StatRoller.suggestRace(stats.getStrength(),
				stats.getDexterity(), stats.getConstitution(), stats.getIntelligence(), stats.getWisdom(), stats.getCharisma()));
		Character myChar = 
	new Character("Trebor",Archetype.ROGUE, Race.ELF,"Forest Dweller");
		System.out.println(myChar);
		
		
	}

}
