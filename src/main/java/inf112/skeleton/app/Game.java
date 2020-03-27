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



public class Game extends InputAdapter implements ApplicationListener  {
    private GameScreen gameScreen;
    private TiledMap tilemap;

    private Player[] playerList;
    private int amountOfPlayers = 1;
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
     * @param pair A pair containing the card to be executed and playerID.
     */
    public void executeCard(PlayerCardPair pair){
        int distance = pair.getCard().getDistance();
        int rotation = pair.getCard().getChangeDirection();

        //Execute distance card.
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
        //execute rotate left
        else if (rotation < 0){
            for (Player player : playerList){
                if (player.getPlayerID() == pair.getPlayerID()){ movementHandler.rotatePlayerLeft(player);}
            }
        }
        //execute rotate right
        else if (rotation > 0){
            for (Player player : playerList){
                if (player.getPlayerID() == pair.getPlayerID()){ movementHandler.rotatePlayerRight(player);}
            }
        }
    }

    /**
     * Collects every players sequence and execute each card in a specific order, based on the card priority.
     */
    public void gameTurn(){
        int roundThisTurn = 1;

        //Will be removed when branch is merged into master
        laySequence1(playerList[0]);
      // laySequence1(playerList[2]);


        //Reset the list "lastTurnSequence" and prepare it for a a new one.
        for (Player player : playerList){ player.resetLastTurnSequence(); }

        while (roundThisTurn <= 5) {
            ArrayList<PlayerCardPair> currentRound = new ArrayList<>();

            //Gather the first card from each player's sequence and put it in a sorted ArrayList.
            //The ArrayList is sorted after execution order.
            for (Player player : playerList) {
                player.getLastTurnSequence().add(player.getSequence().peek());
                PlayerCardPair pair = new PlayerCardPair(player.getPlayerID(), player.getSequence().pollFirst());
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


    // Both the methods under are here just for testing functionality, and will be deleted
    //when the branch is merged into master.
    public void laySequence1(Player player) {
        LinkedList<Card> sequence = new LinkedList<>();
        sequence.add(new Card(0, 100,1));
        sequence.add(new Card(1, 200,0));
        sequence.add(new Card(1, 300,0));
        sequence.add(new Card(1, 400,0));
        sequence.add(new Card(0, 500,-1));
        player.setSequence(sequence);
    }

    public LinkedList<Card> laySequenc2() {
        LinkedList<Card> sequence = new LinkedList<>();
        sequence.add(new Card(1, 640,0));
        sequence.add(new Card(0, 930,1));
        sequence.add(new Card(1, 210,0));
        sequence.add(new Card(0, 310,-1));
        sequence.add(new Card(1, 200,0));
        return sequence;
    }
}