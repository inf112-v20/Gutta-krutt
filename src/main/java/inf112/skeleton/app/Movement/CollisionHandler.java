package inf112.skeleton.app.Movement;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Direction;

import java.util.HashMap;

public class CollisionHandler extends InputAdapter {
    Player player;
    TiledMap tilemap;

    public CollisionHandler(Player player, TiledMap tilemap) {
        this.player = player;
        this.tilemap = tilemap;
    }

    public boolean canMove(Direction dir, int newPosX, int newPosY) {
        HashMap<Integer, Direction> idToWallName = new HashMap<>();
        TiledMapTileLayer walls = (TiledMapTileLayer) tilemap.getLayers().get("Walls");

        idToWallName.put(31,Direction.NORTH);
        idToWallName.put(23,Direction.EAST);
        idToWallName.put(30,Direction.WEST);
        idToWallName.put(29,Direction.SOUTH);
        idToWallName.put(24, Direction.NORTH);//northwest
        idToWallName.put(32,Direction.SOUTH); //southwest
        idToWallName.put(16,Direction.NORTH); // northeast
        idToWallName.put(8,Direction.SOUTH); // southeast
        idToWallName.put(0,Direction.DEFAULT);

        TiledMapTileLayer.Cell newCell = walls.getCell(newPosX, newPosY);
        TiledMapTileLayer.Cell currentCell = walls.getCell((int) player.getPosX(), (int) player.getPosY());

        int newPosWallId = 0;
        int currentPosWallId = 0;
        if(newCell != null)  { newPosWallId = newCell.getTile().getId();}
        if(currentCell != null) { currentPosWallId = currentCell.getTile().getId();}

        if(dir == Direction.invert(idToWallName.get(newPosWallId))) {
            return false;
        } else if(dir == idToWallName.get(currentPosWallId)) {
            return false;
        }

        return true;
    }
}
