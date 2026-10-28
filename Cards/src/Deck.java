import java.util.Random;

public class Deck {
	private Card[] cards;
	//default
	public Deck(int n)
	{
		this.cards = new Card[n];
	}
	//build constructor
	public Deck()
	{
		this.cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit < 4; suit ++) 
		{
			for(int rank = 1; rank <= 13; rank++)
			{
				this.cards[index] = new Card(rank, suit);
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
		//for each index i
		//choose a random number between i and the length -1
		//swap cards index and the random
		for(int i = 0; i < cards.length; i++)
		{
			int rand = randomInt(i, cards.length-1);
			swap(i, rand);
		}	
	}
	
	private void swap(int i, int j)
	{
		Card temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}
	
	private static int randomInt(int low, int high)
	{
		Random random = new Random();
		
		return random.nextInt((high - low) + low); 
	}
	
	public Card[] getCards()
	{
		return cards;
	}
	
	public void printDeck() {
		for(Card card : cards)
		{
			System.out.println(card);
		}
	}
}
