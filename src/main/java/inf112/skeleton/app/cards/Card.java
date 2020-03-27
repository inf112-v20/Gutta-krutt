package inf112.skeleton.app.cards;

/**
 * Collecting cards
 * @author Fredrik Larsen, Vegard Birkenes
 */
public class Card {

    //Variables
    private int distance;
    private int priority;

    //The intention is to have an array containing the directions so that we can plus the changeDirection and mod with 4 to get the
    //direction the player wants to turn.
    private int changeDirection;

    // "One" card
    public Card(int distance, int priority, int changeDirection) {
        this.distance = distance;
        this.priority = priority;
        this.changeDirection = changeDirection;
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
    public int getChangeDirection(){
        return changeDirection;
    }

}
