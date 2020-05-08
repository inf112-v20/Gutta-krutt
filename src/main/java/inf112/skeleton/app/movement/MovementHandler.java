package inf112.skeleton.app.movement;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.player.Player;
import inf112.skeleton.app.cards.Direction;
import inf112.skeleton.app.tiles.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Handling all movement connected to the board
 * @author sedric
 */
public class MovementHandler {
    TiledMap tilemap;
    ActionTiles[] actionTiles;
    Belt[] belts;
    ArrayList<Player> players;

    /**
     * @param tilemap the tilemap the movementHandler connects with
     * @param players all the players you want to be movable on the map
     */
    public MovementHandler(TiledMap tilemap, ArrayList<Player> players) {
       this.tilemap = tilemap;
       initializeTiles();
       this.players = players;
    }

    /**
     * Initialize all the different tiles
     */
    private void initializeTiles() {
        ActionTiles hole = new Holes(tilemap);
        ActionTiles flag = new Flag(tilemap);
        ActionTiles repair = new Repair(tilemap);

        //-1 is placeholder for no rotation

        //Regular
        Belt Slow_Belt_North = new Belt(tilemap, Direction.NORTH, -1, new int[]{49}, 1, "Regular_Conveyor_belt");
        Belt Slow_Belt_West = new Belt(tilemap, Direction.WEST, -1, new int[]{51}, 1, "Regular_Conveyor_belt");
        Belt Slow_Belt_East = new Belt(tilemap, Direction.EAST, -1, new int[]{52}, 1, "Regular_Conveyor_belt");
        Belt Slow_Belt_South = new Belt(tilemap, Direction.SOUTH, -1, new int[]{50}, 1, "Regular_Conveyor_belt");

        Belt Slow_Belt_North_East = new Belt(tilemap, Direction.EAST, TiledMapTileLayer.Cell.ROTATE_270, new int[]{35}, 1, "Regular_Conveyor_belt");
        Belt Slow_Belt_East_South = new Belt(tilemap, Direction.SOUTH, TiledMapTileLayer.Cell.ROTATE_270, new int[]{36}, 1, "Regular_Conveyor_belt");
        Belt Slow_Belt_South_West = new Belt(tilemap, Direction.WEST, TiledMapTileLayer.Cell.ROTATE_270, new int[]{44}, 1, "Regular_Conveyor_belt");
        Belt Slow_Belt_West_North = new Belt(tilemap, Direction.NORTH, TiledMapTileLayer.Cell.ROTATE_270, new int[]{43}, 1, "Regular_Conveyor_belt");

        Belt Slow_Belt_North_West = new Belt(tilemap, Direction.WEST, TiledMapTileLayer.Cell.ROTATE_90, new int[]{34}, 1, "Regular_Conveyor_belt");
        Belt Slow_Belt_West_South = new Belt(tilemap, Direction.SOUTH, TiledMapTileLayer.Cell.ROTATE_90, new int[]{33}, 1, "Regular_Conveyor_belt");
        Belt Slow_Belt_South_East = new Belt(tilemap, Direction.EAST, TiledMapTileLayer.Cell.ROTATE_90, new int[]{41}, 1, "Regular_Conveyor_belt");
        Belt Slow_Belt_East_North = new Belt(tilemap, Direction.NORTH, TiledMapTileLayer.Cell.ROTATE_90, new int[]{42}, 1, "Regular_Conveyor_belt");

        Belt Fast_Belt_North = new Belt(tilemap, Direction.NORTH,-1, new int[]{13}, 2, "Express_Conveyor_belt");
        Belt Fast_Belt_West = new Belt(tilemap, Direction.WEST,-1, new int[]{22}, 2, "Express_Conveyor_belt");
        Belt Fast_Belt_East = new Belt(tilemap, Direction.EAST,-1, new int[]{14}, 2, "Express_Conveyor_belt");
        Belt Fast_Belt_South = new Belt(tilemap, Direction.SOUTH,-1, new int[]{21}, 2, "Express_Conveyor_belt");

        Belt Express_North_East = new Belt(tilemap, Direction.EAST, TiledMapTileLayer.Cell.ROTATE_270, new int[]{19}, 2, "Express_Conveyor_belt");
        Belt Express_East_South = new Belt(tilemap, Direction.SOUTH, TiledMapTileLayer.Cell.ROTATE_270, new int[]{20}, 2, "Express_Conveyor_belt");
        Belt Express_South_West = new Belt(tilemap, Direction.WEST, TiledMapTileLayer.Cell.ROTATE_270, new int[]{28}, 2, "Express_Conveyor_belt");
        Belt Express_West_North = new Belt(tilemap, Direction.NORTH, TiledMapTileLayer.Cell.ROTATE_270, new int[]{27}, 2, "Express_Conveyor_belt");
        Belt Express_North_West = new Belt(tilemap, Direction.WEST, TiledMapTileLayer.Cell.ROTATE_90, new int[]{18}, 2, "Express_Conveyor_belt");
        Belt Express_West_South = new Belt(tilemap, Direction.SOUTH, TiledMapTileLayer.Cell.ROTATE_90, new int[]{17}, 2, "Express_Conveyor_belt");
        Belt Express_South_East = new Belt(tilemap, Direction.EAST, TiledMapTileLayer.Cell.ROTATE_90, new int[]{25}, 2, "Express_Conveyor_belt");
        Belt Express_East_North = new Belt(tilemap, Direction.NORTH, TiledMapTileLayer.Cell.ROTATE_90, new int[]{26}, 2, "Express_Conveyor_belt");

        Belt Pusher_Odd_North = new Belt(tilemap, Direction.NORTH, -1, new int[]{3, 11}, 1, "Pushers");
        Belt Pusher_Odd_East = new Belt(tilemap, Direction.EAST, -1, new int[]{4, 12}, 1, "Pushers");
        Belt Pusher_Odd_South = new Belt(tilemap, Direction.SOUTH, -1, new int[]{1, 9}, 1, "Pushers");
        Belt Pusher_Odd_West = new Belt(tilemap, Direction.WEST, -1, new int[]{2, 10}, 1, "Pushers");

        Belt Gear_red = new Belt(tilemap, Direction.DEFAULT,TiledMapTileLayer.Cell.ROTATE_90, new int[]{53}, 0, "Gears");
        Belt Gear_green = new Belt(tilemap, Direction.DEFAULT,TiledMapTileLayer.Cell.ROTATE_270, new int[]{54}, 0, "Gears");

        actionTiles = new ActionTiles[]{hole, flag, repair};

        belts = new Belt[]{Slow_Belt_North, Slow_Belt_West, Slow_Belt_East, Slow_Belt_South, Slow_Belt_North_East, Slow_Belt_East_South, Slow_Belt_South_West, Slow_Belt_West_North,
                Slow_Belt_North_West, Slow_Belt_West_South, Slow_Belt_South_East, Slow_Belt_East_North, Fast_Belt_North, Fast_Belt_West, Fast_Belt_East, Fast_Belt_South, Express_North_East,
                Express_East_South, Express_South_West, Express_West_North, Express_North_West, Express_West_South, Express_South_East, Express_East_North, Pusher_Odd_North, Pusher_Odd_East,
                Pusher_Odd_South, Pusher_Odd_West, Gear_red, Gear_green,};
    }

