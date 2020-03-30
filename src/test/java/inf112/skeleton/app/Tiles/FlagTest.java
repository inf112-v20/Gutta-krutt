package inf112.skeleton.app.Tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.skeleton.app.tiles.Flag;
import org.junit.Before;
import org.junit.Test;

public class FlagTest {

    @Before
    public void start() {
        TmxMapLoader tmxLoader = new TmxMapLoader();
        TiledMap tilemap = tmxLoader.load("assets/Maps/map1.tmx");

        Flag flag = new Flag(tilemap);
    }

    @Test
    public void checkThatCheckpointIsSet(){

    }
}
