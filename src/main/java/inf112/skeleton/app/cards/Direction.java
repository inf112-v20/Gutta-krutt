package inf112.skeleton.app.cards;

/**
 * Possible directions
 * @author Vegard Birkenes, Fredrik Larsen, Sedric Kvarnes
 */

public enum Direction {
    NORTH, EAST, SOUTH, WEST, DEFAULT;

    /**
     * @param dir is the direction player is facing,
     * @return the the next direction player should be facing.
     */


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
