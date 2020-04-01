package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;

/**
 * @author sedric, fredrik
 */
public class RotateRight implements ActionTiles {


    TiledMap tiledmap;

    public RotateRight(TiledMap tiledmap) {
        this.tiledmap = tiledmap;
    }

    /**
     * checks if a player is on a rotate tile
     * sets the rotation of a player to -90 degrees
     * @param player, the player the action is to be executed on
     */
    @Override
    public boolean tileAction(Player player) {
        if(isRotator(player)) {
            player.setRotation((player.getRotation()+ TiledMapTileLayer.Cell.ROTATE_270) % 4);
            return true;
        }
        return false;
    }

    /**
     * checks if the player is standing on a rotate tile
     * @param player the player to be checked
     * @return true if the player is on the tile and false otherwise
     */
    private boolean isRotator(Player player) {
        TiledMapTileLayer rotator = (TiledMapTileLayer) tiledmap.getLayers().get("green_Rotator");
        TiledMapTileLayer.Cell currentTile = rotator.getCell((int) player.getPosX(), (int) player.getPosY());

        if(currentTile != null) { return true;}
        return false;
    }
}
