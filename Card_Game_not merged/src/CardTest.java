import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    @DisplayName("Constructor and Getters should correctly assign and return rank and suit")
    void testConstructorAndGetters() {
        Card card = new Card(1, 2); // Ace of Spades
        assertEquals(1, card.getRank(), "Rank should be 1 (Ace)");
        assertEquals(2, card.getSuit(), "Suit should be 2 (Spades)");
    }

    @Test
    @DisplayName("equals() should return true for identical cards and false otherwise")
    void testEquals() {
        Card card1 = new Card(13, 3); // King of Hearts
        Card card2 = new Card(13, 3); // King of Hearts
        Card diffRank = new Card(12, 3); // Queen of Hearts
        Card diffSuit = new Card(13, 0); // King of Clubs

        assertTrue(card1.equals(card2), "Cards with same rank and suit should be equal");
        assertTrue(card1.equals(card1), "A card should be equal to itself");
        assertFalse(card1.equals(diffRank), "Cards with different ranks should not be equal");
        assertFalse(card1.equals(diffSuit), "Cards with different suits should not be equal");
    }

    @Test
    @DisplayName("compareTo() should compare suits first, then ranks")
    void testCompareTo() {
        Card twoOfClubs = new Card(2, 0);
        Card kingOfClubs = new Card(13, 0);
        Card aceOfDiamonds = new Card(1, 1);
        Card anotherKingOfClubs = new Card(13, 0);

        // Suit comparison (Clubs < Diamonds, even if rank is higher)
        assertEquals(-1, kingOfClubs.compareTo(aceOfDiamonds), "Clubs should be less than Diamonds");
        assertEquals(1, aceOfDiamonds.compareTo(kingOfClubs), "Diamonds should be greater than Clubs");

        // Rank comparison within the same suit
        assertEquals(-1, twoOfClubs.compareTo(kingOfClubs), "2 of Clubs should be less than King of Clubs");
        assertEquals(1, kingOfClubs.compareTo(twoOfClubs), "King of Clubs should be greater than 2 of Clubs");

        // Equality comparison
        assertEquals(0, kingOfClubs.compareTo(anotherKingOfClubs), "Identical cards should return 0");
    }

    @Test
    @DisplayName("toString() should return properly formatted rank and suit names")
    void testToString() {
        Card aceOfSpades = new Card(1, 2);
        Card tenOfDiamonds = new Card(10, 1);
        Card queenOfHearts = new Card(12, 3);
        Card threeOfClubs = new Card(3, 0);

        assertEquals("Ace of Spades", aceOfSpades.toString());
        assertEquals("10 of Diamonds", tenOfDiamonds.toString());
        assertEquals("Queen of Hearts", queenOfHearts.toString());
        assertEquals("3 of Clubs", threeOfClubs.toString());
    }

    @Test
    @DisplayName("toString() should throw ArrayIndexOutOfBoundsException for invalid ranks or suits")
    void testToStringOutOfBounds() {
        Card invalidRankZero = new Card(0, 0); // Rank 0 is null in RANKS, wait: RANKS[0] is null!
        Card invalidRankHigh = new Card(14, 0);
        Card invalidSuitLow = new Card(1, -1);
        Card invalidSuitHigh = new Card(1, 4);

        // Note: rank 0 prints "null of Clubs" because RANKS[0] is null
        assertEquals("null of Clubs", invalidRankZero.toString());
        
        // Out of array bounds triggers an exception
        assertThrows(ArrayIndexOutOfBoundsException.class, invalidRankHigh::toString);
        assertThrows(ArrayIndexOutOfBoundsException.class, invalidSuitLow::toString);
        assertThrows(ArrayIndexOutOfBoundsException.class, invalidSuitHigh::toString);
    }

    @Test
    @DisplayName("Static arrays RANKS and SUITS should have expected lengths and mappings")
    void testStaticConstants() {
        assertEquals(14, Card.RANKS.length, "RANKS array should have 14 elements (index 0 unused)");
        assertNull(Card.RANKS[0], "Index 0 of RANKS should be null");
        assertEquals("King", Card.RANKS[13]);

        assertEquals(4, Card.SUITS.length, "SUITS array should have 4 elements");
        assertEquals("Clubs", Card.SUITS[0]);
        assertEquals("Hearts", Card.SUITS[3]);
    }
}
