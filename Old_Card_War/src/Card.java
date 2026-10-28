
/**
 * This is the card class. It generates the card with a suit and a rank
 * 
 * @author S03121072
 * @since 4/22/26
 * 
 */
public class Card {
	private int suit;
	private int rank;

	private static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private static final String[] RANKS = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King" };

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public boolean equals(Card that) {
		return this.suit == that.suit && this.rank == that.rank;
	}
	
	public int compareTo(Card that) {
		if(this.suit < that.suit) return -1;
		if(this.suit > that.suit) return 1;
		if(this.rank < that.rank) return -1;
		if(this.rank > that.rank) return 1;
		return 0;
	}

	public int getSuit() {
		return suit;
	}



	public int getRank() {
		return rank;
	}



	public String toString() {
		return RANKS[this.rank] + " of " + SUITS[this.suit];
	}

}
