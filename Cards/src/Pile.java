import java.util.ArrayList;

public class Pile {
	private ArrayList<Card> cards;
	
	public Pile()
	{
		this.cards = new ArrayList<Card>();
	}
	
	public Card pop()
	{
		return this.cards.remove(0);
	}
	
	public void add(Card card)
	{
		this.cards.add(card);
	}
	
	public boolean isEmpty()
	{
		return this.cards.isEmpty();
	}
	
	public void addDeck(Deck deck)
	{
		for(Card card : deck.getCards())
		{
			this.cards.add(card);
		}
	}
	public void printPile()
	{
		for(Card card : cards)
		{
			System.out.println(card);
		}
	}
}
