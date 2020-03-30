package inf112.skeleton.app.Movement;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Direction;

/**
 * handling all movement connected to the board
 * @author sedric, Oskar Marthinussen
 */
public class MovementHandler {
    Player player;
    TiledMap tilemap;
    CollisionHandler collisionHandler;

    /**
     *
     * @param tilemap the tilemap the movementHandler connects to
     */
    public MovementHandler(Player player, TiledMap tilemap) {
        this.player = player;
        this.tilemap = tilemap;
        this.collisionHandler = new CollisionHandler(this.player, tilemap);
    }

    /**
     * Rotates the player 90 degrees to the right.
     */
    public void rotatePlayerRight(){
        int currentDirection = player.getDirection();
        if (currentDirection == 0) {
            player.setDirection(3);
            player.getPlayerNormal().setRotation(3);
        }
        else{
            player.setDirection(currentDirection - 1);
            player.getPlayerNormal().setRotation(currentDirection - 1);
        }
    }

    /**
     * Rotates the player 90 degrees to the left.
     */
    public void rotatePlayerLeft(){
        int currentDirection = player.getDirection();
        int newDirection = (currentDirection + 1) % 4;
        player.setDirection(newDirection);
        player.getPlayerNormal().setRotation(player.getDirection());

    }

    /**
     * Get direction based on the number the player-variable (int) direction.
     * @param direction a number between 0-3 where each number represent a direction.
     * @return the direction as an enum value.
     */
    public Direction getDirection(int direction){
        switch(direction){
            case(0): return Direction.NORTH;
            case(1): return Direction.WEST;
            case(2): return Direction.SOUTH;
            case(3): return Direction.EAST;
            default: return null;
        }
    }

    /**
     * moves a player in a one of four directions if possible
     * @return moved the player
     */
    public boolean movePlayer() {
        Direction dir = getDirection(player.getDirection());
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
            playerLayer.setCell((int) player.getPosX(), (int) player.getPosY(), player.getPlayerNormal());
            return false;
        }

        //setting the new player tile
        playerLayer.setCell((int) player.getPosX(), (int)player.getPosY(), player.getPlayerNormal());
        return true;
    }
}
