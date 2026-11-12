import java.util.Random;

/**
 * Represents a deck or array-based collection of playing cards.
 * Provides methods for shuffling, sorting, searching, and creating subdecks.
 */
public class Deck {
	/** Shared random number generator used for shuffling operations. */
	static Random rand = new Random();

	/** The array of Card objects contained in this deck. */
	public Card[] cards;

	/**
	 * Constructs an empty Deck capable of holding a specified number of cards.
	 *
	 * @param n the capacity of the card array
	 */
	public Deck(int n) {
		this.cards = new Card[n];
	}

	/**
	 * Constructs a standard 52-card deck ordered by suit and rank.
	 */
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

	/**
	 * Creates a new Deck containing a slice of cards from this deck.
	 *
	 * @param low  the starting index (inclusive)
	 * @param high the ending index (inclusive)
	 * @return a new Deck containing the specified range of cards
	 */
	public Deck subdeck(int low, int high) {
		Deck sub = new Deck(high - low + 1);
		for (int i = 0; i < sub.cards.length; i++) {
			sub.cards[i] = this.cards[low + i];
		}
		return sub;
	}

	/**
	 * Sorts the cards in this deck in ascending order using the insertion sort algorithm.
	 */
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
	
	/**
	 * Sorts the cards in this deck in ascending order using the bubble sort algorithm.
	 */
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
            if (swapped == false) break;
        }
    }
	
	/**
	 * Randomly shuffles the cards in the deck a specified number of times.
	 *
	 * @param j the number of full shuffle passes to perform
	 */
	public void shuffle(int j) {
		while (j > 0) {
			for (int i = 0; i < cards.length; i++) {
				int rand = randomInt(i, cards.length);
				swap(i, rand);
			}
			j--;
		}
	}

	/**
	 * Swaps two cards at the specified indices in the deck.
	 *
	 * @param i    the index of the first card
	 * @param rand the index of the second card
	 */
	private void swap(int i, int rand) {
		Card temp = cards[i];
		cards[i] = cards[rand];
		cards[rand] = temp;
	}

	/**
	 * Generates a random integer within the range [low, high).
	 *
	 * @param low  the lower bound (inclusive)
	 * @param high the upper bound (exclusive)
	 * @return a random integer between low and high - 1
	 */
	private int randomInt(int low, int high) {
		return rand.nextInt(high - low) + low;
	}

	/**
	 * Returns the underlying array of cards in this deck.
	 *
	 * @return the array of Card objects
	 */
	public Card[] getCards() {
		return cards;
	}

	/**
	 * Searches for a target card using binary search.
	 * Assumes the deck is already sorted in ascending order.
	 *
	 * @param target the Card to locate
	 * @return the index of the target card if found, or -1 if not present
	 */
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

	/**
	 * Searches for a target card using linear search.
	 * Works on both sorted and unsorted decks.
	 *
	 * @param target the Card to locate
	 * @return the index of the target card if found, or -1 if not present
	 */
	public int search(Card target) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Prints every card in the deck to standard output, one per line.
	 */
	public void printDeck() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}
}
