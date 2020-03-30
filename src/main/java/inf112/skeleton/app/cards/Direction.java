package inf112.skeleton.app.cards;

import javax.swing.*;
import java.util.WeakHashMap;

/**
 * Possible directions
 * @author Vegard Birkenes, Fredrik Larsen
 */

public enum Direction {
    NORTH, EAST, SOUTH, WEST, DEFAULT;

    /**
     * @param dir is the direction player is facing,
     * @return the the next direction player should be facing.
     */

    //Getting rotate right direction of player
    public static Direction rotateRight(Direction dir) { return getDir(dir, WEST, EAST); }
    //Getting rotate left direction of player
    public static Direction rotateLeft(Direction dir) { return getDir(dir, EAST, WEST); }
    //Rotation function
    public static Direction getDir(Direction dir, Direction east, Direction west) {
        if (dir.equals(west)){
            return NORTH;
        } else if(dir.equals(NORTH)) {
            return east;
        } else if (dir.equals(east)) {
            return SOUTH;
        } else if (dir.equals(SOUTH)) {
            return west;
        } else {
            throw new IllegalStateException();
        }
    }
    //Getting reversed direction of player
    static public Direction uTurn(Direction dir) {
        switch (dir) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            default:
                return DEFAULT;
        }
    }
}
