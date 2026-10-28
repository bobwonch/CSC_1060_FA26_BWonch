
public class Driver {

	public static void main(String[] args) {
		 Deck deck = new Deck();
		 
		 deck.shuffle();
		 deck.shuffle();
		 deck.shuffle();
		 
		 Pile p1 = new Pile();
		 Pile p2 = new Pile();
		 
		 p1.addDeck(deck.subdeck(0, 25));
		 p2.addDeck(deck.subdeck(26, 51));
		 
		 while(!p1.isEmpty() && !p2.isEmpty())
		 {
			 Card c1 = p1.pop();
			 Card c2 = p2.pop();
			 System.out.println("Player 1 card: " + c1 + "\nPlayer 2 card: " + c2);
			 int diff = c1.getRank() - c2.getRank();
			 if(diff > 0)
			 {
				 p1.add(c1);
				 p1.add(c2);
			 }else if(diff < 0)
			 {
				 p2.add(c1);
				 p2.add(c2);
			 }else
			 {
				 //it's a tie!
			 }
		 }
	}

}
