//combo

import java.util.Random;

public class Deck {
	private Card[] cards;

	// default
	public Deck(int n) {
		this.cards = new Card[n];
	}

	// build constructor
	public Deck() {
		this.cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				this.cards[index] = new Card(rank, suit);
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

	public void bubbleSortArray() {
		int n = this.cards.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (this.cards[j].compareTo(this.cards[j + 1]) > 0) {
					swap(j, j + 1);
					swapped = true;
				}
			}
			if(!swapped)break;
		}
	}
	
	public void insertionSort() {
        int n = cards.length;
        for (int i = 1; i < n; ++i) {
            Card key = cards[i];
            int j = i - 1;

            // Move elements of cards[0..i-1] that are greater than key ahead
            while (j >= 0 && cards[j].compareTo(key) > 0) {
                cards[j + 1] = cards[j];
                j = j - 1;
            }
            cards[j + 1] = key;
        }
    }
	public void shuffle(int times) {
		// for each index i
		// choose a random number between i and the length -1
		// swap cards index and the random
		for (int j = 0; j < times; j++) {
			for (int i = 0; i < cards.length; i++) {
				int rand = randomInt(i, cards.length - 1);
				swap(i, rand);
			}
		}
	}

	public int indexLowest(int low, int high) {
		int lowest = low;
		for (int i = low + 1; i <= high; i++) {
			if (this.cards[i].compareTo(this.cards[lowest]) < 0) {
				lowest = i;
			}
		}
		return lowest;
	}

	private void swap(int i, int j) {
		Card temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}

	private static int randomInt(int low, int high) {
		Random random = new Random();

		return random.nextInt((high - low) + low);
	}

	public Card[] getCards() {
		return cards;
	}

	public void printDeck() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}
}
