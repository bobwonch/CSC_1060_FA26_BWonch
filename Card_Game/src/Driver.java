
public class Driver {

	public static void main(String[] args) {
		 Deck deck = new Deck();
		 deck.shuffle(3);
		 //deck.bubbleSort();
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
			 
			 System.out.println("Player 1 card: " + c1 + "\nPlayer 2 card: " + c2);
			 int diff = c1.getRank() - c2.getRank();
			 if(diff > 0)
			 {
				 p1.addPile(mid);
				 mid = new Pile();
			 }else if(diff < 0)
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
			 p1.shuffle();
			 p2.shuffle();
		 }
		 if(p2.isEmpty())System.out.println("Player 1 Wins!!");
		 else System.out.println("Player 2 wins!!");
	}

}
