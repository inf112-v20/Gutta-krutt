package inf112.skeleton.app.cards;

//Want to use directions to navigate the players on the board. Might need default
public enum Direction {
    NORTH (1),
    EAST (2),
    SOUTH (3),
    WEST (4);

    private final int dir;

    Direction(int dir) {
        this.dir = dir;
    }

    public int getDirection(){
        return this.dir;
    }
}
