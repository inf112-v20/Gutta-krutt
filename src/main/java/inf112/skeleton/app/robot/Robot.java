package inf112.skeleton.app.robot;

import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Direction;

public class Robot {

    // Variables
    private Direction direction;
    // private Vector2 playerPosition;
    private int currentHealth;
    private int maxHealth;
    private int lifesLeft;

    // Initializes to a start position on the start board
    public Robot(Vector2 pos) {
        //this.playerPosition = pos;
        this.direction = Direction.EAST;
        this.maxHealth = 10;
        this.currentHealth = 10;
        this.lifesLeft = 3; // Player starts with 3 lifes
    }

    // A function to check damage taken
    public int getDamageTaken() {
        return maxHealth - currentHealth;
    }

    // A function that takes in damage and reduce current health
    public void takeDamage(int dmg) {
        currentHealth -= dmg;
    }

    // A function for power-down, sets current health to max health
    public void powerDown() {
        currentHealth = maxHealth;
    }

    // A function of lifes left in game
    public void destroyed() {
        lifesLeft -= 1;
    }

    public Direction getDirection() { return this.direction; }

}
