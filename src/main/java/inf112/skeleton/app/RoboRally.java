package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import inf112.skeleton.app.cards.Card;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.movement.MovementHandler;
import inf112.skeleton.app.player.Player;
import inf112.skeleton.app.screen.GameScreen;
import inf112.skeleton.app.screen.MenuScreen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * @author Vegard Birkenes, Oskar Marthinussen, Fredrik Larsen
 */
//This is libgdx own Game class, this makes it possible to switch between screens.
public class RoboRally extends Game {

    private GameScreen gameScreen;
    private MenuScreen menuScreen;


    @Override
    public void create() {
        gameScreen = new GameScreen(this);
        menuScreen = new MenuScreen(this);
        setScreen(menuScreen);
    }

    @Override
    public void render() {
        super.render();
    }

    /**
     * Initialize all the players at the start of the game.
     * @param amountOfPlayers amount of players playing.
     */
    public void createPlayers(int amountOfPlayers){
        playerList = new Player[amountOfPlayers];
        movementHandlerList = new MovementHandler[amountOfPlayers];
        Random ran = new Random();
        ArrayList<int[]> startPos = new ArrayList<>();

        // Add all starting positions in one array.
        int[][] coordinates = {{0,0}, {0, 11}, {11,0}, {11, 11}, {1,0}, {2,0}, {0,1}, {0, 2},
                                {1,11}, {2, 11}, {0,10}, {0,9}, {11,10}, {11,9}, {10,11}, {9,11}};
        for (int[] pos : coordinates){
            startPos.add(pos);
        }
        // Add players to playerList
        for (int y = 0; y < amountOfPlayers; y++){
            int[] playerStartPos = startPos.remove(ran.nextInt(startPos.size()));
            String path = "assets/playerTexture/robot" + y + ".png";
            playerList[y] = new Player(playerStartPos[0], playerStartPos[1], path);
            playerList[y].renderPlayerTexture();
        }
    }

    public void createMovementHandlers(){
        movementHandlerList = new MovementHandler[playerList.length];
        for (int i = 0; i < playerList.length; i++){
            movementHandlerList[i] = new MovementHandler(playerList[i],gameScreen.getTiledMap());
        }
    }

    /**
     * @return GameScreen, used in MenuScreen
     */
    public GameScreen getGameScreen() {
        return gameScreen;
    }


    /**
     * Executes cards that have been locked in by going through each card and doing the appropriate action
     * @param cards locked in cards to execute
     */
    public void executeCards(ArrayList<Card> cards) {
        MovementHandler movementHandler = gameScreen.getMovementHandler();
        Player player = gameScreen.getPlayer();
        for (Card card : cards) {
    public MovementHandler[] getMovementHandlerList() {
        return movementHandlerList;
    }

    int num_ex = 0;

    int execution = 0;
    /**
     *
     * @param cards Takes inn the cards placed by the players in register screen and executes them in the right order.
     * @throws InterruptedException when thread is sleeping
     */
    public void executeCards(ArrayList<Card> cards, int[] playerID) throws InterruptedException {
        execution++;
        System.out.println(execution);
        for (int x = 0; x < cards.size(); x++) {
            // Get player and his MovementHandler
            MovementHandler movementHandler = movementHandlerList[playerID[x]];
            Player player = playerList[playerID[x]];

            //Get card and its values.
            Card card = cards.get(x);
            int distance = card.getDistance();
            int rotation = card.getChangeDirection();

            //Executes the rotation cards
            if (rotation > 0) {
                player.setRotation((player.getDirection() + rotation) % 4);
                player.setDirection((player.getDirection() + rotation) % 4);
            }
            else if (distance > 0) {
                for (int i = 0; i < distance; i++) {
                    movementHandler.movePlayer(player.getDirection(), player);
                    movementHandler.movePlayer(player.getDirection());
                }
            } else if (distance == -1) {
                movementHandler.movePlayer((player.getDirection() + 2) % 4, player);
              //Executes the backup card
            } else if(distance == -1) {
                movementHandler.movePlayer((player.getDirection() + 2) % 4);
            }
        }
        if (player.checkWinCondition()) {
            System.out.println("YOU WIN!!!");
        }
    }
    }
    public void gameRound() throws InterruptedException {
        int roundThisTurn = 0;
        int[] playerID = new int[playerList.length];
        while (roundThisTurn < 5) {
            ArrayList<Card> currentRound = new ArrayList<>();

            // Set sequence for CPU
            for (int j = 0; j < playerList.length; j++){ cpu1(playerList[j]); }

            // Collect the first card from all the players
            for (int x = 0; x<playerList.length; x++){
                currentRound.add(playerList[x].getSequence().get(roundThisTurn));
                playerID[x] = x;
            }

    /**
     * Uses Java comparable to sort the cards
     * @param cards cards to sort
     * @return ArrayList of cards sorted from highest to lowest priority
     */
    public ArrayList<Card> sortCards(ArrayList<Card> cards) {
        Collections.sort(cards);
        Collections.reverse(cards);
        return cards;
    }
            // Sort array after priority
            for (int i = 0; i < playerList.length - 1; i++) {
                int max_prio = i;
                for (int j = i+1; j < playerList.length; j++)
                    if (currentRound.get(j).getPriority() > currentRound.get(max_prio).getPriority())
                        max_prio = j;

                int temp = playerID[max_prio];
                playerID[max_prio] = playerID[i];
                playerID[i] = temp;

                Card temp2 = currentRound.get(max_prio);
                currentRound.set(max_prio, currentRound.get(i));
                currentRound.set(i, temp2);
            }

            // Execute cards for current round
            executeCards(currentRound, playerID);
            roundThisTurn++;
        }
    }

    /**
     * Pick 5 random cards for a CPU-player
     * @param player The selected playerg
     */
    public void cpu1(Player player){
        Deck deck = new Deck();
        ArrayList<Card> seq = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Card card = deck.randomCard();
            seq.add(card);
        }
        player.setSequence(seq);
    }
}