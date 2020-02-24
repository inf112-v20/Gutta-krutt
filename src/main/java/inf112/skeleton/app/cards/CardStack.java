package inf112.skeleton.app.cards;

import java.util.Random;
import java.util.HashMap;

public class CardStack {

    private final String[] typeOfCards = { "backUp", "move1", "move2", "move3", "uTurn", "rotateLeft", "rotateRight" };
    private HashMap<String, int[]> cardStack;
    private final int[] distanceToMove = { -1, 1, 2, 3};

    public void randomCard() {
        //Trenger en random priority og distance/direction
        Random random = new Random();
        int type = random.nextInt(7);
        if (type < 3) { moveCard(type, distanceToMove[type]); }
        else { rotateCard(typeOfCards[type]); }
    }

    public void moveCard(Integer type, int distance) {

    }

    public void rotateCard(String type) {
    }

    // There is 6 u turn cards with priority between: 10 - 60
    public void uTurnCard() {
        int[] priorityList = new int[5];
        int index = 0;
        for (int pri = 10; pri < 61; pri += 10) {
            priorityList[index] = pri;
            index++;
        }
        cardStack.put("uTurn", priorityList);
    }

    // There is 18 rotate left cards  with priority between: 70 - 410
    public void rotateLeft() {
        int[] priorityList = new int[17];
        int index = 0;
        for (int pri = 70; pri < 411; pri += 20) {
            priorityList[index] = pri;
            index++;
        }
        cardStack.put("rotateLeft", priorityList);
    }

    // There is 18 rotate right cards with priority between: 80 - 420
    public void rotateRight() {
        int[] priorityList = new int[17];
        int index = 0;
        for (int pri = 80; pri < 421; pri += 20) {
            priorityList[index] = pri;
            index++;
        }
        cardStack.put("rotateRight", priorityList);
    }

    // There is 6 back up cards with priority between: 430 - 480
    public void backUpCard() {
        int[] priorityList = new int[5];
        int index = 0;
        for (int pri = 430; pri < 481; pri += 10) {
            priorityList[index] = pri;
            index++;
        }
        cardStack.put("backUp", priorityList);
    }

    // There is 18 move one (spaces) cards with priority between: 490 - 660
    public  void moveOne() {
        int[] priorityList = new int[17];
        int index = 0;
        for (int pri = 490; pri < 661; pri += 20) {
            priorityList[index] = pri;
            index++;
        }
        cardStack.put("move1", priorityList);
    }

    // There is 12 move two (spaces) cards with priority between: 670 - 780
    public void moveTwo() {
        int[] priorityList = new int[11];
        int index = 0;
        for (int pri = 670; pri < 781; pri += 10) {
            priorityList[index] = pri;
            index++;
        }
        cardStack.put("move2", priorityList);
    }

    // There is 6 move three (spaces) cards with priority between: 790 - 840
    public void moveThree() {
        int[] priorityList = new int[5];
        int index = 0;
        for (int pri = 790; pri < 841; pri += 10) {
            priorityList[index] = pri;
            index++;
        }
        cardStack.put("move3", priorityList);
    }
}
