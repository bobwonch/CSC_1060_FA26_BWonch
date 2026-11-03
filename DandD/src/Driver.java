import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		Attributes stats = StatRoller.rollStats(null);
		System.out.println("Suggested: " + StatRoller.suggestRace(stats.getStrength(),
				stats.getDexterity(), stats.getConstitution(), stats.getIntelligence(), stats.getWisdom(), stats.getCharisma()));
		Character myChar = 
	new Character("Trebor",Archetype.ROGUE, Race.ELF,"Forest Dweller");
		System.out.println(myChar);
		
		
		System.out.println("***************************");
		
		List<Item> dungeonLoot = new ArrayList<>();
		
		dungeonLoot.add(new Weapon("Short Sword", 3.0, 15, 1, 8, DamageType.PIERCING));
		dungeonLoot.add(new Weapon("Dagger of Venom", 1.0, 500, 1, 4, DamageType.PIERCING));
		dungeonLoot.add(new Treasure("Flawless Ruby of Seduction", 0.1, 1000, Rarity.LEGENDARY, false));
		dungeonLoot.add(new Treasure("Potion of Healing", 0.5, 50, Rarity.COMMON, true));
		
		for(Item item : dungeonLoot)
		{
			System.out.println(item.getDescription());		
			if(item instanceof Weapon)
			{
				Weapon activeWeapon = (Weapon) item;
				System.out.println("   -> Rolled Combat Damage: " + 
									activeWeapon.rollDamage());
			}
		}
	}
}
