package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;

public class RotateRight implements ActionTiles {


    TiledMap tiledmap;

    public RotateRight(TiledMap tiledmap) {
        this.tiledmap = tiledmap;
    }

    @Override
    public void tileAction(Player player) {
        if(isRotator(player)) {
            player.setRotation((player.getRotation()+ TiledMapTileLayer.Cell.ROTATE_270) % 4);
        }
    }

    private boolean isRotator(Player player) {
        TiledMapTileLayer rotator = (TiledMapTileLayer) tiledmap.getLayers().get("green_Rotator");
        TiledMapTileLayer.Cell currentTile = rotator.getCell((int) player.getPosX(), (int) player.getPosY());

        if(currentTile != null) { return true;}
        return false;
    }
}
