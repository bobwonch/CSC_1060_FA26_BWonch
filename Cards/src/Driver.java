import java.util.Iterator;

public class Driver {

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		
		Pile p1 = new Pile();
		p1.addDeck(deck.subdeck(0, 25));
		
		p1.printPile();
	}

	
	private static int binSearch(Card[] cards, Card target) {
		int low = 0;
		int high = cards.length-1;
		while(low <= high)
		{
			System.out.println(low + ", " + high);
			
			int mid = (low + high)/2;
			int comp = cards[mid].compareTo(target);
			
			if(comp == 0)return mid;
			else if(comp < 0)low = mid + 1;
			else high = mid - 1;
			
		}
		return 0;
	}


	private static int search(Card[] cards, Card target) {
		for (int i = 0; i < cards.length; i++) {
			if(cards[i].equals(target))
			{
				return i;
			}
		}
		return -1;
	}

	

}
