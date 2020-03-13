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
import inf112.skeleton.app.screen.GameScreen;

/**
 * @author Sedric, Vegard, Fredrik
 * Brukes ikke lenger til å vise fram skjermen
 */
public class Game extends InputAdapter implements ApplicationListener  {
    private GameScreen gameScreen;
    private TiledMap tilemap;

    private Player[] playerList;
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


        gameScreen = new GameScreen();
        movementHandler = new MovementHandler(playerList[0], tilemap);
        Gdx.input.setInputProcessor(this);
    }

    public void createPlayers(){
        playerList = new Player[7];
        for (int y = 0; y < 7; y++){
            String path = "assets/playerTexture/robot" + y + ".png";
            playerList[y] = new Player(0, y, path);
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
        playerLayer.setCell((int)playerList[0].getPosX(),(int)playerList[0].getPosY(), playerList[0].getPlayerNormal());
        // playerLayer.setCell((int)playerList[1].getPosX(),(int)playerList[1].getPosY(), playerList[1].getPlayerNormal());
        // playerLayer.setCell((int)playerList[2].getPosX(),(int)playerList[2].getPosY(), playerList[2].getPlayerNormal());
        // playerLayer.setCell((int)playerList[3].getPosX(),(int)playerList[3].getPosY(), playerList[3].getPlayerNormal());
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
        return movementHandler.movePlayer(keycode);
    }
}


