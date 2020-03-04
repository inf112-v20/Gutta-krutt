package inf112.skeleton.app.Player;

import java.util.HashMap;

public enum Robot {
    ROBOT_GREEN (1,"GREEN",9,3),
    ROBOT_GREY (2,"GREY",9,3),
    ROBOT_NERD (3,"NERDY",9,3),
    ROBOT_ORANGE (4,"ORANGE",9,3),
    ROBOT_RED(5,"RED",9,3);

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