package inf112.skeleton.app.board.tiles;

import java.util.HashMap;

import static java.lang.Integer.max;

public enum TileType {

    // Each tile is connected to a numeric value and damage
    TILE_GROUND (5, 0),
    TILE_HOLE (6, 9),

    //TODO WRENCH AND HAMMER
    TILE_WRENCH (15, 0),
    TILE_WRENCH_HAMMER (7,0),

    //TODO GEARS
    TILE_GEAR_RED (53,0),     // Rotates left
    TILE_GEAR_GREEN (54,0),   // Rotates right

    //TODO SINGLE LASERS
    TILE_LASER_SINGLE_WALL_SOUTH (37,1),
    TILE_LASER_SINGLE_WALL_WEST (38,1),
    TILE_LASER_SINGLE_WALL_NORTH (45,1),
    TILE_LASER_SINGLE_WALL_EAST (46,1),
    TILE_LASER_SINGLE_HORIZONTAL (39,1),
    TILE_LASER_SINGLE_VERTICAL (47,1),
    TILE_LASER_SINGLE_CROSS (40,1),

    //TODO DOUBLE LASERS
    TILE_LASER_DOUBLE_WALL_SOUTH (87,2),
    TILE_LASER_DOUBLE_WALL_WEST (93,2),
    TILE_LASER_DOUBLE_WALL_NORTH (94,2),
    TILE_LASER_DOUBLE_WALL_EAST (95,2),
    TILE_LASER_DOUBLE_HORIZONTAL (103,2),
    TILE_LASER_DOUBLE_VERTICAL (102,2),
    TILE_LASER_DOUBLE_CROSS (101,2),

    //TODO FLAGS
    TILE_FLAG_1 (55,0),
    TILE_FLAG_2 (63,0),
    TILE_FLAG_3 (71,0),
    TILE_FLAG_$ (79,0),


    //TODO START POSITION
    TILE_START_POS_1 (121,0),
    TILE_START_POS_2 (122,0),
    TILE_START_POS_3 (123,0),
    TILE_START_POS_4 (124,0),
    TILE_START_POS_5 (125,0),
    TILE_START_POS_6 (126,0),
    TILE_START_POS_7 (127,0),
    TILE_START_POS_8 (128,0),

    //TODO WALLS
    TILE_WALL_SOUTH_EAST (8,0),
    TILE_WALL_NORTH_EAST (16,0),
    TILE_WALL_NORTH_WEST (24,0),
    TILE_WALL_SOUTH_WEST(32,0),

    TILE_WALL_EAST (23,0),
    TILE_WALL_SOUTH (29,0),
    TILE_WALL_WEST (30,0),
    TILE_WALL_NORTH (31,0),


    //TODO FAST CONVEOUR BELT
    TILE_CONVEYOR_FAST_NORTH (13,0),
    TILE_CONVEYOR_FAST_EAST (14,0),
    TILE_CONVEYOR_FAST_SOUTH (21,0),
    TILE_CONVEYOR_FAST_WEST (22,0),

    TILE_CONVEYOR_FAST_WEST_TO_SOUTH (17,0),
    TILE_CONVEYOR_FAST_SOUTH_TO_EAST (25,0),
    TILE_CONVEYOR_FAST_EAST_TO_NORTH (26,0),
    TILE_CONVEYOR_FAST_NORTH_TO_WEST (18,0),

    TILE_CONVEYOR_FAST_NORTH_TO_EAST (19,0),
    TILE_CONVEYOR_FAST_EAST_TO_SOUTH (20,0),
    TILE_CONVEYOR_FAST_SOUTH_TO_WEST (28,0),
    TILE_CONVEYOR_FAST_WEST_TO_NORTH (27,0),


    //TODO SLOW CONVEYOUR BELT
    TILE_CONVEYOR_SLOW_NORTH (49,0),
    TILE_CONVEYOR_SLOW_SOUTH (50,0),
    TILE_CONVEYOR_SLOW_WEST (51,0),
    TILE_CONVEYOR_SLOW_EAST (52,0),

    TILE_CONVEYOR_SLOW_WEST_TO_SOUTH (33,0),
    TILE_CONVEYOR_SLOW_SOUTH_TO_EAST (41,0),
    TILE_CONVEYOR_SLOW_EAST_TO_NORTH (42,0),
    TILE_CONVEYOR_SLOW_NORTH_TO_WEST (34,0),

    TILE_CONVEYOR_SLOW_NORTH_TO_EAST (35,0),
    TILE_CONVEYOR_SLOW_EAST_TO_SOUTH (43,0),
    TILE_CONVEYOR_SLOW_SOUTH_TO_WEST (44,0),
    TILE_CONVEYOR_SLOW_WEST_TO_NORTH (36,0);


    private final int tileID;
    private int damage;

    //Connects tileID with tile
    TileType(int tileID, int damage) {
        this.tileID = tileID;
        this.damage = damage;
    }

    public int getTileType() {return this.tileID; }

    private static HashMap<Integer, TileType> tileMap;

    static {
        for (TileType typeOfTile :  TileType.values()) {
            tileMap.put(typeOfTile.getTileType(), typeOfTile);
        }
    }

    public static TileType getTileByID (int id) {
        return tileMap.get(id);
    }
}

