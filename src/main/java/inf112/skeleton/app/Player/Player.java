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
 */
public class Player {
    private Vector2 position;
    private TiledMapTileLayer.Cell playerNormal;
    private TiledMapTileLayer.Cell playerWon;
    private TiledMapTileLayer.Cell playerDied;
    private LinkedList<Card> sequence;
    private LinkedList<Card> lastTurnSequence;
    private String filePath;
    private int playerID;
    private int direction; // Direction is an int because TiledMapTileLayer.Cell.ROTATE_** is an int.
    private int healthLeft; //Players start with 3 lives
    private int damageTaken; //Amount of damage tokens a player have received. Goes up to 9



    public Player(int startingX, int startingY, String filePath, int playerID) {

        this.playerNormal = new TiledMapTileLayer.Cell();
        this.playerWon = new TiledMapTileLayer.Cell();
        this.playerDied = new TiledMapTileLayer.Cell();
        this.filePath = filePath;
        this.playerID = playerID;
        this.direction = 0;
        this.healthLeft = 3;
        this.damageTaken = 0;
        this.position = new Vector2(startingX, startingY);

        //Cant render player texture while running tests. Comment out this line for tests.
        renderPlayerTexture();
    }

    public float getPosX() {return position.x;}

    public float getPosY() {return position.y;}

    public void setPos(float x, float y) {position.add(x,y);}

    public void setPosX(float x) {setPos(x,0);}

    public void setPosY(float y) {setPos(0,y);}

    public int getDirection() {return direction;}

    public void setDirection(int direction) {this.direction = direction;}

    public Vector2 getPosition() {return position;}

    public TiledMapTileLayer.Cell getPlayerNormal() {return playerNormal;}

    public LinkedList<Card> getLastTurnSequence() { return lastTurnSequence; }

    public LinkedList<Card> getSequence() { return sequence; }

    public void setSequence(LinkedList<Card> sequence) { this.sequence = sequence; }

    public int getPlayerID() { return playerID; }

    public int getHealthLeft() { return healthLeft; }

    public void decreaseHealthLeft() { this.healthLeft -= 1; }

    public int getDamageTaken() { return damageTaken; }

    public void setDamageTaken(int damageTaken) { this.damageTaken = damageTaken; }

    public void powerDown(){
        setSequence(null);
        setDamageTaken(0);
    }

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

    /**
     * This method is just used for testing.
     */
    public void setLastTurnSequence(LinkedList<Card> lastTurnSequence) {
        this.lastTurnSequence = lastTurnSequence;
    }
}