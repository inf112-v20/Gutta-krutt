package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.cards.Direction;

import java.util.HashMap;
import java.util.zip.DeflaterInputStream;

public class Belt implements ActionTiles {

    private TiledMap tiledmap;
    private Direction dir;
    private int rotation;
    private final int[] ID;
    private int steps;
    private String layer;

    public Belt(TiledMap tiledmap, Direction dir, int rotation, int[] ID, int steps, String layer) {
        this.tiledmap = tiledmap;
        this.dir = dir;
        this.rotation = rotation;
        this.ID = ID;
        this.steps = steps;
        this.layer = layer;
    }

    @Override
    public void tileAction(Player player) {

        if(isBelt(player)) {
            if(dir == Direction.NORTH) {
                player.setPosY(steps);
            } else if (dir == Direction.SOUTH){
                player.setPosY(-steps);
            } else if (dir == Direction.EAST) {
                player.setPosX(steps);
            } else if (dir == Direction.WEST) {
                player.setPosX(-steps);
            }
            if(rotation != -1) {
                player.setRotation(rotation);
            }
        }
    }

    public boolean isBelt(Player player) {
        TiledMapTileLayer belt = (TiledMapTileLayer) tiledmap.getLayers().get(layer);
        TiledMapTileLayer.Cell currentTile = belt.getCell((int) player.getPosX(), (int) player.getPosY());

        int tileID = -1;
        if(currentTile != null) {tileID = currentTile.getTile().getId();}

        for(int id : ID) {
            if(tileID == id) return true;
        }
        return false;
    }
}
