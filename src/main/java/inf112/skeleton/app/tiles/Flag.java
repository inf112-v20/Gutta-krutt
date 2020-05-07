package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.player.Player;

/**
 * a flag object for all flags in a map
 * @author sedric, fredrik
 */
public class Flag implements ActionTiles{

    private TiledMap tiledmap;

    public Flag(TiledMap tiledmap) {
        this.tiledmap = tiledmap;
    }

    /**
     * checks if a player is standing on a hole and sets checkpoint to the flag location if so
     * @param player, the player the action is to be executed on
     */
    @Override
    public boolean tileAction(Player player) {
        if(isFlag(player)) {
            player.setCheckpoint();
            player.updateWinCondition();
            System.out.println("Updated checkpoint");
            return true;
        }
        return false;
    }

    /**
     * @param player player to be checked
     * @return true if a player is standing on a flag and false otherwise
     */
    private boolean isFlag(Player player) {
        TiledMapTileLayer flag = (TiledMapTileLayer) tiledmap.getLayers().get("Flag");
        TiledMapTileLayer.Cell currentTile = flag.getCell((int) player.getPosX(), (int) player.getPosY());

        return currentTile != null;
    }
}
