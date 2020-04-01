package inf112.skeleton.app.cards;

/**
 * Collecting cards
 * @author Fredrik Larsen, Vegard Birkenes
 */
public class Card {

    private int distance;
    private int priority;
    private int changeDirection;

    /**
     * @param distance the distance to move
     * @param priority the priority of a card, i.e specifying what card to be executed first
     * @param changeDirection a int between 1 and 3 depending on what direction to rotate
     */
    public Card(int distance, int priority, int changeDirection) {
        this.distance = distance;
        this.priority = priority;
        this.changeDirection = changeDirection;
    }

    /**
     * @return returns distance to move
     */
    public int getDistance(){
        return distance;
    }

    /**
     * @return returns the priority of a card
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @return returns an int specifying what direction to rotate
     */
    public int getChangeDirection(){
        return changeDirection;
    }

}
