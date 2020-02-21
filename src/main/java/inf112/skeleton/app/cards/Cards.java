package inf112.skeleton.app.cards;

public class Cards {

    private int distance;
    private int priority;
    private Direction direction;

    public void Cards(int distance, int priority, Direction direction) {
        this.distance = distance;
        this.priority = priority;
        this.direction = direction;

    }

    public int getDistance(){
        return distance;
    }

    public int getPriority() {
        return priority;
    }

    public Direction direction(){
        return direction;
    }

}
