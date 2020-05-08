package inf112.skeleton.app.tiles;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.player.Player;
import inf112.skeleton.app.cards.Direction;

/**
 * class to implement all types of belts
 * takes a map that is to be used, a direction to which the player should be moved
 * a int for rotation if it is a rotate tile, -1 if no rotation
 * int steps to specify how many steps are to be takes when interacting with the belt tile
 * a string layer to specify what layer the belt is located in
 * @author Sedric Kvarnes, Fredrik Larsen
 */
public class Belt implements ActionTiles {

    private final TiledMap tiledmap;
    private final Direction dir;
    private final int rotation;
    private final int[] ID;
    private final int steps;
    private final String layer;

    public Belt(TiledMap tiledmap, Direction dir, int rotation, int[] ID, int steps, String layer) {
        this.tiledmap = tiledmap;
        this.dir = dir;
        this.rotation = rotation;
        this.ID = ID;
        this.steps = steps;
        this.layer = layer;
    }

    /**
     * takes the specified direction and moves the player "steps" times in that direction
     * @param player, the player the action is to be executed on
     */
    @Override
    public boolean tileAction(Player player) {

        if(isBelt(player)) {
            if(dir == Direction.NORTH) {
                player.addPosY(steps);
            } else if (dir == Direction.SOUTH){
                player.addPosY(-steps);
            } else if (dir == Direction.EAST) {
                player.addPosX(steps);
            } else if (dir == Direction.WEST) {
                player.addPosX(-steps);
            }
            if(rotation != -1) {
                player.setRotation((player.getDirection()+rotation) % 4);
                player.setDirection((player.getDirection()+rotation) % 4);
            }
            return true;
        }
        return false;
    }

    /**
     * checks if the current tile the player is standing on is a belt-tile
     * @param player the player to be checked
     * @return returns true if the player is on the specified belt tile and false otherwise
     */
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
