/**
 * Represents a standard playing card with a specific rank and suit.
 * Provides functionality for comparing and formatting card information.
 * 
 * @author Bob Wonch
 * @version 1.0
 */
public class Card {
	
	/**
	 * The numeric rank of the card (e.g., 1 for Ace, 11 for Jack).
	 */
	private int rank;
	
	/**
	 * The numeric suit of the card (0 = Clubs, 1 = Diamonds, 2 = Spades, 3 = Hearts).
	 */
	private int suit;
	
	/**
	 * Class variable containing the string representations for card ranks.
	 * Index 1 corresponds to "Ace", index 11 to "Jack", etc. Index 0 is null.
	 */
	public static final String[] RANKS = {null,"Ace", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "Jack", "Queen", "King"};
			
	/**
	 * Class variable containing the string representations for card suits.
	 * Ordered by standard bridge ranking: Clubs, Diamonds, Spades, Hearts.
	 */
	public static final String[] SUITS = {"Clubs", "Diamonds", "Spades", "Hearts"};
	
	/**
	 * Constructs a new Card with the specified rank and suit.
	 * 
	 * @param rank the numeric rank value of the card (1 to 13)
	 * @param suit the numeric suit value of the card (0 to 3)
	 */
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Determines whether this card is equal to another card.
	 * Two cards are considered equal if they have both the same rank and the same suit.
	 * 
	 * @param that the other card to compare against
	 * @return true if the cards have matching ranks and suits, false otherwise
	 */
	public boolean equals(Card that)
	{
		return this.rank == that.rank && this.suit == that.suit;
	}
	
	/**
	 * Compares this card with another card for relative ordering.
	 * Comparison is evaluated first by suit, and then by rank if suits match.
	 * 
	 * @param that the other card to compare against
	 * @return a negative integer if this card is less than the other card,
	 *         a positive integer if this card is greater, 
	 *         or 0 if they are identical
	 */
	public int compareTo(Card that)
	{
		if(this.suit < that.suit)
		{
			return -1;
		}
		if(this.suit > that.suit)
		{
			return 1;
		}
		if(this.rank < that.rank)
		{
			return -1;
		}
		if(this.rank > that.rank)
		{
			return 1;
		}
		return 0;
	}
	
	/**
	 * Compares only the rank of this card with the rank of another card.
	 * Suits are completely ignored during this comparison.
	 * 
	 * @param that the other card to compare against
	 * @return 1 if this card's rank is greater than the other,
	 *         -1 if it is less,
	 *         or 0 if their ranks are equal
	 */
	public int compareRank(Card that)
	{
		if(this.rank > that.rank) return 1;
		else if (this.rank < that.rank) return -1;
		return 0;
	}
	
	/**
	 * Gets the numeric rank value of this card.
	 * 
	 * @return the card rank integer
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Gets the numeric suit value of this card.
	 * 
	 * @return the card suit integer
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * Returns a human-readable string representation of the card.
	 * The output is formatted as "Rank of Suit" (e.g., "Ace of Spades").
	 * 
	 * @return the formatted description string of this card
	 */
	@Override
	public String toString() {
		return String.format("%s of %s",RANKS[this.rank],SUITS[this.suit]);
	}
}
