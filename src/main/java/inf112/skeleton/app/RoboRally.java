package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import inf112.skeleton.app.cards.Card;
import inf112.skeleton.app.movement.MovementHandler;
import inf112.skeleton.app.player.Player;
import inf112.skeleton.app.screen.GameScreen;
import inf112.skeleton.app.screen.MenuScreen;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Vegard Birkenes, Oskar Marthinussen, Fredrik Larsen
 */
//This is libgdx own Game class, this makes it possible to switch between screens.
public class RoboRally extends Game {

    private GameScreen gameScreen;
    private Player[] playerList;
    private MovementHandler[] movementHandlerList;
    private int amountOfPlayers = 4;
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
        MovementHandler movementHandler = movementHandlerList[0];
        for (Card card : cards) {
            int distance = card.getDistance();
            int rotation = card.getChangeDirection();
            if (rotation > 0) {
                playerList[0].setRotation((playerList[0].getDirection() + rotation) % 4);
                playerList[0].setDirection((playerList[0].getDirection() + rotation) % 4);
            }
            else if (distance > 0) {
                for (int i = 0; i < distance; i++) {
                    movementHandler.movePlayer(playerList[0].getDirection());
                }
            } else if (distance == -1) {
                movementHandler.movePlayer((playerList[0].getDirection() + 2) % 4);
            }
        }
        if (playerList[0].checkWinCondition()) {
            System.out.println("YOU WIN!!!");
        }
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
}