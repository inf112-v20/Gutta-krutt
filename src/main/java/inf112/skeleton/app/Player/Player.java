package inf112.skeleton.app.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Direction;

/**
 * new instance of a player, containing methods to get position, displaying and rotating
 * player. instanciate player at given X and Y coordinates
 * @author Sedric Kvarnes, Vegard Birkenes, Fredrik Larsen
 */
public class Player {
    public int getPlayerID;
    private Vector2 position;
    private TiledMapTileLayer.Cell playerNormal;
    private String filePath;
    private final int maxHealth = 10;
    private int currentHealth;
    private int lifes = 3;

    public Player(int startingX, int startingY, String filePath) {

        playerNormal = new TiledMapTileLayer.Cell();
        this.filePath = filePath;
        this.currentHealth = maxHealth;

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
    }


    // A function that takes in damage and reduce current health
    public void takeDamage(int damage) {
        currentHealth -= damage;
    }

    public int getDamageTaken () {
        return maxHealth - currentHealth;
    }

    // A function for power-down, sets current health to max health
    public void powerDown() {
        currentHealth = maxHealth;
    }

    // A function of lifes left in game
    public void destroyed() { this.lifes -= 1; }

    public boolean gameOver() {
        if (this.lifes >= 0)
            return true;
        else
            return false;
    }

    public void repairRobot(int repair) {
        if (currentHealth < maxHealth && currentHealth != 0) {
            currentHealth ++;
        }
        return;
    }

    public int getMaxHealth () { return maxHealth; }

    public int getCurrentHealth () { return currentHealth; }

    //Setting default dir to north
    private Direction dir = Direction.NORTH;

    // Getting the the current direction
    public Direction getDir() {
        return dir;
    }
    public void setDir(Direction direction){
        this.dir = direction;
    }
}
