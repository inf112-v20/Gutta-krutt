package inf112.skeleton.app;

import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Card;
import org.junit.Test;

import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player = new Player(0,0, "assets/playerTexture/robot0.png", 0);
    LinkedList<Card> sequence = new LinkedList<>();

    public void createSequence(){
        sequence.add(new Card(0,300,1));
        sequence.add(new Card(0,300,1));
        sequence.add(new Card(0,300,1));
        sequence.add(new Card(0,300,1));
        sequence.add(new Card(0,300,1));
    }

    @Test
    public void powerDownTest() {
        sequence.add(new Card(0,300,1));
        player.setDamageTaken(8);
        player.setSequence(sequence);
        player.powerDown();

        assertEquals(0, player.getDamageTaken());
        assertEquals(null, player.getSequence());
    }

    @Test
    public void resetSequenceWithNoDamageTokensTest(){
        player.setSequence(sequence);
        player.resetSequences();
        assertEquals(new LinkedList<Card>(), player.getSequence());
    }

    @Test
    public void resetSequenceWithMoreThanFourDamageTokensTest(){
        for (int i = 1; i <= 5; i++){
            player.setSequence(sequence);
            player.setLastTurnSequence(sequence);
            player.setDamageTaken(4 + i);
            player.resetSequences();
            assertEquals(i, player.getSequence().size());
        }
    int x, y = 0;

    Player player = new Player(x,y,"assets/Robots/Fredrik_Robot.png");

    @Test
    public void robotHasFullHealthTest() {
        assertEquals(10,player.getMaxHealth());
    }

    @Test
    public void robotDirectionTest () {
        assertEquals(Direction.NORTH, player.getDir());
    }

    @Test
    public void takeDamageTest () {
        player.takeDamage(4);
        assertEquals(4, player.getDamageTaken());
    }
}
