package inf112.skeleton.app.cards;

import java.util.Random;
import java.util.HashMap;

/**
 * handling all movement connected to the board
 * @author Fredrik Larsen, Vegard Birkenes
 */

public class Deck {

    private final String[] typeOfCards = { "backUp", "move1", "move2", "move3", "uTurn", "rotateLeft", "rotateRight" };
    private HashMap<String, int[]> deck;
    private final int[] distanceToMove = { -1, 1, 2, 3, 0, 0, 0};
    //the idea behind an int array to represent direction is to later implement a direction array where the indexes from
    //represent a direction. By using formula "x + directionRotation[i] % 4" you can easily turn the player the correct way.
    private final int[] directionRotation = { 0, 0, 0, 0, 2, -1 , 1 };

    public Deck() {
        this.deck = initializeDeck();
    }

    public HashMap<String, int[]> getDeck() {
        return deck;
    }

    //Takes two random numbers to chose a type of card and a random priority corresponding to this card.
    //Proceeds to get the corresponding distance and direction change to make a new card.
    public Card randomCard() {
        Random random = new Random();
        int randomType = random.nextInt(7);
        int randomPriority = random.nextInt(7);

        String typeOfCard = typeOfCards[randomType];
        int[] priorityList = deck.get(typeOfCard);

        int priority = priorityList[randomPriority];
        int distance = getCorrespondingDistance(randomType);
        int directionChange = getCorrespondingDirection(randomType);

        return new Card(distance, priority, directionChange);
    }

    //Uses typeOfCards and distanceToMove to find the distance corresponding to the type of card.
    //The first 4 indexes of typeOfCards corresponds with the list distanceToMove
    public int getCorrespondingDistance(int type) {
        return distanceToMove[type];
    }

    //Uses typeOfCards and directionRotation to find how much the card needs to rotate
    //currently the idea is to use a direction array.
    //The last 3 indexes of typeOfCards corresponds with the amount of rotation in directionRotation.
    public int getCorrespondingDirection(int type) {
        return directionRotation[type];
    }

    //Makes a hashmap containing the name of the type of card and a list of priorities that the cards can have.
    //All functions have the same recipe. Go through a for loop with the priorities and add the name of the
    //card as well as a list of possible priorities on the card to a given hashmap.
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
        int[] priorityList = new int[6];
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
        int[] priorityList = new int[18];
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
        int[] priorityList = new int[18];
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
        int[] priorityList = new int[6];
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
        int[] priorityList = new int[18];
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
        int[] priorityList = new int[12];
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
        int[] priorityList = new int[6];
        int index = 0;
        for (int pri = 790; pri < 841; pri += 10) {
            priorityList[index] = pri;
            index++;
        }
        deck.put("move3", priorityList);
        return deck;
    }
}