    /**
     * This is used for debugging when moving with the arrows.
     * Moves the player in a given direction, depending on keycode
     * @param keycode keycode from keyboard
     * @return true if valid keycode, false otherwise
     */
    public boolean movePlayer(int keycode, Player player) {
        switch (keycode) {
            case 0:
                return movePlayer(Direction.NORTH, player);
            case 2:
                return movePlayer(Direction.SOUTH, player);
            case 1:
                return movePlayer(Direction.WEST, player);
            case 3:
                return movePlayer(Direction.EAST, player);
            default:
                return false;
        }
    }

    /**
     * Moves a player in a one of four directions if possible
     * @return returns true if valid movement, false otherwise
     */
    public boolean movePlayer(Direction dir, Player player) {
        player.renderPlayerTexture();

        //clearing the previouse tile
        TiledMapTileLayer playerLayer = (TiledMapTileLayer) tilemap.getLayers().get("Player");
        playerLayer.setCell((int)player.getPosX(),(int)player.getPosY(), null);

        if(dir == Direction.NORTH && isWall(player, dir, (int) player.getPosX(), (int) player.getPosY() + 1)){
            player.addPosY(1);
        }
        else if(dir == Direction.SOUTH && isWall(player, dir, (int) player.getPosX(), (int) player.getPosY() - 1)) {
            player.addPosY(-1);
        }
        else if(dir == Direction.WEST && isWall(player, dir, (int) player.getPosX() - 1, (int) player.getPosY())) {
            player.addPosX(-1);
        }
        else if(dir == Direction.EAST && isWall(player, dir, (int) player.getPosX() + 1, (int) player.getPosY())) {
            player.addPosX(1);
        }
        else {
            playerLayer.setCell((int) player.getPosX(), (int) player.getPosY(), player.getPlayerNormal());
            return false;
        }

        for(Belt belt : belts) {
            if(belt.tileAction(player)) break;
        }

        pushPlayer(player, dir);

        //checks if a player is on a an actionTile and executes that tileAction
        // only one tileAction will be called, i.e not allowed to activate more than one tile even if you jump to another ActionTile.
        for(ActionTiles tile : actionTiles) {
            if(tile.tileAction(player)) break;
        }
        //setting the new player tile
        outOfBoard(player);
        playerLayer.setCell((int) player.getPosX(), (int)player.getPosY(), player.getPlayerNormal());
        return true;
    }

    /**
     * Pushes a player
     * @param player player to push
     * @param dir direction to push
     * @return true after moving
     */
    private boolean pushPlayer(Player player, Direction dir) {
        Vector2 playerPos = player.getPos();
        for(Player play: players) {
            if(play.equals(player)) continue;
            if (playerPos.x == play.getPos().x && playerPos.y == play.getPos().y) {
                for(Belt belt : belts) {
                    if(belt.isBelt(play)) {
                        belt.tileAction(play);
                        return true;
                    }
                }
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
                return false;
            }
        }
        for(Direction wall : idToWallName.get(currentPosWallId)) {
            if(dir.equals(wall)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a player is outOfBoard.
     * @param player player to be checked.
     */
    private void outOfBoard(Player player) {
        if(player.getPosX() < 0 || player.getPosX() > 11 || player.getPosY() < 0 || player.getPosY() > 14) {
            player.destroyed();
            player.addPos(player.getCheckpoint());
            player.setFullHealth();
        }
    }
}
