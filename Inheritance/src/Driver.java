
public class Driver {

	public static void main(String[] args) {
		Animal[] farm = new Animal[5];
		
		Animal a = new Dog(36, 43, "Shepard");
		
		Cat c = new Cat(12, 7, "Tabby");
		
		farm[0] = a;
		farm[1] = c;
		
		System.out.println(a);
		c.sound();
	}

}
