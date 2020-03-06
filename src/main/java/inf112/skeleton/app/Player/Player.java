package inf112.skeleton.app.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;

/**
 * new instance of a player, containing methods to get position, displaying and rotating
 * player. instanciate player at given X and Y coordinates
 */
public class Player {
    private Vector2 position;
    private TiledMapTileLayer.Cell playerNormal;
    private TiledMapTileLayer.Cell playerWon;
    private TiledMapTileLayer.Cell playerDied;
    private String filePath;

    public Player(int startingX, int startingY, String filePath) {

        playerNormal = new TiledMapTileLayer.Cell();
        playerWon = new TiledMapTileLayer.Cell();
        playerDied = new TiledMapTileLayer.Cell();
        this.filePath = filePath;

        renderPlayerTexture();
        position = new Vector2(startingX, startingY);
    }

    public void setRotation(int cell_rotation) {
        playerNormal.setRotation(cell_rotation);
    }
    public float getPosX() {return position.x;}

    public float getPosY() {return position.y;}

    public void setPos(float x, float y) {position.add(x,y);}

    public void setPosX(float x) {setPos(x,0);}

    public void setPosY(float y) {setPos(0,y);}

    public Vector2 getPosition() {return position;}

    public TiledMapTileLayer.Cell getPlayerNormal() {return playerNormal;}

    /**
     * loading in picture of player, splitting it into 300X300px and setting
     * correct player pitctures to the player.
     */

    public void renderPlayerTexture() {
        //loading in player texture
        Texture texture = new Texture(filePath);
        TextureRegion textureRegion = new TextureRegion(texture);
        //splitting the picture into squares [row][column]
        TextureRegion[][] pictures = textureRegion.split(300, 300);

        playerNormal.setTile(new StaticTiledMapTile(pictures[0][0]));
        playerWon.setTile(new StaticTiledMapTile(pictures[0][1]));
        playerDied.setTile(new StaticTiledMapTile(pictures[0][2]));
    }

}
