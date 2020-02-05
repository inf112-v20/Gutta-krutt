package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class HelloWorld implements ApplicationListener {
    private  OrthogonalTiledMapRenderer renderer;
    private TiledMap tiledmap;
    private TiledMapTileLayer Hole;
    //private TiledMapTileLayer Player;
    private TiledMapTileLayer Board;
    private TiledMapTileLayer Flag;


    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        //initialize a new tilemap
        TmxMapLoader tmxLoader = new TmxMapLoader();
        tiledmap = tmxLoader.load("../../../assets/testBoard.tmx");

        //initialize a new camera and renderer for camera
        OrthographicCamera camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(tiledmap, 1/300);

        camera.setToOrtho(false, (float) 2.5 ,5);
        camera.update();
        renderer.setView(camera);



        Board = (TiledMapTileLayer) tiledmap.getLayers().get("Board");
        Flag = (TiledMapTileLayer) tiledmap.getLayers().get("Flag");
        Hole = (TiledMapTileLayer) tiledmap.getLayers().get("Hole");


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
}
