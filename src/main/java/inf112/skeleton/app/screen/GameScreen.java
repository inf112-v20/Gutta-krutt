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

import java.util.ArrayList;

/**
 * @author vegardbirkenes
 * Press G to enter the sequence board.
 */
public class GameScreen extends InputAdapter implements Screen {

    private OrthogonalTiledMapRenderer renderer;
    final private int BOARDSIZE = 12;
    final private int TILESIZE = 300;
    private TiledMap tilemap;
    private ArrayList<Player> playerList;
    private BitmapFont font;
    private RoboRally game;
    private Player player;
    private Player dummy;

    public GameScreen(RoboRally game) {
        this.game = game;
        font = new BitmapFont();
        font.setColor(Color.RED);

        playerList = new ArrayList<>();
        player = new Player(0,0, "assets/playerTexture/robot0.png");
        dummy = new Player(0,2, "assets/playerTexture/robot1.png");
        playerList.add(player);
        playerList.add(dummy);

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

    @Override
    public boolean keyUp(int keycode) {
        MovementHandler movementHandler = new MovementHandler(tilemap, playerList);
        if (keycode == Input.Keys.G) {
            game.setScreen(new RegisterScreen(this, game));
            return true;
        }
        return movementHandler.movePlayer(keycode, player);
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


        TiledMapTileLayer playerLayer = (TiledMapTileLayer) tilemap.getLayers().get("Player");
        playerLayer.setCell((int)player.getPosX(), (int) player.getPosY(), player.getPlayerNormal());
        playerLayer.setCell((int)dummy.getPosX(), (int) dummy.getPosY(), dummy.getPlayerNormal());
        player.renderPlayerTexture();
        dummy.renderPlayerTexture();
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
