package inf112.skeleton.app.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Card;
import inf112.skeleton.app.cards.Direction;

import java.util.LinkedList;

/**
 * new instance of a player, containing methods to get position, displaying and rotating
 * player. instanciate player at given X and Y coordinates
 * @author Sedric Kvarnes, Vegard Birkenes, Fredrik Larsen, Oskar Marthinussen
 */
public class Player {
    private Vector2 position;
    private TiledMapTileLayer.Cell playerNormal;
    private LinkedList<Card> sequence;
    private LinkedList<Card> lastTurnSequence;
    private String filePath;
    private int maxHealth = 10;
    private int direction; // Direction is an int because TiledMapTileLayer.Cell.ROTATE_* is an int.
    private int currentHealth;
    private int life = 3;

    private int health;
    private Vector2 checkpoint;

    public Player(int startingX, int startingY, String filePath) {
        this.playerNormal = new TiledMapTileLayer.Cell();
        this.filePath = filePath;
        health = 10;
        checkpoint = new Vector2(startingX,startingY);

        renderPlayerTexture();
        position = new Vector2(startingX, startingY);
        this.direction = 0;
        this.position = new Vector2(startingX, startingY);
        this.currentHealth = maxHealth;
    }

    public void setRotation(int cell_rotation) {playerNormal.setRotation(cell_rotation);}

    public int getRotation() {return playerNormal.getRotation();}

    public void setCheckpoint() {checkpoint = position.cpy();}

    public Vector2 getCheckpoint() {return checkpoint.cpy();}

    public float getPosX() {return position.x;}

    public float getPosY() {return position.y;}

    public void setPos(float x, float y) {position.add(x,y);}

    public void setPos(Vector2 vector) {position = vector;}

    public void setPosX(float x) {setPos(x,0);}

    public void setPosY(float y) {setPos(0,y);}

    public int getDirection() {return direction;}

    public void setDirection(int direction) {this.direction = direction;}

    public void isDestoyed() {health = 0;}

    public void setFullHealth() {health = 10;}

    public int getHealth() {return health;}

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
        setSequence(null);
    }

    // A function of lifes left in game
    public void destroyed() { this.life -= 1; }

    public boolean gameOver() {
        if (this.life >= 0)
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

    public int getLife() { return life; }

    /**
     * Get max health
     * @return Max health
     */
    public int getMaxHealth () { return maxHealth; }

    /**
     * Get current health
     * @return Current health
     */
    public int getCurrentHealth () { return currentHealth; }

    /**
     * Set current round sequence.
     * @param sequence The sequence you want to execute this turn.
     */
    public void setSequence(LinkedList<Card> sequence) { this.sequence = sequence; }

    /**
     * Get this turn sequence.
     * @return this turn sequence.
     */
    public LinkedList<Card> getSequence() { return sequence; }

    /**
     * Reset players sequence. The amount of cards that are locked for the next round correspond to the amount of
     * damagetokens a player got minus 4.
     */
    public void resetSequences(){
        LinkedList<Card> newSequence = new LinkedList<>();
        setSequence(new LinkedList<Card>());

        if (getDamageTaken() > 4){
            int lockedCards = getDamageTaken() - 4;
            while (lockedCards > 0){
                newSequence.add(getLastTurnSequence().pollFirst());
                lockedCards--;
            }
            setSequence(newSequence);
        }
    }

    /**
     * Get last turn sequence
     * @return Last turn sequence
     */
    public LinkedList<Card> getLastTurnSequence() { return lastTurnSequence; }

    /**
     * Set last turn sequence. Method used for testing.
     * @param sequence the sequence you want to set.
     */
    public void setLastTurnSequence(LinkedList<Card> sequence) {this.lastTurnSequence = sequence; }

    /**
     * Reset last turn sequence
     */
    public void resetLastTurnSequence() { this.lastTurnSequence = new LinkedList<>(); }
}
