package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;

public class Repair implements ActionTiles {

    TiledMap tiledmap;

    public Repair (TiledMap tiledmap) {
        this.tiledmap = tiledmap;
    }

    @Override
    public void tileAction(Player player) {
        if(isRepair(player)) {
            player.setFullHealth();
        }
    }

    private boolean isRepair(Player player) {
        TiledMapTileLayer repair = (TiledMapTileLayer) tiledmap.getLayers().get("Repair");
        TiledMapTileLayer.Cell currentTile = repair.getCell((int) player.getPosX(), (int) player.getPosY());

        return currentTile != null;
    }
}
