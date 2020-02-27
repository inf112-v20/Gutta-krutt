package inf112.skeleton.app;

import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.cards.Direction;
import inf112.skeleton.app.robot.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {
    int x,y = 0;
    Robot robot = new Robot(new Vector2(x,y));

    @Test
    public void robotHasFullHealthTest() {
        assertEquals(0, robot.getDamageTaken());
    }

    @Test
    public void robotDirectionTest() {
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    public void takeDamageTest() {
        robot.takeDamage(6);
        assertEquals(6, robot.getDamageTaken());
    }

    @Test
    public void powerDownTest() {
        robot.takeDamage(6);
        robot.powerDown();
        assertEquals(0, robot.getDamageTaken());
    }

}
