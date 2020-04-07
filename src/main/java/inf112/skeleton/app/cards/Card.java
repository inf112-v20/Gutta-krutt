package inf112.skeleton.app.cards;

/**
 * Collecting cards
 * @author Fredrik Larsen, Vegard Birkenes
 */
public class Card {

    private int distance;
    private int priority;
    private int changeDirection;
    private String filepath;

    /**
     * @param distance the distance to move
     * @param priority the priority of a card, i.e specifying what card to be executed first
     * @param changeDirection a int between 1 and 3 depending on what direction to rotate
     * @param filepath filepath to image of card
     */
    public Card(int distance, int priority, int changeDirection, String filepath) {
        this.distance = distance;
        this.priority = priority;
        this.changeDirection = changeDirection;
        this.filepath = filepath;
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

    /**
     * @return filepath of a card
     */
    public String getFilepath() { return filepath; }

}
