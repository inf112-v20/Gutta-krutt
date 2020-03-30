package inf112.skeleton.app.Movement;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Direction;
import inf112.skeleton.app.tiles.*;

/**
 * handling all movement connected to the board
 * @author sedric
 */
public class MovementHandler {
    Player player;
    TiledMap tilemap;
    CollisionHandler collisionHandler;

    ActionTiles[] actionTiles;

    /**
     *
     * @param player the player to be moved around the map
     * @param tilemap the tilemap the movementHandler connects to
     */
    public MovementHandler(Player player, TiledMap tilemap) {
       this.player = player;
       this.tilemap = tilemap;

       initializeTiles();
    }

    private void initializeTiles() {
        collisionHandler = new CollisionHandler(tilemap);
        ActionTiles hole = new Hole(tilemap);
        ActionTiles rotateLeft = new RotateLeft(tilemap);
        ActionTiles rotateRight = new RotateRight(tilemap);
        ActionTiles flag = new Flag(tilemap);
        ActionTiles repair = new Repair(tilemap);
        //-1 is placeholder for no roation
        ActionTiles slowBeltDown = new Belt(tilemap, Direction.SOUTH, -1, new int[]{50}, 1, "Conveyor_Belt_Yellow");
        ActionTiles slowBeltRotateDown = new Belt(tilemap, Direction.SOUTH, TiledMapTileLayer.Cell.ROTATE_180, new int[]{33,36}, 1, "Conveyor_Belt_Yellow");
        ActionTiles slowBeltUp = new Belt(tilemap, Direction.NORTH, -1, new int[]{49}, 1, "Conveyor_Belt_Yellow");
        ActionTiles slowBeltLeft = new Belt(tilemap, Direction.WEST, -1, new int[]{51}, 1, "Conveyor_Belt_Yellow");
        ActionTiles slowBeltRight = new Belt(tilemap, Direction.EAST, -1, new int[]{52}, 1, "Conveyor_Belt_Yellow");
        ActionTiles fastBeltUp = new Belt(tilemap, Direction.NORTH,-1, new int[]{13}, 2, "Conveyor_Belt_Blue");
        ActionTiles fastBeltleft = new Belt(tilemap, Direction.WEST,-1, new int[]{22}, 2, "Conveyor_Belt_Blue");
        ActionTiles fastBeltRotateLeft = new Belt(tilemap, Direction.WEST, TiledMapTileLayer.Cell.ROTATE_270, new int[]{28}, 2, "Conveyor_Belt_Blue");
        ActionTiles fastBeltRotateUp = new Belt(tilemap, Direction.NORTH,TiledMapTileLayer.Cell.ROTATE_0, new int[]{77}, 2, "Conveyor_Belt_Blue");

        actionTiles = new ActionTiles[]{hole,rotateLeft,rotateRight,flag,repair,slowBeltDown,slowBeltRotateDown,slowBeltUp,slowBeltLeft,slowBeltRight,
                fastBeltUp,fastBeltleft,fastBeltRotateLeft,fastBeltRotateUp};

    }

    public boolean movePlayer(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                return movePlayer(Direction.NORTH);
            case Input.Keys.DOWN:
                return movePlayer(Direction.SOUTH);
            case Input.Keys.LEFT:
                return movePlayer(Direction.WEST);
            case Input.Keys.RIGHT:
                return movePlayer(Direction.EAST);
            default:
                return false;
        }
    }

    /**
     * moves a player in a one of four directions if possible
     * @param dir the direction to move the player
     * @return
     */
    public boolean movePlayer(Direction dir) {
        player.renderPlayerTexture();

        //clearing the previouse tile
        TiledMapTileLayer playerLayer = (TiledMapTileLayer) tilemap.getLayers().get("Player");
        playerLayer.setCell((int)player.getPosX(),(int)player.getPosY(), null);

        if(dir == Direction.NORTH && collisionHandler.canMove(player, dir, (int)player.getPosX(),(int)player.getPosY()+1)){
            player.setPosY(1);
        }
        else if(dir == Direction.SOUTH && collisionHandler.canMove(player, dir, (int)player.getPosX(),(int)player.getPosY()-1)) {
            player.setPosY(-1);
        }
        else if(dir == Direction.WEST && collisionHandler.canMove(player, dir, (int)player.getPosX()-1,(int)player.getPosY())) {
            player.setPosX(-1);
        }
        else if(dir == Direction.EAST && collisionHandler.canMove(player, dir, (int)player.getPosX()+1,(int)player.getPosY())) {
            player.setPosX(1);
        }
        else {
            playerLayer.setCell((int) player.getPosX(), (int) player.getPosY(), player.getPlayerNormal()); return false;
        }

        //activates tileaction for all tiles
        for(ActionTiles tile : actionTiles) {
            tile.tileAction(player);
        }

        outOfBoard();
        //setting the new player tile
        playerLayer.setCell((int) player.getPosX(), (int)player.getPosY(), player.getPlayerNormal());
        return true;
    }

    //TODO: bugg in out of bounds of board
    private void outOfBoard() {
        if(player.getPosX() < 0 || player.getPosX() > 11 || player.getPosY() < 0 || player.getPosY() > 11) {
            player.isDestoyed();
            player.setPos(player.getCheckpoint());
        }
    }
}
