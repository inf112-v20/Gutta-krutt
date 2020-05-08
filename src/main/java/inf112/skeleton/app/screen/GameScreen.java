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
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.movement.MovementHandler;
import inf112.skeleton.app.player.Player;
import java.util.ArrayList;

/**
 * @author Vegard Birkenes
 * Press G to enter the sequence board.
 */
public class GameScreen extends InputAdapter implements Screen {

    private final OrthogonalTiledMapRenderer renderer;
    private final TiledMap tilemap;
    private final ArrayList<Player> playerList;
    private final BitmapFont font;
    private final RoboRally game;
    private final Player player;
    private final Player dummy;
    private RegisterScreen registerScreen;
    private MovementHandler movementHandler;

    public GameScreen(RoboRally game) {
        int HEIGHT = 15;
        int WIDTH = 12;
        int TILESIZE = 300;
        this.game = game;
        font = new BitmapFont();
        font.setColor(Color.RED);

        playerList = new ArrayList<>();
        player = new Player(5,1, "assets/playerTexture/robot0.png");
        dummy = new Player(6,1, "assets/playerTexture/robot1.png");
        playerList.add(player);
        playerList.add(dummy);

        //initialize a new tilemap
        TmxMapLoader tmxLoader = new TmxMapLoader();
        tilemap = tmxLoader.load("assets/maps/Map_Easy.tmx");
        OrthographicCamera camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(tilemap, 1);
        camera.setToOrtho(false, WIDTH * TILESIZE, HEIGHT * TILESIZE);
        camera.update();
        renderer.setView(camera);
        registerScreen = new RegisterScreen(this, game, player);
    }

    /**
     * Sets the registerscreen for the new sequence
     * @param regScreen RegisterScreen
     */
    public void setRegisterScreen(RegisterScreen regScreen) { registerScreen = regScreen; }

    @Override
    public boolean keyUp(int keycode) {
        movementHandler = new MovementHandler(tilemap, playerList);
        int wayToMove = -1;
        if (keycode == Input.Keys.G) {
            game.setScreen(registerScreen);
        }
        else if (keycode == Input.Keys.P) {
            game.setScreen(new UserManual(this, game));
        }
        else if (keycode == Input.Keys.UP) {
            wayToMove = 0;
        }
        else if (keycode == Input.Keys.LEFT) {
            wayToMove = 1;
        }
        else if (keycode == Input.Keys.RIGHT) {
            wayToMove = 3;
        }
        else if (keycode == Input.Keys.DOWN) {
            wayToMove = 2;
        }
        if (wayToMove == -1) {
            return  true;
        }
        boolean movePlayer = movementHandler.movePlayer(wayToMove, player);
        if (player.getLives() <= 0) {
            game.setScreen(new LoseScreen());
        }
        if (player.checkWinCondition()) {
            System.out.println("YOU WIN!!!");
            game.setScreen(new WinScreen(game));
        }
        return movePlayer;
    }

    public MovementHandler getMovementHandler() {
        return movementHandler;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void show() {Gdx.input.setInputProcessor(this);}

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
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        font.dispose();
    }
}
