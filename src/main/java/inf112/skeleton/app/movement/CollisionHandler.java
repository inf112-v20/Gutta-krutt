package inf112.skeleton.app.movement;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.player.Player;
import inf112.skeleton.app.cards.Direction;

import java.util.HashMap;

/**
 * handling the collion part of board.
 * @author sedric
 */
public class CollisionHandler extends InputAdapter {

    TiledMap tilemap;

    /**
     * @param tilemap the tileMap to handle collision on
     */
    public CollisionHandler(TiledMap tilemap) {
        this.tilemap = tilemap;
    }

    /**
     * checks if a player can move to the newPos tile
     * @param dir direction to move player
     * @param newPosX the new X position of player
     * @param newPosY the new Y position of player
     * @return true if it is possible to move to the new location and false otherwise
     */
    public boolean canMove(Player player, Direction dir, int newPosX, int newPosY) {
        HashMap<Integer, Direction[]> idToWallName = new HashMap<>();
        TiledMapTileLayer walls = (TiledMapTileLayer) tilemap.getLayers().get("Walls");

        Direction[] north = { Direction.NORTH };
        Direction[] east = { Direction.EAST };
        Direction[] west = { Direction.WEST };
        Direction[] south = { Direction.SOUTH };
        Direction[] northWest = { Direction.NORTH, Direction.WEST };
        Direction[] southWest = {Direction.SOUTH, Direction.WEST};
        Direction[] northEast = {Direction.NORTH, Direction.EAST};
        Direction[] southEast = {Direction.SOUTH, Direction.EAST};
        Direction[] def = {Direction.DEFAULT};
        
        idToWallName.put(31,north);
        idToWallName.put(23,east);
        idToWallName.put(30,west);
        idToWallName.put(29,south);
        idToWallName.put(24,northWest);
        idToWallName.put(32,southWest);
        idToWallName.put(16,northEast);
        idToWallName.put(8,southEast);
        idToWallName.put(0,def);

        TiledMapTileLayer.Cell newCell = walls.getCell(newPosX, newPosY);
        TiledMapTileLayer.Cell currentCell = walls.getCell((int) player.getPosX(), (int) player.getPosY());

        int newPosWallId = 0;
        int currentPosWallId = 0;
        if(newCell != null)  { newPosWallId = newCell.getTile().getId();}
        if(currentCell != null) { currentPosWallId = currentCell.getTile().getId();}

        for(Direction wall : idToWallName.get(newPosWallId)) {
            if(dir == Direction.invert(wall)) {
                return false;
            }
        }
        for(Direction wall : idToWallName.get(currentPosWallId)) {
            if(dir == wall) {
                return false;
            }
        }
        return true;
    }
}
