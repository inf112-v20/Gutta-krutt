package inf112.skeleton.app.cards;

import javax.swing.*;
import java.util.WeakHashMap;

/**
 * Possible directions
 * @author Vegard Birkenes
 */

public enum Direction {
    NORTH, EAST, SOUTH, WEST, DEFAULT;

    static public Direction invert(Direction dir) {
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

    static public Direction rotateRight(Direction turnRight) {
        switch (turnRight) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
            default:
                return DEFAULT;
        }
    }
}
