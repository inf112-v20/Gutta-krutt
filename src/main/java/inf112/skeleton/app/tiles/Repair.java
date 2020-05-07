package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.player.Player;

/**
 * @author Sedric Kvarnes, Fredrik Larsen
 */
public class Repair implements ActionTiles {

    TiledMap tiledmap;

    public Repair (TiledMap tiledmap) {
        this.tiledmap = tiledmap;
    }

    /**
     * checks if the player is standing on a repair tile
     * sets the players health to full if that is the case
     * @param player, the player the action is to be executed on
     */
    @Override
    public boolean tileAction(Player player) {
        if(isRepair(player)) {
            player.setFullHealth();
            return true;
        }
        return false;
    }

    /**
     *
     * @param player the player to be checked
     * @return returns true if player is standing on a repair tile and false otherwise
     */
    private boolean isRepair(Player player) {
        TiledMapTileLayer repair = (TiledMapTileLayer) tiledmap.getLayers().get("Repair");
        TiledMapTileLayer.Cell currentTile = repair.getCell((int) player.getPosX(), (int) player.getPosY());

        return currentTile != null;
    }
}
