/**
 * Represents a standard playing card with a rank and a suit.
 */
public class Card {
	/** The numerical rank of the card (1 = Ace through 13 = King). */
	private int rank;

	/** The numerical suit of the card (0 = Clubs, 1 = Diamonds, 2 = Spades, 3 = Hearts). */
	private int suit;

	/** Array mapping integer rank indices to their string names. Index 0 is unused. */
	public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

	/** Array mapping integer suit indices to their string names. */
	public static final String[] SUITS = {"Clubs", "Diamonds", "Spades", "Hearts"};
	
	/**
	 * Constructs a new Card with the specified rank and suit.
	 *
	 * @param rank the integer rank of the card (1–13)
	 * @param suit the integer suit of the card (0–3)
	 */
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * Compares this card to another card for equality based on rank and suit.
	 *
	 * @param that the other Card to compare against
	 * @return true if both cards have the same rank and suit, false otherwise
	 */
	public boolean equals(Card that) {
		return this.rank == that.rank && this.suit == that.suit;
	}
	
	/**
	 * Compares this card with another card for order.
	 * Suits are compared first, followed by ranks if the suits are equal.
	 *
	 * @param that the Card to be compared
	 * @return -1 if this card is less than the other card, 1 if greater, or 0 if equal
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
	 * Gets the integer rank of this card.
	 *
	 * @return the rank of the card
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Gets the integer suit of this card.
	 *
	 * @return the suit of the card
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * Returns a human-readable string representation of the card (e.g., "Ace of Spades").
	 *
	 * @return a formatted string showing the rank and suit of the card
	 */
	@Override
	public String toString() {
		return String.format("%s of %s", RANKS[this.rank], SUITS[this.suit]);
	}
}
