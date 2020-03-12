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
        createPlayers();
        //initialize deck
        deck = new Deck();


        gameScreen = new GameScreen(tilemap);
        movementHandler = new MovementHandler(tilemap);
        Gdx.input.setInputProcessor(this);
    }

    public void createPlayers(){
        playerList = new Player[7];
        for (int x = 0; x < 7; x++){
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
        //Initialize players
        for (int i = 0; i<1; i++) {
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

    public void executeCard(PlayerCardPair pair){
        int distance = pair.getCard().getDistance();
        int rotation = pair.getCard().getChangeDirection();

        System.out.println(playerList[0].getDirection());
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

    public void gameTurn(){
        int roundThisTurn = 1;
        for (Player player : playerList){
            laySequence(player);
        }
        while (roundThisTurn <= 5) {
            ArrayList<PlayerCardPair> currentRound = new ArrayList<>();

            //Gather the first card from each player's sequence and put it in a list
            //that is sorted in the order each card should be executed
            for (Player player : playerList) {
                PlayerCardPair pair = new PlayerCardPair(player.getPlayerID(), player.getSequence().pollFirst());
                if (pair.getCard() != null) {
                    if (currentRound.size() == 0) {
                        currentRound.add(0, pair);
                    } else {
                        for (int i = 0; i < currentRound.size(); i++) {
                            if (pair.getCard().getPriority() < currentRound.get(i).getCard().getPriority()) {
                                currentRound.add(i + 1, pair);
                            }
                        }
                    }
                }
            }
            for (PlayerCardPair currentPair : currentRound) {
                executeCard(currentPair);
            }
            roundThisTurn++;
        }
    }

    public void laySequence(Player player) {
        LinkedList<Card> sequence = new LinkedList<>();
        sequence.add(new Card(1, 600,0));
        sequence.add(new Card(0, 650,1));
        sequence.add(new Card(1, 700,0));
        player.setSequence(sequence);
    }
}