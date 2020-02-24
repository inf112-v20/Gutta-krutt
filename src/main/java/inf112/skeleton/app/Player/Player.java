package inf112.skeleton.app.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Direction;

public class Player {
    int playerX;
    int playerY;
    Vector2 playerPosition;

    public Player(int startingX, int startingY) {

        playerX = startingX;
        playerY = startingY;
        playerPosition = new Vector2(startingX, startingY);
    }

    public void move(Direction dir) {
      switch(dir) {
          case NORTH:
              playerY++;
              break;
          case SOUTH:
              playerY--;
              break;
          case WEST:
              playerX--;
              break;
          case EAST:
              playerX++;
              break;

      }
    }
}
