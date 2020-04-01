package inf112.skeleton.app.Tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.tiles.Flag;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlagTest {

    Flag flag;
    Player player;

    @Before
    public void init() {
        RoboRally game = new RoboRally();
        flag = new Flag();
        player = new Player(0,0, "assets/playerTexture/robot0.png");
    }

    @Test
    public void checkThatCheckpointStartIs00(){
        Vector2 startCheckPoint = new Vector2(0,0);
        assertEquals(player.getCheckpoint(), startCheckPoint);
    }
}
