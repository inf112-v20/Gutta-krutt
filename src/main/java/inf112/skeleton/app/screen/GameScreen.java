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
import java.util.Random;

/**
 * @author Vegard Birkenes
 * Press G to enter the sequence board.
 */
public class GameScreen extends InputAdapter implements Screen {

    private OrthogonalTiledMapRenderer renderer;
    final private int HEIGHT = 15;
    final private int WIDTH = 12;
    final private int TILESIZE = 300;
    private TiledMap tilemap;
    private ArrayList<Player> playerList;
    private BitmapFont font;
    private RoboRally game;
    private RegisterScreen registerScreen;
    private MovementHandler movementHandler;

    public GameScreen(RoboRally game, String difficulty) {
        this.game = game;
        font = new BitmapFont();
        font.setColor(Color.RED);

        playerList = new ArrayList<>();
        createPlayers(4);

        //initialize a new tilemap

        TmxMapLoader tmxLoader = new TmxMapLoader();
        tilemap = tmxLoader.load("assets/maps/Map_" + difficulty + ".tmx");
        OrthographicCamera camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(tilemap, 1);
        camera.setToOrtho(false, WIDTH*TILESIZE , HEIGHT*TILESIZE);
        camera.update();
        renderer.setView(camera);
        registerScreen = new RegisterScreen(this, game, playerList.get(0)); // Trenger spiller?
    }


    /**
     * Initialize all the players at the start of the game.
     * @param amountOfPlayers amount of players playing.
     */
    private void createPlayers(int amountOfPlayers){
        Random ran = new Random();
        ArrayList<int[]> startPos = new ArrayList<>();

        // Add all starting positions in one array. 0,1, 3, 5, 6, 8, 10, 11
        int[][] coordinates = {{0,1}, {1,1}, {3, 1},{5, 1}, {6, 1}, {8, 1}, {10, 1}, {11, 1}};
        for (int[] pos : coordinates){
            startPos.add(pos);
        }
        // Add players to playerList
        for (int y = 0; y < amountOfPlayers; y++){
            int[] playerStartPos = startPos.remove(ran.nextInt(startPos.size()));
            String path = "assets/playerTexture/robot" + y + ".png";
            playerList.add(y, new Player(playerStartPos[0], playerStartPos[1], path));
        }
        playerList.get(0).takeDamage(5);
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
        } else if (keycode == Input.Keys.P) {
            game.setScreen(new UserManual(this, game));
        } else if (keycode == Input.Keys.UP) {
            wayToMove = 0;
        } else if (keycode == Input.Keys.LEFT) {
            wayToMove = 1;
        } else if (keycode == Input.Keys.RIGHT) {
            wayToMove = 3;
        } else if (keycode == Input.Keys.DOWN) {
            wayToMove = 2;
        }
        if (wayToMove == -1) {
            return true;
        }

        boolean movePlayer = movementHandler.movePlayer(wayToMove, playerList.get(0));
        if (playerList.get(0).checkWinCondition()) {
            if (playerList.get(0).getLives() <= 0) {
                game.setScreen(new LoseScreen());
            }
            if (playerList.get(0).checkWinCondition()) {
                System.out.println("YOU WIN!!!");
                game.setScreen(new WinScreen(game));
            }
        }
            return movePlayer;
    }

    public MovementHandler getMovementHandler() {
        return movementHandler;
    }

    public ArrayList<Player> getPlayers() {
        return playerList;
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

        for (int i = 0; i<playerList.size(); i++) {
            Player player =playerList.get(i);
            playerLayer.setCell((int) player.getPosX(), (int) player.getPosY(), player.getPlayerNormal());
            player.renderPlayerTexture();
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
        font.dispose();
    }
}
