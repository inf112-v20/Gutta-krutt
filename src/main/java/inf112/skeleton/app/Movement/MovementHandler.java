package inf112.skeleton.app.Movement;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
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
    ActionTiles hole;
    ActionTiles rotateLeft;
    ActionTiles rotateRight;
    ActionTiles flag;
    ActionTiles repair;

    /**
     *
     * @param player the player to be moved around the map
     * @param tilemap the tilemap the movementHandler connects to
     */
    public MovementHandler(Player player, TiledMap tilemap) {
       this.player = player;
       this.tilemap = tilemap;
       collisionHandler = new CollisionHandler(player, tilemap);
       hole = new Hole(tilemap);
       rotateLeft = new RotateLeft(tilemap);
       rotateRight = new RotateRight(tilemap);
       flag = new Flag(tilemap);
       repair = new Repair(tilemap);
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

        if(dir == Direction.NORTH && collisionHandler.canMove(dir, (int)player.getPosX(),(int)player.getPosY()+1)){
            player.setPosY(1);
            player.setRotation(TiledMapTileLayer.Cell.ROTATE_0);
        }
        else if(dir == Direction.SOUTH && collisionHandler.canMove(dir, (int)player.getPosX(),(int)player.getPosY()-1)) {
            player.setPosY(-1);
            player.setRotation(TiledMapTileLayer.Cell.ROTATE_180);
        }
        else if(dir == Direction.WEST && collisionHandler.canMove(dir, (int)player.getPosX()-1,(int)player.getPosY())) {
            player.setPosX(-1);
            player.setRotation(TiledMapTileLayer.Cell.ROTATE_90);
        }
        else if(dir == Direction.EAST && collisionHandler.canMove(dir, (int)player.getPosX()+1,(int)player.getPosY())) {
            player.setPosX(1); player.setRotation(TiledMapTileLayer.Cell.ROTATE_270);
        }
        else {
            playerLayer.setCell((int) player.getPosX(), (int) player.getPosY(), player.getPlayerNormal()); return false;
        }



        hole.tileAction(player);
        rotateLeft.tileAction(player);
        rotateRight.tileAction(player);
        flag.tileAction(player);
        repair.tileAction(player);
        outOfBoard();
        //setting the new player tile
        playerLayer.setCell((int) player.getPosX(), (int)player.getPosY(), player.getPlayerNormal());
        return true;
    }

    //TODO: bugg in out of bounds of board
    private void outOfBoard() {
        if(player.getPosX() < 0 || player.getPosX() > 12) {
            player.isDestoyed();
            player.setPos(player.getCheckpoint());
        }
        if(player.getPosY() < 0 || player.getPosY() > 12) {
            player.isDestoyed();
            player.setPos(player.getCheckpoint());
        }
    }

}
