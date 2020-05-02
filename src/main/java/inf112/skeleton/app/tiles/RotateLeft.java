package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;

public class RotateLeft implements ActionTiles {

    TiledMap tiledmap;

    public RotateLeft(TiledMap tiledmap) {
        this.tiledmap = tiledmap;
    }

    /**
     * checks if a player is standing on a rotator
     * rotates the player 90 degrees to the left if that is the case
     * @param player, the player the action is to be executed on
     */
    @Override
    public boolean tileAction(Player player) {
        if(isRotator(player)) {
            player.setRotation((player.getRotation()+TiledMapTileLayer.Cell.ROTATE_90) % 4);
            return true;
        }
        return false;
    }

    /**
     * checks if a player is standing on a rotator tile
     * @param player the player to be checked
     * @return true if the player is standing on a rotate tile and false otherwise
     */
    private boolean isRotator(Player player) {
        TiledMapTileLayer rotator = (TiledMapTileLayer) tiledmap.getLayers().get("red_Rotator");
        TiledMapTileLayer.Cell currentTile = rotator.getCell((int) player.getPosX(), (int) player.getPosY());

        return currentTile != null;
    }

}