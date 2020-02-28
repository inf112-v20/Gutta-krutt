package inf112.skeleton.app;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.screen.GameScreen;

public class Game extends InputAdapter implements ApplicationListener  {
    private GameScreen gameScreen;
    private TiledMap tilemap;

    private TiledMapTileLayer holeLayer;
    private TiledMapTileLayer boardLayer;
    private TiledMapTileLayer flagLayer;
    private Player player;

    private TiledMapTileLayer northWall;
    private TiledMapTileLayer eastWall;
    private TiledMapTileLayer westWall;
    private TiledMapTileLayer southWall;
    private TiledMapTileLayer westSouthWall;

    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        //initialize a new tilemap
        TmxMapLoader tmxLoader = new TmxMapLoader();
        tilemap = tmxLoader.load("assets/map1.tmx");

        getMapLayers();
        player = new Player(tilemap, 0 ,0);
        gameScreen = new GameScreen(tilemap);

        Gdx.input.setInputProcessor(this);
    }

    public void getMapLayers() {
        boardLayer = (TiledMapTileLayer) tilemap.getLayers().get("Board");
        flagLayer = (TiledMapTileLayer) tilemap.getLayers().get("Flags");
        holeLayer = (TiledMapTileLayer) tilemap.getLayers().get("Holes");
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
        return player.move(keycode);
    }
}


