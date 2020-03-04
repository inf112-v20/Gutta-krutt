package inf112.skeleton.app.Movement;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Direction;


public class MovementHandler {
    Player player;
    TiledMap tilemap;
    CollisionHandler collisionHandler;

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

    public boolean movePlayer(Direction dir) {

        player.renderPlayerTexture();
        //clearing the previouse tile
        TiledMapTileLayer playerLayer = (TiledMapTileLayer) tilemap.getLayers().get("Player");
        playerLayer.setCell((int)player.getPosX(),(int)player.getPosY(), null);

        if(dir == Direction.NORTH && collisionHandler.canMove(dir, (int)player.getPosX(),(int)player.getPosY()+1)){ player.setPosY(1); player.setRotation(TiledMapTileLayer.Cell.ROTATE_0);}
        else if(dir == Direction.SOUTH && collisionHandler.canMove(dir, (int)player.getPosX(),(int)player.getPosY()-1)) {player.setPosY(-1); player.setRotation(TiledMapTileLayer.Cell.ROTATE_180);}
        else if(dir == Direction.WEST && collisionHandler.canMove(dir, (int)player.getPosX()-1,(int)player.getPosY())) {player.setPosX(-1); player.setRotation(TiledMapTileLayer.Cell.ROTATE_90);}
        else if(dir == Direction.EAST && collisionHandler.canMove(dir, (int)player.getPosX()+1,(int)player.getPosY())) {player.setPosX(1); player.setRotation(TiledMapTileLayer.Cell.ROTATE_270);}
        else { playerLayer.setCell((int) player.getPosX(), (int) player.getPosY(), player.getPlayerNormal()); return false;}


        //setting the new player tile
        playerLayer.setCell((int) player.getPosX(), (int)player.getPosY(), player.getPlayerNormal());
        return true;
    }

}
