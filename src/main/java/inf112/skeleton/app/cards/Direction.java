package inf112.skeleton.app.cards;

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
}
