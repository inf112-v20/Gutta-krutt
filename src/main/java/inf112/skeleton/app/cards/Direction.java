package inf112.skeleton.app.cards;

//Want to use directions to navigate the players on the board. Might need default
public enum Direction {
    NORTH (1, "North"),
    EAST (2,"East"),
    SOUTH (3,"South"),
    WEST (4,"West");

    private int dirID;
    private String direction;
    private int uTurnDir;


    Direction(int dir, String direction) {
        this.dirID = dirID;
        this.direction = direction;
    }

    public int getRotateRightDirection() {

    }

    public int getRotateLeftDirection() {

    }

    public int getUturnDirection() {
        if(this.dirID == 1) {
            uTurnDir = 3;
        } else if (this.dirID == 2){
            uTurnDir = 4;
        } else if (this.dirID == 3) {
            uTurnDir = 1;
        } else if (this.dirID == 4){
            uTurnDir = 2;
        }

    }

    public int getDirection(){
        return this.dirID;
    }
}
