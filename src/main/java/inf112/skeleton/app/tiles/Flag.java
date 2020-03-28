package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;

public class Flag implements ActionTiles{

    private TiledMap tiledmap;

    public Flag(TiledMap tiledmap) {
        this.tiledmap = tiledmap;
    }


    @Override
    public void tileAction(Player player) {
        if(isFlag(player)) {
            player.setCheckpoint();
        }
    }

    private boolean isFlag(Player player) {
        TiledMapTileLayer flag = (TiledMapTileLayer) tiledmap.getLayers().get("Flag");
        TiledMapTileLayer.Cell currentTile = flag.getCell((int) player.getPosX(), (int) player.getPosY());

        return currentTile != null;
    }
}
