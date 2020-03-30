package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.skeleton.app.Movement.MovementHandler;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.RoboRally;

/**
 * @author vegardbirkenes, Oskar Marthinussen
 * Press G to enter the sequence board.
 */
public class GameScreen extends InputAdapter implements Screen {

    private OrthogonalTiledMapRenderer renderer;
    final private int BOARDSIZE = 12;
    final private int TILESIZE = 300;
    private TiledMap tilemap;
    private Player[] playerList;
    private BitmapFont font;
    private RoboRally game;

    public GameScreen(RoboRally game) {
        this.game = game;
        this.playerList = game.getPlayerList();
        font = new BitmapFont();
        font.setColor(Color.RED);


        //initialize a new tilemap
        TmxMapLoader tmxLoader = new TmxMapLoader();
        tilemap = tmxLoader.load("assets/Maps/map1.tmx");

        //initialize a new camera and renderer for camera
        OrthographicCamera camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(tilemap, 1);

        camera.setToOrtho(false, BOARDSIZE*TILESIZE , BOARDSIZE*TILESIZE);
        camera.update();
        renderer.setView(camera);
    }

    //Currently used in game
    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }


    //Return TiledMap
    public TiledMap getilTiledMap(){
        return this.tilemap;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.G) {
            game.setScreen(new RegisterScreen(this, game));
            return true;
        }
        else if(keycode == Input.Keys.P){
            game.gameTurn();
        }
        return true;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor( 180/255F, 180/255F ,180/255F, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        renderer.render();

        //Render all the players
        TiledMapTileLayer playerLayer = (TiledMapTileLayer) tilemap.getLayers().get("Player");
        for (int i = 0; i<playerList.length; i++) {
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
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
