package inf112.skeleton.app.Player;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Direction;

public class Player extends InputAdapter {
    private Vector2 position;
    private TiledMap tilemap;
    private TiledMapTileLayer layer;

    private TiledMapTileLayer.Cell playerNormal;
    private TiledMapTileLayer.Cell playerWon;
    private TiledMapTileLayer.Cell playerDied;

    public Player(TiledMap tilemap, int startingX, int startingY) {

        this.tilemap = tilemap;

        playerNormal = new TiledMapTileLayer.Cell();
        playerWon = new TiledMapTileLayer.Cell();
        playerDied = new TiledMapTileLayer.Cell();

        layer = (TiledMapTileLayer) tilemap.getLayers().get("Player");
        renderPlayerTexture();
        position = new Vector2(startingX, startingY);
        layer.setCell((int) getPosX(), (int) getPosY(), playerNormal);
    }


    public boolean move(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                return move(Direction.NORTH);
            case Input.Keys.DOWN:
                return move(Direction.SOUTH);
            case Input.Keys.LEFT:
                return move(Direction.WEST);
            case Input.Keys.RIGHT:
                return move(Direction.EAST);
            default:
                return false;
        }
    }

    public boolean move(Direction dir) {

        //clearing the previouse tile
        layer.setCell((int) position.x,(int) position.y, null);

        if(dir == Direction.NORTH){ position.y += 1;}
        else if(dir == Direction.SOUTH) {position.y -=1;}
        else if(dir == Direction.WEST) {position.x -= 1;}
        else if(dir == Direction.EAST) {position.x += 1;}
        else {return false;}

        //setting the new player tile
        layer.setCell((int) position.x, (int) position.y, playerNormal);
        return true;
    }

    public float getPosX() {return position.x;}

    public float getPosY() {return position.y;}

    public Vector2 getPosition() {return position;}

    private void renderPlayerTexture() {
        //loading in player texture
        Texture texture = new Texture("assets/player.png");
        TextureRegion textureRegion = new TextureRegion(texture);
        //splitting the picture into squares [row][column]
        TextureRegion[][] pictures = textureRegion.split(300, 300);

        playerNormal.setTile(new StaticTiledMapTile(pictures[0][0]));
        playerWon.setTile(new StaticTiledMapTile(pictures[0][1]));
        playerDied.setTile(new StaticTiledMapTile(pictures[0][2]));

    }

    //todo: rotate player


}
