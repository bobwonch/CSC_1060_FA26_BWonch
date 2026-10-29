//Combo

import java.util.Iterator;

public class War_Driver {

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle(3);
		//deck.insertionSort();
		//deck.printDeck();
		
		Pile p1 = new Pile();
		Pile p2 = new Pile();
		
		p1.addDeck(deck.subdeck(0, 25));
		p2.addDeck(deck.subdeck(26, 51));
		
		Pile mid = new Pile();
		
		while(!p1.isEmpty() && !p2.isEmpty())
		{
			Card c1 = p1.pop();
			Card c2 = p2.pop();
			
			mid.add(c1);
			mid.add(c2);
			
			int diff = c1.getRank()-c2.getRank();
			
			if(diff > 0)
			{
				p1.addPile(mid);
				mid = new Pile();
			}else if (diff < 0)
			{
				p2.addPile(mid);
				mid = new Pile();
			}else
			{
				for(int i = 0; i < 3; i++)
				{
					if(!p1.isEmpty()) mid.add(p1.pop());
					if(!p2.isEmpty()) mid.add(p2.pop());
				}
			}
			p1.shuffle(1);
			p2.shuffle(1);
		}
		if(p2.isEmpty()) System.out.println("Player 1 wins!!");
		else System.out.println("Player 2 wins!!");

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
