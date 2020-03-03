package inf112.skeleton.app.board;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Direction;

public class Walls {

    private final TiledMapTileLayer northWall;
    private final TiledMapTileLayer eastWall;
    private final TiledMapTileLayer westWall;
    private final TiledMapTileLayer westSouthWall;
    private final TiledMapTileLayer southWall;

    public Walls(TiledMap tilemap) {

        northWall = (TiledMapTileLayer) tilemap.getLayers().get("North_Walls");
        eastWall = (TiledMapTileLayer) tilemap.getLayers().get("East_Walls");
        westWall = (TiledMapTileLayer) tilemap.getLayers().get("West_Wall");
        southWall = (TiledMapTileLayer) tilemap.getLayers().get("South_Walls");
        westSouthWall = (TiledMapTileLayer) tilemap.getLayers().get("West_South_Walls");

    }
}
