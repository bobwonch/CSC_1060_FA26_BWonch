import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private Deck standardDeck;

    @BeforeEach
    void setUp() {
        standardDeck = new Deck();
    }

    @Test
    @DisplayName("Parameterized constructor should create an empty deck of specified size")
    void testCapacityConstructor() {
        Deck customDeck = new Deck(10);
        assertEquals(10, customDeck.getCards().length, "Deck should have capacity 10");
        assertNull(customDeck.getCards()[0], "Slots in empty deck should be initialized to null");
    }

    @Test
    @DisplayName("Default constructor should create an ordered 52-card deck")
    void testDefaultConstructor() {
        Card[] cards = standardDeck.getCards();
        assertEquals(52, cards.length, "Standard deck should have 52 cards");
        
        // Verify first card (Ace of Clubs) and last card (King of Hearts)
        assertTrue(cards[0].equals(new Card(1, 0)), "First card should be Ace of Clubs");
        assertTrue(cards[51].equals(new Card(13, 3)), "Last card should be King of Hearts");

        // Verify entire deck is strictly ascending
        for (int i = 0; i < cards.length - 1; i++) {
            assertTrue(cards[i].compareTo(cards[i + 1]) < 0, "Deck should be sorted in ascending order");
        }
    }

    @Test
    @DisplayName("subdeck() should return an inclusive slice of cards")
    void testSubdeck() {
        Deck sub = standardDeck.subdeck(0, 12); // All Clubs (indices 0 through 12)
        assertEquals(13, sub.getCards().length, "Subdeck from 0 to 12 should contain 13 cards");
        assertTrue(sub.getCards()[0].equals(new Card(1, 0)), "First card of subdeck should be Ace of Clubs");
        assertTrue(sub.getCards()[12].equals(new Card(13, 0)), "Last card of subdeck should be King of Clubs");
    }

    @Test
    @DisplayName("subdeck() should throw ArrayIndexOutOfBoundsException for invalid bounds")
    void testSubdeckInvalidBounds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> standardDeck.subdeck(-1, 5));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> standardDeck.subdeck(0, 52));
    }

    @Test
    @DisplayName("insertionSort() should sort a shuffled deck back into ascending order")
    void testInsertionSort() {
        Deck.rand = new Random(42); // Seed RNG for reproducible test behavior
        standardDeck.shuffle(3);
        standardDeck.insertionSort();

        Card[] cards = standardDeck.getCards();
        for (int i = 0; i < cards.length - 1; i++) {
            assertTrue(cards[i].compareTo(cards[i + 1]) < 0, "Cards should be sorted after insertionSort");
        }
    }

    @Test
    @DisplayName("bubbleSort() should sort a shuffled deck back into ascending order")
    void testBubbleSort() {
        Deck.rand = new Random(42);
        standardDeck.shuffle(3);
        standardDeck.bubbleSort();

        Card[] cards = standardDeck.getCards();
        for (int i = 0; i < cards.length - 1; i++) {
            assertTrue(cards[i].compareTo(cards[i + 1]) < 0, "Cards should be sorted after bubbleSort");
        }
    }

    @Test
    @DisplayName("shuffle() should reorder cards while preserving all 52 unique cards")
    void testShuffle() {
        Deck.rand = new Random(123);
        Deck original = new Deck();
        
        standardDeck.shuffle(1);

        // Verify order changed
        boolean orderChanged = false;
        for (int i = 0; i < 52; i++) {
            if (!standardDeck.getCards()[i].equals(original.getCards()[i])) {
                orderChanged = true;
                break;
            }
        }
        assertTrue(orderChanged, "Shuffling should change the order of cards");

        // Verify no cards were lost or duplicated
        for (Card expectedCard : original.getCards()) {
            assertNotEquals(-1, standardDeck.search(expectedCard), "Every original card must remain in the deck");
        }
    }

    @Test
    @DisplayName("binSearch() should locate target cards in a sorted deck and return -1 if missing")
    void testBinSearch() {
        Card target = new Card(1, 2); // Ace of Spades (index 26)
        assertEquals(26, standardDeck.binSearch(target), "Ace of Spades should be at index 26");

        Card firstCard = new Card(1, 0); // Ace of Clubs (index 0)
        assertEquals(0, standardDeck.binSearch(firstCard), "First card should be found at index 0");

        Card lastCard = new Card(13, 3); // King of Hearts (index 51)
        assertEquals(51, standardDeck.binSearch(lastCard), "Last card should be found at index 51");

        // Search a subdeck for a card that isn't there
        Deck clubsOnly = standardDeck.subdeck(0, 12);
        assertEquals(-1, clubsOnly.binSearch(target), "Should return -1 when card is not in sorted subdeck");
    }

    @Test
    @DisplayName("search() should locate target cards in both sorted and unsorted decks")
    void testLinearSearch() {
        Deck.rand = new Random(99);
        standardDeck.shuffle(2);

        Card target = new Card(7, 1); // 7 of Diamonds
        int index = standardDeck.search(target);
        assertNotEquals(-1, index, "Linear search should find 7 of Diamonds in shuffled deck");
        assertTrue(standardDeck.getCards()[index].equals(target));

        // Search a subdeck for a missing card
        Deck smallSubdeck = standardDeck.subdeck(0, 4);
        Card missingCard = new Card(99, 99);
        assertEquals(-1, smallSubdeck.search(missingCard), "Linear search should return -1 for missing card");
    }

    @Test
    @DisplayName("printDeck() should print each card on its own line")
    void testPrintDeck() {
        Deck twoCardDeck = standardDeck.subdeck(0, 1); // Ace of Clubs, 2 of Clubs
        
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            twoCardDeck.printDeck();
        } finally {
            System.setOut(originalOut); // Always restore System.out
        }

        String expectedOutput = "Ace of Clubs" + System.lineSeparator() + "2 of Clubs" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }
}
