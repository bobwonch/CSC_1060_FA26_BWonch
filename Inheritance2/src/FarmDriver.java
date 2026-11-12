import java.util.ArrayList;
import java.util.List;

public class FarmDriver {

	public static void main(String[] args) {
		List<Animal> farm = new ArrayList<>();
		
		Animal animal = new Animal(36, 76);
		Dog fido = new Dog(24, 36, "Terrier");
		Cat kittyMewMew = new Cat(11, 10, "Tabby");
		Kitten kit = new Kitten(4, 1, "Calico", 10);
		
		farm.add(kittyMewMew);
		farm.add(fido);
		farm.add(animal);
		farm.add(kit);
		
		for(Animal a : farm)
		{
			a.makeSound();
			if(a instanceof Dog)
			{
				System.out.println("WE had a kitten!!");
			}
		}
		
		
		
		
		
		
	}

}
