package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.player.Player;

/**
 * checks if a Player is standing on a Hole-tile and executes the command corresponding to the hole tile
 * @author sedric, fredrik
 */
public class Hole implements ActionTiles {

    private TiledMap tiledmap;

    public Hole(TiledMap tiledmap) {
        this.tiledmap = tiledmap;
    }

    /**
     * executes the action corresponding to a hole
     * @param player, the player the action is to be executed on
     */
    @Override
    public boolean tileAction(Player player) {
        if (isHole(player)) {
            player.destroyed();
            player.addPos(player.getCheckpoint());
            return true;
        }
        return false;
    }

    /**
     * @param player, player to be checked
     * @return returns true if the player is standing on a tile corresponding to a hole, false otherwise
     */
    public boolean isHole(Player player) {
        TiledMapTileLayer hole = (TiledMapTileLayer) tiledmap.getLayers().get("Hole");
        TiledMapTileLayer.Cell currentTile = hole.getCell((int) player.getPosX(), (int) player.getPosY());

        return currentTile != null;
    }
}
