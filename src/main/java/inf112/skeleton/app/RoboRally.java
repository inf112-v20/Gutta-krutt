package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import inf112.skeleton.app.cards.Card;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.movement.MovementHandler;
import inf112.skeleton.app.player.Player;
import inf112.skeleton.app.screen.GameScreen;
import inf112.skeleton.app.screen.LoseScreen;
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
        gameScreen = new GameScreen(this, "Easy");
        menuScreen = new MenuScreen(this);
        setScreen(menuScreen);
    }

    @Override
    public void render() {
        super.render();
    }

    /**
     * @return GameScreen, used in MenuScreen
     */
    public GameScreen getGameScreen() {
        return gameScreen;
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

    public void setGameScreen(String difficulty) { gameScreen = new GameScreen(this, difficulty); }

    /**
     * Executes cards that have been locked in by going through each card and doing the appropriate action using executeCard.
     * @param cards locked in cards to execute
     */
    public void executeCards(ArrayList<Card> cards, int[] playerID){
        for (int x = 0; x < cards.size(); x++) {
            // Get player and his MovementHandler
            MovementHandler movementHandler = gameScreen.getMovementHandler();
            Player player = gameScreen.getPlayers().get(playerID[x]);

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
                }
                //Executes the backup card
            } else if (distance == -1) {
                movementHandler.movePlayer((player.getDirection() + 2) % 4, player);
            }
            if (player.checkWinCondition()) {
                System.out.println("YOU WIN!!!");
            }
        }
    }

    public void gameRound() {
        int roundThisTurn = 0;
        int playerListLength = gameScreen.getPlayers().size();
        int[] playerID = new int[gameScreen.getPlayers().size()];
        while (roundThisTurn < 5) {
            ArrayList<Card> currentRound = new ArrayList<>();

            // Set sequence for CPU
            for (int j = 1; j < gameScreen.getPlayers().size(); j++){
                cpu1(gameScreen.getPlayers().get(j)); }

            // Collect card from players
            for (int x = 0; x<playerListLength; x++){
                currentRound.add(gameScreen.getPlayers().get(x).getSequence().get(roundThisTurn));
                playerID[x] = x;
            }

            // Sort array after priority
            for (int i = 0; i < playerListLength - 1; i++) {
                int max_prio = i;
                for (int j = i+1; j < playerListLength; j++)
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

     * Executes one card. Checks what kind of card it is and does the correct action for such a card.
     * @param card card to be executed
     * @param player the player wanting to execute the card
     */
    public void executeCard(Card card, Player player) {
        MovementHandler movementHandler = gameScreen.getMovementHandler();
        int distance = card.getDistance();
        int rotation = card.getChangeDirection();
        if (rotation > 0) {
            player.setRotation((player.getDirection() + rotation) % 4);
            player.setDirection((player.getDirection() + rotation) % 4);
        }
        else if (distance > 0) {
            for (int i = 0; i < distance; i++) {
                movementHandler.movePlayer(player.getDirection(), player);
            }
        } else if (distance == -1) {
            movementHandler.movePlayer((player.getDirection() + 2) % 4, player);
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

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


    @Override
    public void dispose() {
        super.dispose();
    }
}
