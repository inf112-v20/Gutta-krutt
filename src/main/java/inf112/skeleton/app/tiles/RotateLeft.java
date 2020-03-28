package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;

public class RotateLeft implements ActionTiles {

    TiledMap tiledmap;

    public RotateLeft(TiledMap tiledmap) {
        this.tiledmap = tiledmap;
    }

    @Override
    public void tileAction(Player player) {
        if(isRotator(player)) {
            player.setRotation((player.getRotation()+TiledMapTileLayer.Cell.ROTATE_90) % 4);
        }
    }

    private boolean isRotator(Player player) {
        TiledMapTileLayer rotator = (TiledMapTileLayer) tiledmap.getLayers().get("red_Rotator");
        TiledMapTileLayer.Cell currentTile = rotator.getCell((int) player.getPosX(), (int) player.getPosY());

        return currentTile != null;
    }

}
