package inf112.skeleton.app.tiles;

import java.util.HashMap;

public enum TileType {
    // Each tile is connected to a numeric value
    TILE_GROUND (5),
    TILE_HOLE1 (6),
    TILE_HOLE2 (91),
    TILE_HOLE3 (92),
    TILE_HOLE4 (105),
    TILE_HOLE5 (106),
    TILE_HOLE6 (107),
    TILE_HOLE7 (108),
    TILE_HOLE8 (109),
    TILE_HOLE9 (110),
    TILE_HOLE10 (113),
    TILE_HOLE11 (114),
    TILE_HOLE12 (115),
    TILE_HOLE13 (116),
    TILE_HOLE14 (117),
    TILE_HOLE15 (118),


    //TODO WRENCH AND HAMMER
    TILE_WRENCH (15),
    TILE_WRENCH_HAMMER (7),

    //TODO GEARS
    TILE_GEAR_RED (53),     // Rotates left
    TILE_GEAR_GREEN (54),   // Rotates right

    //TODO SINGLE LASERS
    TILE_LASER_SINGLE_WALL_SOUTH (37),
    TILE_LASER_SINGLE_WALL_WEST (38),
    TILE_LASER_SINGLE_WALL_NORTH (45),
    TILE_LASER_SINGLE_WALL_EAST (46),
    TILE_LASER_SINGLE_HORIZONTAL (39),
    TILE_LASER_SINGLE_VERTICAL (47),
    TILE_LASER_SINGLE_CROSS (40),

    //TODO DOUBLE LASERS
    TILE_LASER_DOUBLE_WALL_SOUTH (87),
    TILE_LASER_DOUBLE_WALL_WEST (93),
    TILE_LASER_DOUBLE_WALL_NORTH (94),
    TILE_LASER_DOUBLE_WALL_EAST (95),
    TILE_LASER_DOUBLE_HORIZONTAL (103),
    TILE_LASER_DOUBLE_VERTICAL (102),
    TILE_LASER_DOUBLE_CROSS (101),

    //TODO FLAGS
    TILE_FLAG_1 (55),
    TILE_FLAG_2 (63),
    TILE_FLAG_3 (71),
    TILE_FLAG_4 (79),


    //TODO START POSITION
    TILE_START_POS_1 (121),
    TILE_START_POS_2 (122),
    TILE_START_POS_3 (123),
    TILE_START_POS_4 (124),
    TILE_START_POS_5 (125),
    TILE_START_POS_6 (126),
    TILE_START_POS_7 (127),
    TILE_START_POS_8 (128),

    //TODO WALLS
    TILE_WALL_SOUTH_EAST (8),
    TILE_WALL_NORTH_EAST (16),
    TILE_WALL_NORTH_WEST (24),
    TILE_WALL_SOUTH_WEST(32),

    TILE_WALL_EAST (23),
    TILE_WALL_SOUTH (29),
    TILE_WALL_WEST (30),
    TILE_WALL_NORTH (31),

    //TODO PUSHERS
    TILE_PUSHER_DOWN_2_4_6 (1),
    TILE_PUSHER_DOWN_1_3_5 (9),
    TILE_PUSHER_LEFT_2_4_6 (2),
    TILE_PUSHER_LEFT_1_3_5 (10),
    TILE_PUSHER_UP_2_4_6 (11),
    TILE_PUSHER_UP_1_3_5 (3),
    TILE_PUSHER_RIGHT_2_4_6 (4),
    TILE_PUSHER_RIGHT_1_3_5 (12),

    //TODO FAST CONVEOUR BELT
    TILE_CONVEYOR_FAST_NORTH (13),
    TILE_CONVEYOR_FAST_EAST (14),
    TILE_CONVEYOR_FAST_SOUTH (21),
    TILE_CONVEYOR_FAST_WEST (22),

    TILE_CONVEYOR_FAST_WEST_TO_SOUTH (17),
    TILE_CONVEYOR_FAST_SOUTH_TO_EAST (25),
    TILE_CONVEYOR_FAST_EAST_TO_NORTH (26),
    TILE_CONVEYOR_FAST_NORTH_TO_WEST (18),

    TILE_CONVEYOR_FAST_NORTH_TO_EAST (19),
    TILE_CONVEYOR_FAST_EAST_TO_SOUTH (20),
    TILE_CONVEYOR_FAST_SOUTH_TO_WEST (28),
    TILE_CONVEYOR_FAST_WEST_TO_NORTH (27),


    //TODO SLOW CONVEYOUR BELT
    TILE_CONVEYOR_SLOW_NORTH (49),
    TILE_CONVEYOR_SLOW_SOUTH (50),
    TILE_CONVEYOR_SLOW_WEST (51),
    TILE_CONVEYOR_SLOW_EAST (52),

    TILE_CONVEYOR_SLOW_WEST_TO_SOUTH (33),
    TILE_CONVEYOR_SLOW_SOUTH_TO_EAST (41),
    TILE_CONVEYOR_SLOW_EAST_TO_NORTH (42),
    TILE_CONVEYOR_SLOW_NORTH_TO_WEST (34),

    TILE_CONVEYOR_SLOW_NORTH_TO_EAST (35),
    TILE_CONVEYOR_SLOW_EAST_TO_SOUTH (43),
    TILE_CONVEYOR_SLOW_SOUTH_TO_WEST (44),
    TILE_CONVEYOR_SLOW_WEST_TO_NORTH (36);

    public static final int TILE_SIZE = 300;

    private final int tile_ID;


    //Connects each tile with it´s id
    TileType(int tile_ID) {
        this.tile_ID = tile_ID;
    }

    public int getTile_ID() {
        return tile_ID;
    }

    //HashMap for storing the tile values
    private static HashMap<Integer, TileType> tileMap;

    //Looping trough the values from the enum and putting them into the HashMap
    static {
        for (TileType tileType : TileType.values()) {
            tileMap.put(tileType.tile_ID, tileType);
        }
    }

    //Putting
    public static TileType getTileTypeByID (int id) {
        return tileMap.get(id);
    }

}

