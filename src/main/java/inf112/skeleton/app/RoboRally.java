package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import inf112.skeleton.app.Movement.MovementHandler;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.Player.PlayerCardPair;
import inf112.skeleton.app.cards.Card;
import inf112.skeleton.app.screen.GameScreen;
import inf112.skeleton.app.screen.MenuScreen;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author vegardbirkenes, Oskar Marthinussen
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
        for (int x = 0; x < amountOfPlayers; x++){
            String path = "assets/playerTexture/robot" + x + ".png";
            playerList[x] = new Player(0, x, path);
            playerList[x].renderPlayerTexture();
        }
    }

    public void createMovementHandlers(){
        movementHandlerList = new MovementHandler[playerList.length];
        for (int i = 0; i < playerList.length; i++){
            movementHandlerList[i] = new MovementHandler(playerList[i],gameScreen.getilTiledMap());
        }
    }

    //return GameScreen, used in MenuScreen
    public GameScreen getGameScreen() {
        return gameScreen;
    }

    //Return playerList, Used in GameScreen to render players
    public Player[] getPlayerList() {
        return playerList;
    }

    //Return movementHandlerList, Used in GameScreen to render players
    public MovementHandler[] getMovementHandlerList() {
        return movementHandlerList;
    }


    /**
     * Helper-method for gameTurn(). GameTurn call this method every time it execute a card.
     * @param pair A pair containing the card to be executed and the players MovementHandler.
     */
    public void executeCard(PlayerCardPair pair){
        int distance = pair.getCard().getDistance();
        int rotation = pair.getCard().getChangeDirection();

        //Execute distance card.
        if (distance != 0){
            while (distance > 0){
                //pair.getMovementHandler().movePlayer();
                distance--;
            }
        }
        //execute rotate left
        //else if (rotation < 0){ pair.getMovementHandler().rotatePlayerLeft(); }
        //execute rotate right
        //else if (rotation > 0){ pair.getMovementHandler().rotatePlayerRight( ); }
    }

    /**
     * Collects every players sequence and execute each card in execution order, based on the card priority.
     */
    public void gameTurn(){
        int roundThisTurn = 1;

        //Will be removed when branch is merged into master
        laySequence1(playerList[0]);
        laySequence1(playerList[1]);
        laySequence1(playerList[2]);
        laySequence1(playerList[3]);

        //Reset the list "lastTurnSequence" and prepare it for a a new one.
        for (Player player : playerList){ player.resetLastTurnSequence(); }
        while (roundThisTurn <= 5) {
            ArrayList<PlayerCardPair> currentRound = new ArrayList<>();

            //Gather the first card from each player's sequence and put it in a sorted ArrayList.
            //The ArrayList is sorted after execution order.
            for (int x = 0; x<playerList.length; x++){
                playerList[x].getLastTurnSequence().add(playerList[x].getSequence().peek());
                PlayerCardPair pair = new PlayerCardPair(movementHandlerList[x], playerList[x].getSequence().pollFirst());
                if (pair.getCard() != null) {
                    if (currentRound.size() == 0) { currentRound.add(0, pair); }
                    else {
                        int arraySizeBeforeInsertion = currentRound.size();
                        for (int i = 0; i < arraySizeBeforeInsertion; i++) {
                            if (pair.getCard().getPriority() >= currentRound.get(i).getCard().getPriority()) {
                                currentRound.add(i, pair);
                                break;
                            }
                        }
                        if (arraySizeBeforeInsertion == currentRound.size()){ currentRound.add(pair); }
                    }
                }
            }
            //Execute each card
            for (PlayerCardPair currentPair : currentRound) { executeCard(currentPair); }
            roundThisTurn++;
        }
        //reset sequence and lock cards based on damage taken.
        for (Player player : playerList){ player.resetSequences(); }
    }

    // Method for testing functionality. It is here temporarily until its possible for player lock his own sequence.
    public void laySequence1(Player player) {
        LinkedList<Card> sequence = new LinkedList<>();
        sequence.add(new Card(1, 100,0));
        player.setSequence(sequence);
    }
}
