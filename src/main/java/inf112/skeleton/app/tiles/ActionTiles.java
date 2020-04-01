package inf112.skeleton.app.tiles;

import inf112.skeleton.app.Player.Player;

/**
 * interface to implement behavior for all the tiles that has an action to it
 * @author sedric, fredrik
 */
public interface ActionTiles {

    /**
     * used to call the action which is to be executed when standing on an ActionTile
     * @param player, the player the action is to be executed on
     */
    boolean tileAction(Player player);
}
