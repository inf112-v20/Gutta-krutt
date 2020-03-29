package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

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
