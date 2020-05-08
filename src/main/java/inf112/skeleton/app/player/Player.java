package inf112.skeleton.app.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Card;
import java.util.ArrayList;

/**
 * New instance of a player, containing methods to get position, displaying and rotating
 * player. Instantiate player at given X and Y coordinates
 * @author Sedric Kvarnes, Vegard Birkenes, Fredrik Larsen, Oskar Marthinussen
 */
public class Player {
    private Vector2 position;
    private Vector2 checkpoint;
    private TiledMapTileLayer.Cell playerNormal;
    private ArrayList<Card> sequence;
    private ArrayList<Card> lastTurnSequence;
    private String filePath;
    private int direction;
    private int health;
    private int lives;
    private boolean[] visitedFlags;

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
        visitedFlags = new boolean[]{false, false, false};
    }

    /**
     * Sets the rotation of a player
     * @param cell_rotation takes an int form TiledMapTileLayer.Cell.ROTATE_* (0,90,180,270)
     */
    public void setRotation(int cell_rotation) { playerNormal.setRotation(cell_rotation); }

    public void setCheckpoint() {checkpoint = position.cpy();}

    public Vector2 getCheckpoint() {return checkpoint.cpy();}

    public float getPosX() {return position.x;}

    public float getPosY() {return position.y;}

    public Vector2 getPos() {return position;}

    public void addPos(float x, float y) {position.add(x,y);}

    public void addPos(Vector2 vector) {position = vector;}

    public void addPosX(float x) {addPos(x,0);}

    public void addPosY(float y) {addPos(0,y);}

    public int getDirection() {return direction;}

    public void setDirection(int direction) {this.direction = direction;}

    public void setFullHealth() {health = 10;}

    public TiledMapTileLayer.Cell getPlayerNormal() {return playerNormal;}

    public ArrayList<Card> getSequence() { return sequence; }

    /**
     * Reduces lives of a player by one.
     */
    public void destroyed() {lives -= 1;}

    public int getLives() { return lives; }

    public int getCurrentHealth () { return health; }

    /**
     * Reduces health by damage
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

    /**
     * Loading in picture of player, splitting it into 300X300px and setting
     * correct player pitctures to the player.
     */
    public void renderPlayerTexture() {
        Texture texture = new Texture(filePath);
        TextureRegion textureRegion = new TextureRegion(texture);
        TextureRegion[][] pictures = textureRegion.split(300, 300);
        playerNormal.setTile(new StaticTiledMapTile(pictures[0][0]));
    }

    /**
     * Checks if a flag has been captured and updates the wincondition if a flag is visited in correct order
     */
    public void updateWinCondition() {
        if (getPosX() == 2.0 && getPosY() == 11.0 && !visitedFlags[0]) {
            visitedFlags[0] = true;
            System.out.println("Flag 1 captured!");
        }
        else if (getPosX() == 10.0 && getPosY() == 11.0 && visitedFlags[0] && !visitedFlags[1]) {
            visitedFlags[1] = true;
            System.out.println("Flag 2 captured!");
        }
        else if (getPosX() == 0.0 && getPosY() == 4.0 && visitedFlags[1] && !visitedFlags[2]) {
            visitedFlags[2] = true;
            System.out.println("All flags captured, you are awesome!");
        }
    }

    /**
     * Checks if a player has won the game
     * @return true if all flags have been visited
     */
    public boolean checkWinCondition() {
        return visitedFlags[0] && visitedFlags[1] && visitedFlags[2];
    }

    /**
     * Sets a sequence of card for the player
     * @param chosenCards the cards that are chosen.
     */
    public void setSequence(ArrayList<Card> chosenCards) {
        lastTurnSequence = sequence;
        int card = 0;
        if (chosenCards == null) {
            return;
        }
        if (chosenCards.size() == 5){
            sequence = chosenCards;
        }
        else if (chosenCards.size() < 5){
            for (int j = 0; j < chosenCards.size(); j++){
                sequence.set(j, chosenCards.get(j));
                card++;
            }
            for (int i = card; i < 5; i++){
                sequence.set(i, lastTurnSequence.get(i));
            }
        }
    }
}
