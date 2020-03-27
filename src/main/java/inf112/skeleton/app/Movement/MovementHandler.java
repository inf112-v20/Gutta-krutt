package inf112.skeleton.app.Movement;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Direction;

/**
 * handling all movement connected to the board
 * @author sedric
 */
public class MovementHandler {
    Player player;
    TiledMap tilemap;
    CollisionHandler collisionHandler;

    /**
     *
     * @param player the player to be moved around the map
     * @param tilemap the tilemap the movementHandler connects to
     */
    public MovementHandler(Player player, TiledMap tilemap) {
       this.player = player;
       this.tilemap = tilemap;
       collisionHandler = new CollisionHandler(player, tilemap);
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
     * @return moved the player
     */

    public boolean movePlayer(Direction dir) {
        player.renderPlayerTexture();
        //clearing the previouse tile
        TiledMapTileLayer playerLayer = (TiledMapTileLayer) tilemap.getLayers().get("Player");
        playerLayer.setCell((int)player.getPosX(),(int)player.getPosY(), null);

        if(dir == Direction.NORTH && collisionHandler.canGo(dir, (int)player.getPosX(),(int)player.getPosY()+1)){
            player.setPosY(1);
        }
        else if(dir == Direction.SOUTH && collisionHandler.canGo(dir, (int)player.getPosX(),(int)player.getPosY()-1)) {
            player.setPosY(-1);
        }
        else if(dir == Direction.WEST && collisionHandler.canGo(dir, (int)player.getPosX()-1,(int)player.getPosY())) {
            player.setPosX(-1);
        }
        else if(dir == Direction.EAST && collisionHandler.canGo(dir, (int)player.getPosX()+1,(int)player.getPosY())) {
            player.setPosX(1);
        }
        else {
            playerLayer.setCell((int) player.getPosX(), (int) player.getPosY(), player.getPlayerNormal()); return false;
        }


        //setting the new player tile
        playerLayer.setCell((int) player.getPosX(), (int)player.getPosY(), player.getPlayerNormal());
        return true;
    }

    public void moveSteps(Direction dir, int steps) {
        for(int i = 0; i < steps; i++) {
            movePlayer(dir);
        }
    }
}
