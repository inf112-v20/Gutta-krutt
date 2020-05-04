package inf112.skeleton.app;

import inf112.skeleton.app.player.Player;
import inf112.skeleton.app.cards.Card;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Oskar Marthinussen, Fredrik Larsen, Vegard Birkenes
 */
public class PlayerTest {
   Player player = new Player(0,0,"assets/playerTexture/robot0.png");

    /**
     * pre-made sequence used for testing.
     * @return A sequence with five cards.
     */
    public LinkedList<Card> sequence(){
        LinkedList<Card> sequence = new LinkedList<>();
        sequence.add(new Card(0,300,1, "assets/cards/SequenceCards/Rotate_right.png"));
        sequence.add(new Card(0,300,1, "assets/cards/SequenceCards/Rotate_right.png"));
        sequence.add(new Card(0,300,1, "assets/cards/SequenceCards/Rotate_right.png"));
        sequence.add(new Card(0,300,1, "assets/cards/SequenceCards/Rotate_right.png"));
        sequence.add(new Card(0,300,1, "assets/cards/SequenceCards/Rotate_right.png"));
        return sequence;
    }

    @Test
    public void powerDownTest() {
        player.takeDamage(8);
        player.setSequence(sequence());
        player.powerDown();

        assertEquals(0, player.getDamageTaken());
        assertNull(player.getSequence());
    }

    @Test
    public void resetSequenceWithNoDamageTokensTest(){
        player.setSequence(sequence());
        player.resetSequences();
        assertEquals(new LinkedList<Card>(), player.getSequence());
    }

    @Test
    public void resetSequenceWithMoreThanFourDamageTokensTest() {
        player.takeDamage(4);
        for (int i = 1; i <= 5; i++) {
            player.setSequence(sequence());
            player.setLastTurnSequence(sequence());
            player.takeDamage(1);
            player.resetSequences();
            assertEquals(i, player.getSequence().size());
        }
    }

    @Test
    public void robotHasFullHealthTest(){
        assertEquals(10,player.getCurrentHealth());
    }

    @Test
    public void robotDirectionTest() {
        player.setDirection(1);
        assertEquals(1, player.getDirection());
    }

    @Test
    public void takeDamageTest() {
        player.takeDamage(4);
        assertEquals(4, player.getDamageTaken());
    }

    @Test
    public void playerLostLifeTest(){
        player.destroyed();
        assertEquals(2, player.getLives());
    }
}
