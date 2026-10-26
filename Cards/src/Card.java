public class Card {
	//instance variables
	private int rank;
	private int suit;
	//class variables
	public static final String[] RANKS = {null,"Ace", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "Jack", "Queen", "King"};
	public static final String[] SUITS = {"Clubs", "Diamonds", "Spades", "Hearts"};
	
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public boolean equals(Card that)
	{
		return this.rank == that.rank && this.suit == that.suit;
	}
	
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
	
	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return String.format("%s of %s",RANKS[this.rank],SUITS[this.suit]);
	}
	
	

}
