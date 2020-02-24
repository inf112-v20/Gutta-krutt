package inf112.skeleton.app.cards;

import java.util.Random;
import java.util.HashMap;

public class CardStack {

    private final String[] typeOfCards = { "backUp", "move1", "move2", "move3", "uTurn", "rotateLeft", "rotateRight" };
    private final int[] distanceOnCard = { -1, 1, 2, 3};

    public void randomCard() {
        //Trenger en fakkings random priority og distance/direction
        Random random = new Random();
        int type = random.nextInt(7);
        if (type < 3) { moveCard(typeOfCards[type], distanceOnCard[type]); }
        else { rotateCard(typeOfCards[type]); }

    }

    public void moveCard(String type, int distance) {

    }

    public void rotateCard(String type) {
    }

    public void randomPriority(String type, int increment) {

    }

    // There is 18 rotate right cards with priority between: 80 - 420
    public HashMap<Integer, Integer> rotateRight() {
        HashMap<Integer, Integer>rotateRightCards = new HashMap<>();
        for (int i = 80; i < 421; i += 20) {
            rotateRightCards.put(i, 0);
        }
        //Returns 18 "rotate right" cards with priority value
        return rotateRightCards;
    }

    // There is 18 rotate left cards  with priority between: 70 - 410
    public HashMap<Integer, Integer> rotateLeft() {
        HashMap<Integer, Integer> rotateLeftCards = new HashMap<>();
        for (int i = 70; i < 411; i += 20) {
            rotateLeftCards.put(i, 0);
        }
        //Returns 18 "rotate left" cards with priority value
        return rotateLeftCards;
    }

    // There is 18 move one (spaces) cards with priority between: 490 - 661
    public HashMap<Integer, Integer> moveOne(int distance, int priority) {
        HashMap<Integer, Integer>moveOneCards = new HashMap<>();
        for (int i = 490; i < 661; i += 10) {
            moveOneCards.put(i, 1);
        }
        //Returns 18 "move one" cards with priority value
        return moveOneCards;
    }

    // There is 12 move two (spaces) cards with priority between: 670 - 780
    public HashMap<Integer, Integer> moveTwo() {
        HashMap<Integer, Integer> moveTwoCards = new HashMap<>();
        for (int i = 670; i < 781; i += 10) {
            moveTwoCards.put(i, 2);
        }
        //Returns 12 "move two" cards with priority value
        return moveTwoCards;
    }

    // There is 6 move three (spaces) cards with priority between: 790 - 840
    public HashMap<Integer, Integer> moveThree() {
        HashMap<Integer, Integer> moveThreeCards = new HashMap<>();
        for (int i = 790; i < 841; i += 10) {
            moveThreeCards.put(i, 3);
        }
        //Returns 6 "move three" cards with priority value
        return moveThreeCards;
    }

    // There is 6 u turn cards with priority between: 10 - 60
    public HashMap<Integer, Integer> uTurnCard() {
        HashMap<Integer, Integer>uTurnCards = new HashMap<>();
        for (int i = 10; i < 61; i += 10) {
            uTurnCards.put(i, 0);
        }
        //Returns 6 "u-turn" cards with priority value
        return uTurnCards;
    }

    // There is 6 back up cards with priority between: 430 - 480
    public HashMap<Integer, Integer> backUpCard() {
        HashMap<Integer, Integer> backUpCards = new HashMap<>();
        for (int i = 430; i < 481; i += 10) {
            backUpCards.put(i, -1);
        }
        //Returns 6 "back-up" cards with priority value
        return backUpCards;
    }

}
