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

public class Game extends InputAdapter implements ApplicationListener  {
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap tilemap;

    private TiledMapTileLayer holeLayer;
    private TiledMapTileLayer boardLayer;
    private TiledMapTileLayer flagLayer;
    private TiledMapTileLayer playerLayer;
    private TiledMapTileLayer northWall;
    private TiledMapTileLayer eastWall;
    private TiledMapTileLayer westWall;
    private TiledMapTileLayer southWall;

    private TiledMapTileLayer westSouthWall;
    private TiledMapTileLayer.Cell player;
    private TiledMapTileLayer.Cell playerWon;
    private TiledMapTileLayer.Cell playerDied;
    private Vector2 playerPosition;

    //number of tiles per side of the board
    final private int BOARDSIZE = 12;
    // pixelSize of each tile
    final private int TILESIZE = 300;

    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        int PlayerStartingX = 0;
        int PlayerStartingY = 0;

        //initialize a new tilemap
        TmxMapLoader tmxLoader = new TmxMapLoader();
        tilemap = tmxLoader.load("assets/map1.tmx");

        getMapLayers();

        //initialize a new camera and renderer for camera
        OrthographicCamera camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(tilemap, 1);

        camera.setToOrtho(false, BOARDSIZE*TILESIZE , BOARDSIZE*TILESIZE);
        camera.update();
        renderer.setView(camera);

        //loading in player texture
        Texture texture = new Texture("assets/player.png");
        TextureRegion textureRegion = new TextureRegion(texture);
        //splitting the picture into squares [row][column]
        TextureRegion[][] pictures = textureRegion.split(300, 300);

        player = new TiledMapTileLayer.Cell();
        playerWon = new TiledMapTileLayer.Cell();
        playerDied = new TiledMapTileLayer.Cell();

        //instantiating and setting the different player pictures
        player.setTile(new StaticTiledMapTile(pictures[0][0]));
        playerWon.setTile(new StaticTiledMapTile(pictures[0][1]));
        playerDied.setTile(new StaticTiledMapTile(pictures[0][2]));

        playerPosition = new Vector2(PlayerStartingX, PlayerStartingY);
        Gdx.input.setInputProcessor(this);
    }

    public void getMapLayers() {
        boardLayer = (TiledMapTileLayer) tilemap.getLayers().get("Board");
        flagLayer = (TiledMapTileLayer) tilemap.getLayers().get("Flag");
        holeLayer = (TiledMapTileLayer) tilemap.getLayers().get("Hole");
        playerLayer = (TiledMapTileLayer) tilemap.getLayers().get("Player");
        northWall = (TiledMapTileLayer) tilemap.getLayers().get("North_Walls");
        eastWall = (TiledMapTileLayer) tilemap.getLayers().get("East_Walls");
        westWall = (TiledMapTileLayer) tilemap.getLayers().get("West_Wall");
        southWall = (TiledMapTileLayer) tilemap.getLayers().get("South_Walls");
        westSouthWall = (TiledMapTileLayer) tilemap.getLayers().get("West_South_Walls");
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
        displayPlayer();

        renderer.render();
    }

    public void displayPlayer() {
        int playerX = (int) playerPosition.x;
        int playerY = (int) playerPosition.y;

        if(holeLayer.getCell(playerX, playerY) != null) {
            playerLayer.setCell(playerX, playerY, playerWon);
        }
        else if (flagLayer.getCell(playerX, playerY) != null) {
            playerLayer.setCell(playerX, playerY, playerDied);
        }
        else {
            playerLayer.setCell(playerX, playerY, player);
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

        //clearing the previouse tile
        playerLayer.setCell((int) playerPosition.x,(int) playerPosition.y, null);

        if(keycode == Input.Keys.UP && playerPosition.y+1 < BOARDSIZE){
            playerPosition.y += 1;
        } else if(keycode == Input.Keys.DOWN && playerPosition.y-1 >= 0) {
            playerPosition.y -=1;
        } else if(keycode == Input.Keys.LEFT && playerPosition.x-1 >= 0) {
            playerPosition.x -= 1;
        } else if(keycode == Input.Keys.RIGHT && playerPosition.x+1 < BOARDSIZE) {
            playerPosition.x += 1;
        } else {
            return false;
        }

        //setting the new player tile
        playerLayer.setCell((int) playerPosition.x, (int) playerPosition.y, player);
        return true;
    }
}


