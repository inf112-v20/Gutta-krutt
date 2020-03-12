package inf112.skeleton.app;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.skeleton.app.Movement.MovementHandler;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.Player.PlayerCardPair;
import inf112.skeleton.app.cards.Card;
import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.screen.GameScreen;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;


public class Game extends InputAdapter implements ApplicationListener  {
    private GameScreen gameScreen;
    private TiledMap tilemap;

    private Player[] playerList;
    private int amountOfPlayers = 3;
    private Deck deck;
    private MovementHandler movementHandler;


    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        //initialize a new tilemap
        TmxMapLoader tmxLoader = new TmxMapLoader();
        tilemap = tmxLoader.load("assets/Maps/map1.tmx");
        //initialize all players
        createPlayers(amountOfPlayers);
        //initialize deck
        deck = new Deck();


        gameScreen = new GameScreen(tilemap);
        movementHandler = new MovementHandler(tilemap);
        Gdx.input.setInputProcessor(this);
    }

    /**
     * This method is called when the game starts to initialize all the players.
     * @param amountOfPlayers amount of players playing.
     */
    public void createPlayers(int amountOfPlayers){
        playerList = new Player[amountOfPlayers];
        for (int x = 0; x < amountOfPlayers; x++){
            String path = "assets/playerTexture/robot" + x + ".png";
            playerList[x] = new Player(0, x, path, x);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);


        //displaying the corresponding picture depending on what tile you are standing on
        gameScreen.getRenderer().render();

        TiledMapTileLayer playerLayer = (TiledMapTileLayer) tilemap.getLayers().get("Player");

        //Render all the players
        for (int i = 0; i<amountOfPlayers; i++) {
            playerLayer.setCell((int) playerList[i].getPosX(), (int) playerList[i].getPosY(), playerList[i].getPlayerNormal());
        }
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
    public boolean keyUp(int keycode) {
        //return movementHandler.keyUp(playerList[0], keycode);
        gameTurn();
        return true;
    }

    /**
     * Helper-method for gameTurn(). GameTurn call this method every time it execute a card.
     * @param pair It is a pair containing the specific card and playerID for the player that layed this card in his sequence.
     */
    public void executeCard(PlayerCardPair pair){
        System.out.println("RobotID: " + pair.getPlayerID() + " priority: " + pair.getCard().getPriority());
        int distance = pair.getCard().getDistance();
        int rotation = pair.getCard().getChangeDirection();

        if (distance != 0){
            while (distance > 0){
                for (Player player : playerList){
                    if (player.getPlayerID() == pair.getPlayerID()){
                        movementHandler.movePlayer(player);
                        distance -= 1;
                    }
                }
            }
        }
        else if (rotation < 0){
            for (Player player : playerList){
                if (player.getPlayerID() == pair.getPlayerID()){ movementHandler.rotatePlayerLeft(player);}
            }
        }
        else if (rotation > 0){
            for (Player player : playerList){
                if (player.getPlayerID() == pair.getPlayerID()){ movementHandler.rotatePlayerRight(player);}
            }
        }
    }
    
    /**
     * Collects every players sequence and execute each card in a specific order, based on the cards priority.
     */
    public void gameTurn(){
        int roundThisTurn = 1;
        laySequence1(playerList[0]);
        laySequence2(playerList[1]);
        laySequence3(playerList[2]);

        while (roundThisTurn <= 5) {
            ArrayList<PlayerCardPair> currentRound = new ArrayList<>();
            //Gather the first card from each player's sequence and put it in a ArrayList
            //that is sorted in the order each card should be executed
            for (Player player : playerList) {
                PlayerCardPair pair = new PlayerCardPair(player.getPlayerID(), player.getSequence().pollFirst());
                if (pair.getCard() != null) {
                    if (currentRound.size() == 0) { currentRound.add(0, pair); }
                    else {
                        int arraySizeBeforeInsertion = currentRound.size();
                        for (int i = 0; i < arraySizeBeforeInsertion; i++) {
                            if (pair.getCard().getPriority() >= currentRound.get(i).getCard().getPriority()) {
                                currentRound.add(i, pair);
                            }
                        }
                        if (arraySizeBeforeInsertion == currentRound.size()){ currentRound.add(pair); }
                    }
                }
            }
            for (PlayerCardPair currentPair : currentRound) { executeCard(currentPair); }
            roundThisTurn++;
        }
    }


    /**
     * Temporary method to lay a sequence for a player.
     * @param player The player you want to lay a sequence for.
     */
    public void laySequence1(Player player) {
        LinkedList<Card> sequence = new LinkedList<>();
        sequence.add(new Card(1, 640,0));
        sequence.add(new Card(0, 930,1));
        sequence.add(new Card(1, 210,0));
        sequence.add(new Card(0, 310,-1));
        sequence.add(new Card(1, 200,0));
        player.setSequence(sequence);
    }
    /**
     * Temporary method to lay a sequence for a player.
     * @param player The player you want to lay a sequence for.
     */
    public void laySequence2(Player player) {
        LinkedList<Card> sequence = new LinkedList<>();
        sequence.add(new Card(0, 820,1));
        sequence.add(new Card(3, 650,0));
        sequence.add(new Card(0, 700,-1));
        sequence.add(new Card(0, 450,1));
        player.setSequence(sequence);
    }
    /**
     * Temporary method to lay a sequence for a player.
     * @param player The player you want to lay a sequence for.
     */
    public void laySequence3(Player player) {
        LinkedList<Card> sequence = new LinkedList<>();
        sequence.add(new Card(0, 320,1));
        player.setSequence(sequence);
    }

}