package inf112.skeleton.app.cards;

import java.util.Random;
import java.util.HashMap;

public class Deck {

    private final String[] typeOfCards = { "backUp", "move1", "move2", "move3", "uTurn", "rotateLeft", "rotateRight" };
    private HashMap<String, int[]> deck;
    private final int[] distanceToMove = { -1, 1, 2, 3};
    private final int[] directionRotation = { 2, -1 , 1 };

    public Deck() {
        this.deck = initializeDeck();
    }

    //Takes two random numbers to chose a type of card and a random priority corresponding to this card.
    //Proceeds to get the corresponding distance and direction change to make a new card.
    public Card randomCard() {
        Random random = new Random();
        int type = random.nextInt(7);
        int randomPriority = random.nextInt(7);

        String typeOfCard = typeOfCards[type];
        int[] priorityList = deck.get(typeOfCard);

        int priority = priorityList[randomPriority];
        int distance = getCorrespondingDistance(type);
        int directionChange = getCorrespondingDirection(type);

        return new Card(distance, priority, directionChange);
    }

    //Uses typeOfCards and distanceToMove to find the distance corresponding to the type of card.
    public int getCorrespondingDistance(int type) {
        int distance;
        if (type > 3) {
            distance = 0;
        } else {
            distance = distanceToMove[type];
        }
        return distance;
    }

    //Uses typeOfCards and directionRotation to find how much the card needs to rotate
    //currently the idea is to use a direction array.
    public int getCorrespondingDirection(int type) {
        int changeDirection;
        if (type < 4) {
            changeDirection = 0;
        }
        else {
            changeDirection = directionRotation[type];
        }
        return changeDirection;
    }

    public HashMap<String, int[]> initializeDeck() {
        HashMap<String, int[]> deck= new HashMap<>();
        uTurnCard(deck);
        rotateLeft(deck);
        rotateRight(deck);
        backUpCard(deck);
        moveOne(deck);
        moveTwo(deck);
        moveThree(deck);
        return deck;
    }

    // There is 6 u turn cards with priority between: 10 - 60
    public HashMap<String, int[]> uTurnCard(HashMap<String, int[]> deck) {
        int[] priorityList = new int[5];
        int index = 0;
        for (int pri = 10; pri < 61; pri += 10) {
            priorityList[index] = pri;
            index++;
        }
        deck.put("uTurn", priorityList);
        return deck;
    }

    // There is 18 rotate left cards  with priority between: 70 - 410
    public HashMap<String, int[]> rotateLeft(HashMap<String, int[]> deck) {
        int[] priorityList = new int[17];
        int index = 0;
        for (int pri = 70; pri < 411; pri += 20) {
            priorityList[index] = pri;
            index++;
        }
        deck.put("rotateLeft", priorityList);
        return deck;
    }

    // There is 18 rotate right cards with priority between: 80 - 420
    public HashMap<String, int[]> rotateRight(HashMap<String, int[]> deck) {
        int[] priorityList = new int[17];
        int index = 0;
        for (int pri = 80; pri < 421; pri += 20) {
            priorityList[index] = pri;
            index++;
        }
        deck.put("rotateRight", priorityList);
        return deck;
    }

    // There is 6 back up cards with priority between: 430 - 480
    public HashMap<String, int[]> backUpCard(HashMap<String, int[]> deck) {
        int[] priorityList = new int[5];
        int index = 0;
        for (int pri = 430; pri < 481; pri += 10) {
            priorityList[index] = pri;
            index++;
        }
        deck.put("backUp", priorityList);
        return deck;
    }

    // There is 18 move one (spaces) cards with priority between: 490 - 660
    public  HashMap<String, int[]> moveOne(HashMap<String, int[]> deck) {
        int[] priorityList = new int[17];
        int index = 0;
        for (int pri = 490; pri < 661; pri += 10) {
            priorityList[index] = pri;
            index++;
        }
        deck.put("move1", priorityList);
        return deck;
    }

    // There is 12 move two (spaces) cards with priority between: 670 - 780
    public HashMap<String, int[]> moveTwo(HashMap<String, int[]> deck) {
        int[] priorityList = new int[11];
        int index = 0;
        for (int pri = 670; pri < 781; pri += 10) {
            priorityList[index] = pri;
            index++;
        }
        deck.put("move2", priorityList);
        return deck;
    }

    // There is 6 move three (spaces) cards with priority between: 790 - 840
    public HashMap<String, int[]> moveThree(HashMap<String, int[]> deck) {
        int[] priorityList = new int[5];
        int index = 0;
        for (int pri = 790; pri < 841; pri += 10) {
            priorityList[index] = pri;
            index++;
        }
        deck.put("move3", priorityList);
        return deck;
    }
}
