package inf112.skeleton.app.Player;

import java.util.HashMap;

public enum Robot {
    ROBOT_GREEN (1,"GREEN"),
    ROBOT_GREY (2,"GREY"),
    ROBOT_NERD (3,"NERDY"),
    ROBOT_ORANGE (4,"ORANGE"),
    ROBOT_RED(5, "RED");

    private final int robot_ID;
    private  String robotName;

    //Connects each tile with it´s id and damage
    Robot(int robot_ID, String name) {
        this.robot_ID = robot_ID;
        this.robotName = robotName;
    }

    public int getDirection() {
        return this.robot_ID;
    }

    public String getName() {
        return this.robotName;
    }

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