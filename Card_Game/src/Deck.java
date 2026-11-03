import java.util.Random;

public class Deck {
	static Random rand = new Random();

	public Card[] cards;

	public Deck(int n) {
		this.cards = new Card[n];
	}

	public Deck() {
		this.cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}

	public Deck subdeck(int low, int high) {
		Deck sub = new Deck(high - low + 1);
		for (int i = 0; i < sub.cards.length; i++) {
			sub.cards[i] = this.cards[low + i];
		}
		return sub;
	}

	public void insertionSort() {
        int n = cards.length;
        for (int i = 1; i < n; ++i) {
            Card key = cards[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key ahead
            while (j >= 0 && cards[j].compareTo(key) > 0) {
                cards[j + 1] = cards[j];
                j = j - 1;
            }
            cards[j + 1] = key;
        }
    }
	
	public void bubbleSort(){
        int n = cards.length;
        int i, j;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (cards[j].compareTo(cards[j + 1]) > 0) {
                    
                    // Swap arr[j] and arr[j+1]
                    swap(j, j+1);
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)break;
        }
    }
	
	public void shuffle(int j) {
		// for each index 0 - 51
		// choose a random number between i to the length
		// swap those cards in the array
		while (j > 0) {
			for (int i = 0; i < cards.length; i++) {
				int rand = randomInt(i, cards.length);
				swap(i, rand);
			}
			j--;
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
		int high = cards.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			int comp = cards[mid].compareTo(target);
			if (comp == 0)
				return mid;
			else if (comp < 0)
				low = mid + 1;
			else
				high = mid - 1;
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
		for (Card card : cards) {
			System.out.println(card);
		}

	}
}
