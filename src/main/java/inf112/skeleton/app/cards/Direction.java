package inf112.skeleton.app.cards;

//Want to use directions to navigate the players on the board. Might need default
public enum Direction {
    NORTH (1, "North"),
    EAST (2,"East"),
    SOUTH (3,"South"),
    WEST (4,"West");

    private int dirID;
    private String direction;

    Direction(int dir, String direction) {
        this.dirID = dirID;
        this.direction = direction;
    }

    public int getDirection(){
        return this.dirID;
    }
}
