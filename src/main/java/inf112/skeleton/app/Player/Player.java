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
    private Vector2 checkpoint;
    private TiledMapTileLayer.Cell playerNormal;
    private LinkedList<Card> sequence; //skal kanskje dette endres til array?
    private LinkedList<Card> lastTurnSequence;
    private String filePath;
    private int direction; // Direction is an int because TiledMapTileLayer.Cell.ROTATE_* is an int.
    private int health;
    private int lives;

    /**
     * @param startingX the starting x-coordinate for player
     * @param startingY the starting y-coordinate for player
     * @param filePath the filepath to a png/jpg for displaying a player
     */
    public Player(int startingX, int startingY, String filePath) {
        playerNormal = new TiledMapTileLayer.Cell();
        this.filePath = filePath;
        checkpoint = new Vector2(startingX,startingY);
        position = new Vector2(startingX, startingY);
        lives = 3;
        direction = 0;
        health = 10;
    }

    /**
     * sets the roation of a player
     * @param cell_rotation takes an int form TiledMapTileLayer.Cell.ROTATE_* (0,90,180,270)
     */
    public void setRotation(int cell_rotation) { playerNormal.setRotation(cell_rotation); }

    public int getRotation() {return playerNormal.getRotation();}

    public void setCheckpoint() {checkpoint = position.cpy();}

    public Vector2 getCheckpoint() {return checkpoint.cpy();}

    public float getPosX() {return position.x;}

    public float getPosY() {return position.y;}

    public void addPos(float x, float y) {position.add(x,y);}

    public void addPos(Vector2 vector) {position = vector;}

    public void addPosX(float x) {addPos(x,0);}

    public void addPosY(float y) {addPos(0,y);}

    public int getDirection() {return direction;}

    public void setDirection(int direction) {this.direction = direction;}

    public void isDestroyed() {health = 0;}

    public void setFullHealth() {health = 10;}

    /**
     * reduces lives of a player by one
     */
    public void destroyed() {lives -= 1;}

    public int getLives() { return lives; }

    public int getCurrentHealth () { return health; }

    /**
     * reduces health by damage
     * @param damage the amount of damage
     */
    public void takeDamage(int damage) {
        health -= damage;
    }

    public int getDamageTaken () {
        return 10 - health;
    }

    /**
     * sets the health to max, health = 10
     */
    public void powerDown() {
        health = 10;
        setSequence(null);
    }

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


    public void setSequence(LinkedList<Card> sequence) { this.sequence = sequence; }

    public LinkedList<Card> getSequence() { return sequence; }

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
}
