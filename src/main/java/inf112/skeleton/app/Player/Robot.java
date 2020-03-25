package inf112.skeleton.app.Player;

import java.util.HashMap;

/**
 * handling all movement connected to the board
 * @author Fredrik Larsen
 */

public enum Robot {
    Fredrik_Robot (1,"Fredrik",9,3),
    Glitch_Robot (2,"Glitch",9,3),
    Hacker_Robot (3,"Hacker",9,3),
    Oskar_Robot (4,"Oskar",9,3),
    Sedric_Robot(5,"Sedric",9,3),
    Vegard_Robot(6,"Vegard",9,3);

    private final int robot_ID;
    private  String robotName;
    private int maxHealth;
    private int lifes;

    //Connects each tile with it´s id and damage
    Robot(int robot_ID, String name ,int maxHealth, int lifes) {
        this.robot_ID = robot_ID;
        this.robotName = name;
        this.maxHealth = maxHealth;
        this.lifes = lifes;

    }

    public int getDirection() {
        return this.robot_ID;
    }

    public String getName() {
        return this.robotName;
    }

    public int getHp() {return this.maxHealth;}

    public int getLifes () {return this.lifes;}

    //HashMap for collecting robots
    private  static HashMap<Integer, Robot> robots;

    static {
        for (Robot robot : Robot.values()) {
            robots.put(robot.getDirection(), robot);
        }
    }

    public static Robot getRobotByID (int id) {
        return robots.get(id);
    }
}