package inf112.skeleton.app.tile_tests;

import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.player.Player;
import inf112.skeleton.app.RoboRally;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlagTest {

    Player player;

    @Before
    public void init() {
        //flag = new Flag();
        player = new Player(0,0, "assets/playerTexture/robot0.png");
    }

    @Test
    public void checkThatCheckpointStartIs00(){
        Vector2 startCheckPoint = new Vector2(0,0);
        assertEquals(player.getCheckpoint(), startCheckPoint);
    }
}
