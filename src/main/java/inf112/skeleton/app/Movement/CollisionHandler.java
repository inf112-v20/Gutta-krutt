package inf112.skeleton.app.Movement;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Direction;

import java.util.Arrays;
import java.util.HashMap;

public class CollisionHandler extends InputAdapter {
    Player player;
    TiledMap tilemap;

    public CollisionHandler(Player player, TiledMap tilemap) {
        this.player = player;
        this.tilemap = tilemap;
    }

    public boolean canMove(Direction dir, int newPosX, int newPosY) {
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
        Direction[] deafult = {Direction.DEFAULT};

        idToWallName.put(31,north);
        idToWallName.put(23,east);
        idToWallName.put(30,west);
        idToWallName.put(29,south);
        idToWallName.put(24,northWest);
        idToWallName.put(32,southWest);
        idToWallName.put(16,northEast);
        idToWallName.put(8,southEast);
        idToWallName.put(0,deafult);

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