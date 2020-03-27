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


/**
 * @author Sedric, Vegard, Fredrik
 * Brukes ikke lenger til å vise fram skjermen
 */
public class Game extends InputAdapter implements ApplicationListener  {
    private GameScreen gameScreen;
    private TiledMap tilemap;

    private Player[] playerList;
    private int amountOfPlayers = 4;
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


        //gameScreen = new GameScreen(tilemap);
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
        //gameTurn();
        return true;
    }
}