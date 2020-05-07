package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import inf112.skeleton.app.movement.MovementHandler;
import inf112.skeleton.app.player.Player;
import inf112.skeleton.app.cards.Card;
import inf112.skeleton.app.screen.GameScreen;
import inf112.skeleton.app.screen.MenuScreen;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Vegard Birkenes, Oskar Marthinussen, Fredrik Larsen
 */
//This is libgdx own Game class, this makes it possible to switch between screens.
public class RoboRally extends Game {

    private GameScreen gameScreen;
    private Player[] playerList;
    private MovementHandler[] movementHandlerList;
    private int amountOfPlayers = 4;


    @Override
    public void create() {
        createPlayers(amountOfPlayers);
        gameScreen = new GameScreen(this);
        createMovementHandlers();
        setScreen(new MenuScreen(this));
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
        for (int y = 0; y < amountOfPlayers; y++){
            String path = "assets/playerTexture/robot" + y + ".png";
            playerList[y] = new Player(0, y, path);
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
     * @return Return playerList, Used in GameScreen to render players
     */
    public Player[] getPlayerList() {
        return playerList;
    }

    /**
     * @return Return movementHandlerList, Used in GameScreen to render players
     */
    public MovementHandler[] getMovementHandlerList() {
        return movementHandlerList;
    }

    // Method for testing functionality. It is here temporarily until its possible for player lock his own sequence.
    public void laySequence1(Player player) {
        LinkedList<Card> sequence = new LinkedList<>();
        sequence.add(new Card(1, 100,0, "assets/SequenceCards/Move_1.png"));
        player.setSequence(sequence);
    }

    /**
     *
     * @param cards Takes inn the cards placed by the players in register screen and executes them in the right order.
     */
    public void executeCards(ArrayList<Card> cards) {
        MovementHandler movementHandler = movementHandlerList[0];
        for (Card card : cards) {
            int distance = card.getDistance();
            int rotation = card.getChangeDirection();
            //Executes the rotation cards
            if (rotation > 0) {
                playerList[0].setRotation((playerList[0].getDirection() + rotation) % 4);
                playerList[0].setDirection((playerList[0].getDirection() + rotation) % 4);
            }
            //Executes move1 move2 and move3 cards
            if (distance > 0) {
                for (int i = 0; i < distance; i++) {
                    movementHandler.movePlayer(playerList[0].getDirection());
                }
              //Executes the backup card
            } else if(distance == -1) {
                movementHandler.movePlayer((playerList[0].getDirection() + 2) % 4);
            }
        }
    }
}