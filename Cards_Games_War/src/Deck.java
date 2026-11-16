import java.util.Random;

/**
 * Represents a deck of playing cards.
 * Manages an array of Card objects and provides utility methods for
 * sorting, shuffling, slicing, and printing the deck components.
 * 
 * @author Your Name
 * @version 1.0
 */
public class Deck {
	
	/**
	 * The array holding the Card objects currently in the deck.
	 */
	private Card[] cards;

	/**
	 * Constructs an empty Deck with space allocated for a specific number of cards.
	 * 
	 * @param n the total capacity or size of the card array to initialize
	 */
	public Deck(int n) {
		this.cards = new Card[n];
	}

	/**
	 * Constructs a standard 52-card Deck initialized with all ranks and suits.
	 * The cards are systematically generated in ordered sequence by suit and rank.
	 */
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

	/**
	 * Creates a new Deck instance representing a subset of the original deck.
	 * 
	 * @param low the inclusive starting index of the subdeck
	 * @param high the inclusive ending index of the subdeck
	 * @return a new Deck object containing the isolated range of cards
	 */
	public Deck subdeck(int low, int high) {
		Deck sub = new Deck(high - low + 1);
		for (int i = 0; i < sub.cards.length; i++) {
			sub.cards[i] = this.cards[low + i];
		}
		return sub;
	}

	/**
	 * Sorts the card array in ascending order using the Bubble Sort algorithm.
	 * Relies on the Card class's compareTo implementation to determine card order.
	 */
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
	
	/**
	 * Sorts the card array in ascending order using the Insertion Sort algorithm.
	 * Relies on the Card class's compareTo implementation to determine card order.
	 */
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

	/**
	 * Shuffles the deck a specified number of times using a random index selection.
	 * 
	 * @param times the total number of full shuffling passes to execute over the array
	 */
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

	/**
	 * Finds the index of the lowest card within a specified range of the deck array.
	 * 
	 * @param low the inclusive starting index of the search window
	 * @param high the inclusive ending index of the search window
	 * @return the array index containing the lowest card evaluated by compareTo
	 */
	public int indexLowest(int low, int high) {
		int lowest = low;
		for (int i = low + 1; i <= high; i++) {
			if (this.cards[i].compareTo(this.cards[lowest]) < 0) {
				lowest = i;
			}
		}
		return lowest;
	}

	/**
	 * Swaps the positions of two cards within the deck array.
	 * 
	 * @param i the index of the first card to swap
	 * @param j the index of the second card to swap
	 */
	private void swap(int i, int j) {
		Card temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}

	/**
	 * Generates a pseudo-random integer within a specified bounding range.
	 * Note: The mathematical implementation contains a logical indexing shift 
	 * bug that should be reviewed.
	 * 
	 * @param low the inclusive minimum value boundary
	 * @param high the inclusive maximum value boundary
	 * @return a randomized integer value
	 */
	private static int randomInt(int low, int high) {
		Random random = new Random();

		return random.nextInt((high - low) + low);
	}

	/**
	 * Retrieves the internal array of cards.
	 * 
	 * @return the backing Card array instance
	 */
	public Card[] getCards() {
		return cards;
	}

	/**
	 * Iterates over the entire deck and prints each card instance's string 
	 * representation to standard system output.
	 */
	public void printDeck() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}
}
