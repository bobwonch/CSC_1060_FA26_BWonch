import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Card class.
 */
public class CardTest {

    private Card aceOfClubs;
    private Card aceOfClubsCopy;
    private Card kingOfHearts;
    private Card jackOfSpades;
    private Card aceOfHearts;

    @BeforeEach
    public void setUp() {
        // Initializing test cards based on indices: 
        // Suits: 0 = Clubs, 1 = Diamonds, 2 = Spades, 3 = Hearts
        // Ranks: 1 = Ace, 11 = Jack, 13 = King
        aceOfClubs = new Card(1, 0);
        aceOfClubsCopy = new Card(1, 0);
        jackOfSpades = new Card(11, 2);
        kingOfHearts = new Card(13, 3);
        aceOfHearts = new Card(1, 3);
    }

    @Test
    public void testGetRank() {
        assertEquals(1, aceOfClubs.getRank(), "Rank should be 1 (Ace)");
        assertEquals(11, jackOfSpades.getRank(), "Rank should be 11 (Jack)");
        assertEquals(13, kingOfHearts.getRank(), "Rank should be 13 (King)");
    }

    @Test
    public void testGetSuit() {
        assertEquals(0, aceOfClubs.getSuit(), "Suit should be 0 (Clubs)");
        assertEquals(2, jackOfSpades.getSuit(), "Suit should be 2 (Spades)");
        assertEquals(3, kingOfHearts.getSuit(), "Suit should be 3 (Hearts)");
    }

    @Test
    public void testEquals() {
        assertTrue(aceOfClubs.equals(aceOfClubsCopy), "Cards with identical rank and suit must be equal");
        assertFalse(aceOfClubs.equals(jackOfSpades), "Cards with different ranks and suits must not be equal");
        assertFalse(aceOfClubs.equals(aceOfHearts), "Cards with same rank but different suits must not be equal");
    }

    @Test
    public void testCompareTo() {
        // Test 1: Same suit, lower rank vs higher rank
        Card twoOfClubs = new Card(2, 0);
        assertTrue(aceOfClubs.compareTo(twoOfClubs) < 0, "Ace of Clubs should be less than 2 of Clubs");
        assertTrue(twoOfClubs.compareTo(aceOfClubs) > 0, "2 of Clubs should be greater than Ace of Clubs");

        // Test 2: Lower suit vs higher suit (Rank doesn't matter if suit is lower)
        assertTrue(aceOfClubs.compareTo(jackOfSpades) < 0, "Clubs (0) should be less than Spades (2)");
        assertTrue(kingOfHearts.compareTo(jackOfSpades) > 0, "Hearts (3) should be greater than Spades (2)");

        // Test 3: Completely identical cards
        assertEquals(0, aceOfClubs.compareTo(aceOfClubsCopy), "Identical cards should return 0");
    }

    @Test
    public void testCompareRank() {
        // Test 1: Lower rank vs higher rank (ignoring suits)
        assertTrue(aceOfClubs.compareRank(jackOfSpades) < 0, "Ace (1) is lower rank than Jack (11)");
        assertTrue(kingOfHearts.compareRank(jackOfSpades) > 0, "King (13) is higher rank than Jack (11)");

        // Test 2: Identical ranks but completely different suits
        assertEquals(0, aceOfClubs.compareRank(aceOfHearts), "Aces should return 0 regardless of suit");
    }

    @Test
    public void testToString() {
        assertEquals("Ace of Clubs", aceOfClubs.toString());
        assertEquals("Jack of Spades", jackOfSpades.toString());
        assertEquals("King of Hearts", kingOfHearts.toString());
    }
}
