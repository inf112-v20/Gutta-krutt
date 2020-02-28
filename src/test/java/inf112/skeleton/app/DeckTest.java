package inf112.skeleton.app;

import inf112.skeleton.app.cards.Deck;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck = new Deck();
    HashMap<String, int[]> hashDeck = deck.getDeck();
    String[] typeOfCards = { "backUp", "move1", "move2", "move3", "uTurn", "rotateLeft", "rotateRight" };


    @Test
    public void correctAmountOfCardTypesTest() {
        assertEquals(7, hashDeck.size());
    }

    @Test
    public void correctAmountOfCards() {
        int totalCards = 0;
        for (String type : typeOfCards) {
            int amountCards = hashDeck.get(type).length;
            totalCards += amountCards;
        }
        assertEquals(84, totalCards);
    }

    @Test
    public void getCorrespondingDistantTest() {
        int[] expectedDistances = { -1, 1, 2, 3, 0, 0, 0 };
        for (int i = 0; i < 7; i++) {
            int distanceToMove = deck.getCorrespondingDistance(i);
            assertEquals(expectedDistances[i], distanceToMove);
        }
    }

    @Test
    public void getCorrespondingDirectionTest() {
        int[] expectedDirections = { 0, 0, 0, 0, 2, -1, 1 };
        for (int i = 0; i < 7; i++) {
            int directionToTurn = deck.getCorrespondingDirection(i);
            assertEquals(expectedDirections[i], directionToTurn);
        }
    }

}
