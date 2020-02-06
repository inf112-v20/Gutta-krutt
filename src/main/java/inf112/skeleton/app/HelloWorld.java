package inf112.skeleton.app;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.loaders.TextureLoader;
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

public class HelloWorld extends InputAdapter implements ApplicationListener  {
    private  OrthogonalTiledMapRenderer renderer;
    private TiledMap tiledmap;
    private TiledMapTileLayer Hole;
    private TiledMapTileLayer Board;
    private TiledMapTileLayer Flag;
    private TiledMapTileLayer playerLayer;
    private TiledMapTileLayer.Cell player;
    private TiledMapTileLayer.Cell playerWon;
    private TiledMapTileLayer.Cell playerDied;
    private Vector2 playerPosition;




    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        //initialize a new tilemap
        TmxMapLoader tmxLoader = new TmxMapLoader();
        tiledmap = tmxLoader.load("assets/testBoard.tmx");
            

        //initialize a new camera and renderer for camera
        OrthographicCamera camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(tiledmap, 1);

        camera.setToOrtho(false, 1500 ,1500);
        camera.update();
        renderer.setView(camera);



        Board = (TiledMapTileLayer) tiledmap.getLayers().get("Board");
        Flag = (TiledMapTileLayer) tiledmap.getLayers().get("Flag");
        Hole = (TiledMapTileLayer) tiledmap.getLayers().get("Hole");

        //player
        Texture texture = new Texture(Gdx.files.internal("player.png"));
        TextureRegion textureRegion = new TextureRegion(texture);
        //[] row [] column
        TextureRegion[][] pictures = textureRegion.split(300, 300);

        System.out.println(pictures[0][0]);

        player = new TiledMapTileLayer.Cell();
        playerWon = new TiledMapTileLayer.Cell();
        playerDied = new TiledMapTileLayer.Cell();

        StaticTiledMapTile playerTile = new StaticTiledMapTile(pictures[0][0]);
        StaticTiledMapTile playerDiedTile = new StaticTiledMapTile(pictures[0][1]);
        StaticTiledMapTile playerWonTile = new StaticTiledMapTile(pictures[0][2]);

        player.setTile(playerTile);
        playerWon.setTile(playerDiedTile);
        playerDied.setTile(playerWonTile);

        playerPosition = new Vector2(100, 100);

        //Gdx.input.setInputProcessor((InputProcessor) this);



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

        renderer.render();

        playerLayer.setCell(100,100,player);

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
        return false;
    }
}
