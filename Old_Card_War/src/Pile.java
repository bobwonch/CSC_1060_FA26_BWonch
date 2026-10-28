import java.util.ArrayList;
import java.util.Collections;

public class Pile {
	private ArrayList<Card> cards;
	
	public Pile() {
		this.cards = new ArrayList<Card>();
	}
	
	public Card pop() {
		return this.cards.remove(0);
	}
	public void add(Card card) {
		this.cards.add(card);
	}
	public boolean isEmpty() {
		return this.cards.isEmpty();
	}
	public void addDeck(Deck deck) {
		for(Card card : deck.getCards()) {
			this.cards.add(card);
		}
	}
	public void pilePrint() {
		for(Card card : this.cards) {
			System.out.println(card);
		}
	}
	public void addPile(Pile that) {
		while(!that.isEmpty()) {
			this.add(that.pop());
		}
	}
	
	public void shufflePile() {
		Collections.shuffle(cards);
	}
}
