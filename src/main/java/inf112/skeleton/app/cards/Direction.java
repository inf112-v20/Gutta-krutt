package inf112.skeleton.app.cards;

/**
 * Possible directions
 * @author Vegard Birkenes, Fredrik Larsen, Sedric Kvarnes
 */

public enum Direction {
    NORTH, EAST, SOUTH, WEST, DEFAULT;
    
    //Getting reversed direction of player
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
}
