import java.util.Random;

public class Deck {
	static Random rand = new Random();
	
	public Card[] cards;
	
	public Deck(int n)
	{
		this.cards = new Card[n];
	}
	public Deck()
	{
		this.cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}
	
	public Deck subdeck(int low, int high)
	{
		Deck sub = new Deck(high - low + 1);
		for (int i = 0; i < sub.cards.length; i++) {
			sub.cards[i] = this.cards[low + i];
		}
		return sub;
	}
	
	public void shuffle()
	{
		//for each index 0 - 51
		//choose a random number between i to the length
		//swap those cards in the array
		for (int i = 0; i < cards.length; i++) {
			int rand = randomInt(i, cards.length);
			swap(i, rand);
		}
		
	}
	
	private void swap(int i, int rand) {
		Card temp = cards[i];
		cards[i] = cards[rand];
		cards[rand] = temp;		
	}
	private int randomInt(int low, int high) {
		
		return rand.nextInt(high - low) + low;
	}
	
	public Card[] getCards() {
		return cards;
	}
	public int binSearch(Card target) {
		int low = 0;
		int high = cards.length-1;
		int mid = 0;
		while (low <= high){
			mid = (low + high) / 2;
			int comp = cards[mid].compareTo(target);
			if (comp == 0) return mid;
			else if (comp < 0) low = mid + 1;
			else high = mid - 1;
		}
		return -1;
	}

	public int search(Card target) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	public void printDeck() {
		for (Card card: cards) {
			System.out.println(card);
		}
		
	}
}
