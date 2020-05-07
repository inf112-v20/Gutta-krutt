package inf112.skeleton.app.Movement;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Direction;
import inf112.skeleton.app.tiles.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * handling all movement connected to the board
 * @author sedric
 */
public class MovementHandler {
    TiledMap tilemap;
    ActionTiles[] actionTiles;
    Belt[] belts;
    ArrayList<Player> players;

    /**
     * @param tilemap the tilemap the movementHandler connects with
     * @param players all the players you want to be moveable on the map
     */
    public MovementHandler(TiledMap tilemap, ArrayList<Player> players) {
       this.tilemap = tilemap;
       initializeTiles();
       this.players = players;
    }

    /**
     * initialize all the different actionTiles
     */
    private void initializeTiles() {
        ActionTiles hole = new Hole(tilemap);
        ActionTiles rotateLeft = new RotateLeft(tilemap);
        ActionTiles rotateRight = new RotateRight(tilemap);
        ActionTiles flag = new Flag(tilemap);
        ActionTiles repair = new Repair(tilemap);
        //-1 is placeholder for no roation
        Belt slowBeltDown = new Belt(tilemap, Direction.SOUTH, -1, new int[]{50}, 1, "Conveyor_Belt_Yellow");
        Belt slowBeltRotateDown = new Belt(tilemap, Direction.SOUTH, TiledMapTileLayer.Cell.ROTATE_180, new int[]{33,36}, 1, "Conveyor_Belt_Yellow");
        Belt slowBeltUp = new Belt(tilemap, Direction.NORTH, -1, new int[]{49}, 1, "Conveyor_Belt_Yellow");
        Belt slowBeltLeft = new Belt(tilemap, Direction.WEST, -1, new int[]{51}, 1, "Conveyor_Belt_Yellow");
        Belt slowBeltRight = new Belt(tilemap, Direction.EAST, -1, new int[]{52}, 1, "Conveyor_Belt_Yellow");
        Belt fastBeltUp = new Belt(tilemap, Direction.NORTH,-1, new int[]{13}, 2, "Conveyor_Belt_Blue");
        Belt fastBeltleft = new Belt(tilemap, Direction.WEST,-1, new int[]{22}, 2, "Conveyor_Belt_Blue");
        Belt fastBeltRotateLeft = new Belt(tilemap, Direction.WEST, TiledMapTileLayer.Cell.ROTATE_270, new int[]{28}, 2, "Conveyor_Belt_Blue");
        Belt fastBeltRotateUp = new Belt(tilemap, Direction.NORTH,TiledMapTileLayer.Cell.ROTATE_0, new int[]{77}, 2, "Conveyor_Belt_Blue");
        Belt fastBeltDown = new Belt(tilemap, Direction.SOUTH,-1, new int[]{21}, 2, "Conveyor_Belt_Blue");

        actionTiles = new ActionTiles[]{hole,rotateLeft,rotateRight,flag,repair};

        belts = new Belt[]{slowBeltDown,slowBeltRotateDown,slowBeltUp,slowBeltLeft,slowBeltRight,
                fastBeltUp,fastBeltleft,fastBeltRotateLeft,fastBeltRotateUp,fastBeltDown};
    }

    /**
     * moves the player in a given direction, depending on keycode
     * @param keycode keycode from keyboard
     * @return true if valid keycode, false otherwise
     */
    public boolean movePlayer(int keycode, Player player) {
        switch (keycode) {
            case Input.Keys.UP:
                return movePlayer(Direction.NORTH, player);
            case Input.Keys.DOWN:
                return movePlayer(Direction.SOUTH, player);
            case Input.Keys.LEFT:
                return movePlayer(Direction.WEST, player);
            case Input.Keys.RIGHT:
                return movePlayer(Direction.EAST, player);
            default:
                return false;
        }
    }

