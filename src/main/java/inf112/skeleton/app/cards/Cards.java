package inf112.skeleton.app.cards;

public class Cards {

    private int distance;
    private int priority;
    private Direction direction;

    // "One" card
    public void Cards(int distance, int priority, Direction direction) {
        this.distance = distance;
        this.priority = priority;
        this.direction = direction;
    }

    // Returns distance to move
    public int getDistance(){
        return distance;
    }

    // Card priority (who gets to move first)
    public int getPriority() {
        return priority;
    }

    // What direction to move
    public Direction direction(){
        return direction;
    }

}
