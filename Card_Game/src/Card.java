/**
 * Represents a playing card with a specific rank and suit.
 * Provides comparisons for equality and order, as well as a string representation.
 * 
 * @author Bob Wonch
 * @version 1.0
 * 
 */
public class Card {

	/**
	 * The rank value of the card (e.g., 1 for Ace, 11 for Jack).
	 */
	private int rank;

	/**
	 * The suit value of the card (0 = Clubs, 1 = Diamonds, 2 = Spades, 3 = Hearts).
	 */
	private int suit;

	/**
	 * String representations of the card ranks, where index matches the numeric rank.
	 * Index 0 is null because ranks traditionally start at 1 (Ace).
	 */
	public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

	/**
	 * String representations of the card suits, indexed from 0 to 3.
	 */
	public static final String[] SUITS = {"Clubs", "Diamonds", "Spades", "Hearts"};
	
	/**
	 * Constructs a new Card with the specified rank and suit values.
	 *
	 * @param rank the numeric value representing the card's rank
	 * @param suit the numeric value representing the card's suit
	 */
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * Compares this card to another card for equality.
	 * Two cards are equal if both their ranks and suits are identical.
	 *
	 * @param that the other Card to compare with
	 * @return true if the cards have the same rank and suit; false otherwise
	 */
	public boolean equals(Card that) {
		return this.rank == that.rank && this.suit == that.suit;
	}
	
	/**
	 * Compares this card with another card for order. 
	 * Cards are sorted primarily by suit, and secondarily by rank.
	 *
	 * @param that the other Card to be compared
	 * @return a negative integer, zero, or a positive integer as this card
	 *         is less than, equal to, or greater than the specified card
	 */
	public int compareTo(Card that) {
		if (this.suit < that.suit) {
			return -1;
		}
		if (this.suit > that.suit) {
			return 1;
		}
		if (this.rank < that.rank) {
			return -1;
		}
		if (this.rank > that.rank) {
			return 1;
		}
		return 0;
	}

	/**
	 * Gets the numeric rank value of this card.
	 *
	 * @return the rank value
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Gets the numeric suit value of this card.
	 *
	 * @return the suit value
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * Returns a human-readable string representation of the card.
	 * For example, "Ace of Spades" or "10 of Diamonds".
	 *
	 * @return a string describing the card
	 */
	@Override
	public String toString() {
		return String.format("%s of %s", RANKS[this.rank], SUITS[this.suit]);
	}
	
}
