import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a dynamic collection or pile of playing cards.
 * Uses an underlying ArrayList structure to allow fluid resizing,
 * additions, transfers, and removals of cards.
 * 
 * @author Your Name
 * @version 1.0
 */
public class Pile {
	
	/**
	 * The dynamic collection storing the Card instances inside this pile.
	 */
	private ArrayList<Card> cards;
	
	/**
	 * Constructs a new, empty Pile initialized with an empty card collection list.
	 */
	public Pile()
	{
		this.cards = new ArrayList<Card>();
	}
	
	/**
	 * Shuffles the cards inside this pile using standard collections utility shuffling.
	 * 
	 * @param times the total number of sequential shuffles to perform on the pile
	 */
	public void shuffle(int times) {
		for(int i = 0; i < times; i++)
		{
			Collections.shuffle(cards);
		}
	}
		
	/**
	 * Removes and returns the top card of the pile (located at index 0).
	 * 
	 * @return the Card instance pulled from the front of the pile
	 * @throws IndexOutOfBoundsException if the pile is empty when called
	 */
	public Card pop()
	{
		return this.cards.remove(0);
	}
	
	/**
	 * Appends a single card to the bottom end of this pile.
	 * 
	 * @param card the Card instance to be appended to the collection
	 */
	public void add(Card card)
	{
		this.cards.add(card);
	}
	
	/**
	 * Checks whether this pile contains zero cards.
	 * 
	 * @return true if the pile is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return this.cards.isEmpty();
	}
	
	/**
	 * Copies all card elements from a structured Deck array and adds them to this pile.
	 * 
	 * @param deck the Deck source whose cards will be transferred over
	 */
	public void addDeck(Deck deck)
	{
		for(Card card : deck.getCards())
		{
			this.cards.add(card);
		}
	}
	
	/**
	 * Empties an entire external target Pile directly into this pile instance.
	 * Cards are completely moved out of the target pile one by one.
	 * 
	 * @param that the external Pile collection to extract cards from
	 */
	public void addPile(Pile that)
	{
		while(!that.isEmpty())
		{
			this.add(that.pop());
		}
	}
	
	/**
	 * Iterates over the entire pile and prints each card instance's string 
	 * representation to standard system output.
	 */
	public void printPile()
	{
		for(Card card : cards)
		{
			System.out.println(card);
		}
	}
}
