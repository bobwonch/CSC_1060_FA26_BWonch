
public class WarSand {

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		deck.printDeck();
		System.out.println("******************************************");
		Deck sorted = deck.mergeSort();
		sorted.printDeck();
	}

}
