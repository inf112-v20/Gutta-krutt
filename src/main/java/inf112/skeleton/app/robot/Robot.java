package inf112.skeleton.app.robot;

import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Direction;

public class Robot {

    private Direction direction;
    private Vector2 playerPosition;
    private int currentHealth;
    private int maxHealth;

    public Robot(Vector2 pos) {
        this.playerPosition = pos;
        this.direction = Direction.EAST;
    }

    public void movePlayer(int xMove, int yMove) {
        playerPosition.x += xMove;
        playerPosition.y += yMove;
    }

    public void rotatePlayer(Direction dir) {
        this.direction = dir;
    }

    public int getDamageTaken() {
        return maxHealth - currentHealth;
    }

    public void takeDamage(int dmg) {
        currentHealth -= dmg;
    }

    public void powerDown() {
        currentHealth = maxHealth;
    }

}
