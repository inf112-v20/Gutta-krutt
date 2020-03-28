package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;

public class Hole implements ActionTiles {

    private TiledMap tiledmap;

    public Hole(TiledMap tiledmap) {
        this.tiledmap = tiledmap;
    }

    @Override
    public void tileAction(Player player) {
        if (isHole(player)) {
            player.isDestoyed();
            player.setPos(player.getCheckpoint());
        }
    }

    public boolean isHole(Player player) {
        TiledMapTileLayer hole = (TiledMapTileLayer) tiledmap.getLayers().get("Hole");
        TiledMapTileLayer.Cell currentTile = hole.getCell((int) player.getPosX(), (int) player.getPosY());

        return currentTile != null;
    }
}
