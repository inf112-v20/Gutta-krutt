package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
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

/**
 * @author Vegard Birkenes
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
    private RegisterScreen registerScreen;

    public GameScreen(RoboRally game) {
        this.game = game;
        this.playerList = game.getPlayerList();
        font = new BitmapFont();
        TmxMapLoader tmxLoader = new TmxMapLoader();
        tilemap = tmxLoader.load("assets/maps/map1.tmx");
        OrthographicCamera camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(tilemap, 1);
        camera.setToOrtho(false, BOARDSIZE*TILESIZE , BOARDSIZE*TILESIZE);
        camera.update();
        renderer.setView(camera);
        registerScreen = new RegisterScreen(this, game, playerList[0]);
    }

    /**
     * used for testing map functionality
     * @return returns the current tiledMap
     */
    public TiledMap getTiledMap(){
        return this.tilemap;
    }

    /**
     * Sets the registerscreen for the new sequence
     * @param regScreen RegisterScreen
     */
    public void setRegisterScreen(RegisterScreen regScreen) { registerScreen = regScreen; }

    @Override
    public boolean keyUp(int keycode) {
        MovementHandler movementhandlerPlayer1 = game.getMovementHandlerList()[0]; // todo: this is maybe not optimal
        int wayToMove = -1;
        if (keycode == Input.Keys.G) {
            game.setScreen(registerScreen);
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
        boolean movePlayer = movementhandlerPlayer1.movePlayer(wayToMove);
        if (playerList[0].checkWinCondition()) {
            System.out.println("YOU WIN!!!");
            game.setScreen(new WinScreen(game));
        }
        return movePlayer;
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
        playerLayer.setCell((int) playerList[0].getPosX(), (int) playerList[0].getPosY(), playerList[0].getPlayerNormal());
        /**for (int i = 0; i<playerList.length; i++) {
            playerLayer.setCell((int) playerList[i].getPosX(), (int) playerList[i].getPosY(), playerList[i].getPlayerNormal());
        }*/
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
        font.dispose();
    }
}
