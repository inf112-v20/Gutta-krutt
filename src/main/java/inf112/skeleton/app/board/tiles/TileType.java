package inf112.skeleton.app.board.tiles;

public enum TileType {

    TILE_GROUND (1),
    TILE_HOLE (2),

    //Slow conveyor belt
    TILE_CONVEYOR_SLOW (3),
    TILE_CONVEYOR_SLOW_TURN_RIGHT (4),
    TILE_CONVEYOR_SLOW_TURN_LEFT (5),

    //Fast conveyor belt
    TILE_CONVEYOR_FAST (6),
    TILE_CONVEYOR_FAST_TURN_RIGHT (7),
    TILE_CONVEYOR_FAST_TURN_LEFT (8),

    //The flags
    TILE_FLAG_1 (9),
    TILE_FLAG_2 (10),
    TILE_FLAG_3 (11),

    //Start positions
    TILE_START_POS_1 (12),
    TILE_START_POS_2 (13),
    TILE_START_POS_3 (14),
    TILE_START_POS_4 (15);

    private final int tileID;

    TileType(int tileID) {
        this.tileID = tileID;
    }
}
