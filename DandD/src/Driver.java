
public class Driver {

	public static void main(String[] args) {
		Attributes Bob = StatRoller.rollStats();
		
		Character myChar = new Character("Trebor",1,"Rogue", 10, 11, "Elf", "Forest dweller", Bob);
			
		System.out.println(myChar.getStats().getBonus(4));
		System.out.println(myChar);

	}

}
