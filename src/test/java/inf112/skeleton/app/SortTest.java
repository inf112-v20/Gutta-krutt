package inf112.skeleton.app;

import inf112.skeleton.app.cards.Card;
import inf112.skeleton.app.cards.Deck;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SortTest {

    private RoboRally roboRally = new RoboRally();
    private Deck deck = new Deck();
    private ArrayList<Card> cards = new ArrayList<>();
    private int numberOfCasesToTest = 100;

    /**
     * Checks that the sort function works as intended.
     */
    @Test
    public void sortTest() {
        for (int i = 0; i < numberOfCasesToTest; i++) {
            cards.add(deck.randomCard());
        }
        roboRally.sortCards(cards);
        for (int i = 0; i < numberOfCasesToTest-1; i++) {
            assertTrue(cards.get(i).getPriority() >= cards.get(i+1).getPriority());
        }
    }
}