    /**
     * moves a player in a one of four directions if possible
     * @return returns true if valid movement, false otherwise
     */
    public boolean movePlayer(Direction dir, Player player) {
        player.renderPlayerTexture();

        //clearing the previouse tile
        TiledMapTileLayer playerLayer = (TiledMapTileLayer) tilemap.getLayers().get("Player");
        playerLayer.setCell((int)player.getPosX(),(int)player.getPosY(), null);

        if(dir == Direction.NORTH && !isWall(player, dir, (int)player.getPosX(),(int)player.getPosY()+1)){
            player.addPosY(1);
        }
        else if(dir == Direction.SOUTH && !isWall(player, dir, (int)player.getPosX(),(int)player.getPosY()-1)) {
            player.addPosY(-1);
        }
        else if(dir == Direction.WEST && !isWall(player, dir, (int)player.getPosX()-1,(int)player.getPosY())) {
            player.addPosX(-1);
        }
        else if(dir == Direction.EAST && !isWall(player, dir, (int)player.getPosX()+1,(int)player.getPosY())) {
            player.addPosX(1);
        }
        else {
            playerLayer.setCell((int) player.getPosX(), (int) player.getPosY(), player.getPlayerNormal());
            return false;
        }

        for(Belt belt : belts) {
            if(belt.tileAction(player)) break;
        }

        //checks if a player is on a an actionTile and executes that tileAction
        // only one tileAction will be called, i.e not allowed to activate more than one tile even if you jump to another ActionTile.
        for(ActionTiles tile : actionTiles) {
            if(tile.tileAction(player)) break;
        }

        pushPlayer(player, dir);
        //setting the new player tile
        playerLayer.setCell((int) player.getPosX(), (int)player.getPosY(), player.getPlayerNormal());
        return true;
    }

    private boolean pushPlayer(Player player, Direction dir) {
        Vector2 playerPos = player.getPos();
        for(Player play: players) {
            if(play == player) continue;
            if (playerPos.x == play.getPos().x && playerPos.y == play.getPos().y) {
                movePlayer(dir, play);
            }
        }
        return true;
    }

    /**
     * checks if a player can move to the newPos tile
     * @param dir direction to move player
     * @param newPosX the new X position of player
     * @param newPosY the new Y position of player
     * @return true if it is possible to move to the new location and false otherwise
     */
    public boolean isWall(Player player, Direction dir, int newPosX, int newPosY) {
        HashMap<Integer, Direction[]> idToWallName = new HashMap<>();
        TiledMapTileLayer walls = (TiledMapTileLayer) tilemap.getLayers().get("Walls");

        idToWallName.put(31, new Direction[]{Direction.NORTH});
        idToWallName.put(23, new Direction[]{Direction.EAST});
        idToWallName.put(30, new Direction[]{Direction.WEST});
        idToWallName.put(29, new Direction[]{Direction.SOUTH});
        idToWallName.put(24, new Direction[]{Direction.NORTH, Direction.WEST});
        idToWallName.put(32, new Direction[]{Direction.SOUTH, Direction.WEST});
        idToWallName.put(16, new Direction[]{Direction.NORTH, Direction.EAST});
        idToWallName.put(8, new Direction[]{Direction.SOUTH, Direction.EAST});
        idToWallName.put(0, new Direction[]{Direction.DEFAULT});

        TiledMapTileLayer.Cell newCell = walls.getCell(newPosX, newPosY);
        TiledMapTileLayer.Cell currentCell = walls.getCell((int) player.getPosX(), (int) player.getPosY());

        int newPosWallId = 0;
        int currentPosWallId = 0;
        if(newCell != null)  { newPosWallId = newCell.getTile().getId();}
        if(currentCell != null) { currentPosWallId = currentCell.getTile().getId();}

        for(Direction wall : idToWallName.get(newPosWallId)) {
            if(dir == Direction.invert(wall)) {
                return true;
            }
        }
        for(Direction wall : idToWallName.get(currentPosWallId)) {
            if(dir == wall) {
                return true;
            }
        }
        return false;
    }

}
