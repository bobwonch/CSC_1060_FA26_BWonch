import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a dynamic pile or hand of playing cards backed by an ArrayList.
 * Supports adding, removing, transferring, and shuffling cards.
 */
public class Pile {
	/** The list storing the Card objects currently in the pile. */
	private ArrayList<Card> cards;

	/**
	 * Constructs an empty Pile of cards.
	 */
	public Pile() {
		this.cards = new ArrayList<Card>();
	}

	/**
	 * Removes and returns the top card (at index 0) from the pile.
	 *
	 * @return the Card removed from the top of the pile
	 */
	public Card pop() {
		return this.cards.remove(0);
	}
	
	/**
	 * Adds a single card to the bottom (end) of the pile.
	 *
	 * @param card the Card to add
	 */
	public void add(Card card) {
		this.cards.add(card);
	}
	
	/**
	 * Checks whether the pile contains any cards.
	 *
	 * @return true if the pile has no cards, false otherwise
	 */
	public boolean isEmpty() {
		return this.cards.isEmpty();
	}
	
	/**
	 * Adds all cards from a given Deck into this pile.
	 *
	 * @param deck the Deck whose cards will be appended to this pile
	 */
	public void addDeck(Deck deck) {
		for (Card card : deck.getCards()) {
			this.cards.add(card);
		}
	}

	/**
	 * Prints every card currently in the pile to standard output, one per line.
	 */
	public void printPile() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}

	/**
	 * Transfers all cards from another Pile into this pile, emptying the source pile.
	 *
	 * @param mid the Pile from which cards will be popped and added to this pile
	 */
	public void addPile(Pile mid) {
		while (!mid.isEmpty()) {
			this.add(mid.pop());
		}
	}

	/**
	 * Randomly shuffles the cards currently in the pile.
	 */
	public void shuffle() {
		Collections.shuffle(cards);	
	}
}
