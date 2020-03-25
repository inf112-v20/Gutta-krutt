package inf112.skeleton.app.Movement;


import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.cards.Direction;
import inf112.skeleton.app.tiles.TileType;

/**
 * @author Fredrik Larsen
 */
public class CaseHandler {

    private static int Tile_ID;

    // If a player is pushed onto a "conveyorbelt-turn" by a conveyorbelt, the player should rotate.
    private static boolean fromConveyorBelt;

    private static boolean canGo;

    public static void tileHandler(Board board, Player player) {


        TileType boardObjects = TileType.getTileTypeByID(Tile_ID);
        switch (boardObjects) {

            //Repair and upgrade
            case TILE_WRENCH:
                player.repairRoot();
                break;

            case TILE_WRENCH_HAMMER:
                player.repairRoot();
                player.repairRoot();
                break;

            //Holes
            case TILE_HOLE1:
            case TILE_HOLE2:
            case TILE_HOLE3:
            case TILE_HOLE4:
            case TILE_HOLE5:
            case TILE_HOLE6:
            case TILE_HOLE7:
            case TILE_HOLE8:
            case TILE_HOLE9:
            case TILE_HOLE10:
            case TILE_HOLE11:
            case TILE_HOLE12:
            case TILE_HOLE13:
            case TILE_HOLE14:
            case TILE_HOLE15:
                player.destroyed();
                break;

            //Flags
            case TILE_FLAG_1:
                break;
            case TILE_FLAG_2:
                break;
            case TILE_FLAG_3:
                break;
            case TILE_FLAG_4:
                break;

            //Walls
            case TILE_WALL_EAST:
                break;
            case TILE_WALL_WEST:
                break;
            case TILE_WALL_NORTH:

            case TILE_WALL_SOUTH:

            case TILE_WALL_NORTH_EAST:

            case TILE_WALL_NORTH_WEST:

            case TILE_WALL_SOUTH_EAST:

            case TILE_WALL_SOUTH_WEST:

                // Cogwheel
            case TILE_GEAR_GREEN:
                Direction.rotateRight(player.getDir());
                break;

            case TILE_GEAR_RED:
                Direction.rotateLeft(player.getDir());
                break;

            // The slow conveyorbelts
            case TILE_CONVEYOR_SLOW_NORTH:
                player.setPosY(1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_SOUTH:
                player.setPosY(-1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_WEST:
                player.setPosX(1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_EAST:
                player.setPosX(-1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_WEST_TO_SOUTH:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                player.setPosY(-1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_SOUTH_TO_EAST:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                player.setPosX(1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_EAST_TO_NORTH:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                player.setPosY(1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_NORTH_TO_WEST:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                player.setPosX(-1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_EAST_TO_SOUTH:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                player.setPosY(-1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_NORTH_TO_EAST:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                player.setPosX(1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_SOUTH_TO_WEST:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                player.setPosX(-1);
                fromConveyorBelt = true;
                break;
            case TILE_CONVEYOR_SLOW_WEST_TO_NORTH:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                player.setPosY(1);
                fromConveyorBelt = true;
                break;

            // The fast conveyor belts
            case TILE_CONVEYOR_FAST_NORTH:
                player.setPosY(2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_SOUTH:
                player.setPosY(-2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_WEST:
                player.setPosX(-2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_EAST:
                player.setPosX(2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_WEST_TO_SOUTH:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                player.setPosY(-2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_SOUTH_TO_EAST:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                player.setPosX(2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_EAST_TO_NORTH:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                player.setPosY(2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_NORTH_TO_WEST:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                player.setPosX(-2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_EAST_TO_SOUTH:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                player.setPosY(-2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_NORTH_TO_EAST:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                player.setPosX(2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_SOUTH_TO_WEST:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                player.setPosX(-2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_WEST_TO_NORTH:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                player.setPosY(2);
                fromConveyorBelt = true;
                break;


            //Pushers
            case TILE_PUSHER_DOWN_1_3_5:
                if ((player.getPlayerID * 5) % 10 == 5) {
                    player.setPosY(-1);
                }
                player.setPosY(-1);
                break;

            case TILE_PUSHER_DOWN_2_4_6:
                if ((player.getPlayerID * 5) % 10 == 0) {
                    player.setPosY(-1);
                }
                break;

            case TILE_PUSHER_LEFT_1_3_5:
                if ((player.getPlayerID * 5) % 10 == 5) {
                    player.setPosX(-1);
                }
                break;

            case TILE_PUSHER_LEFT_2_4_6:
                if ((player.getPlayerID * 5) % 10 == 0) {
                    player.setPosX(-1);
                }
                break;

            case TILE_PUSHER_RIGHT_1_3_5:
                if ((player.getPlayerID * 5) % 10 == 5) {
                    player.setPosX(1);
                }
                break;

            case TILE_PUSHER_RIGHT_2_4_6:
                if ((player.getPlayerID * 5) % 10 == 0) {
                    player.setPosX(1);
                }
                break;

            case TILE_PUSHER_UP_1_3_5:
                if ((player.getPlayerID * 5) % 10 == 0) {
                    player.setPosY(1);
                }
                break;

            case TILE_PUSHER_UP_2_4_6:
                if ((player.getPlayerID * 5) % 10 == 5) {
                    player.setPosY(1);
                }
                break;

            // Lasers
            case TILE_LASER_SINGLE_HORIZONTAL:
            case TILE_LASER_SINGLE_VERTICAL:
            case TILE_LASER_SINGLE_WALL_EAST:
            case TILE_LASER_SINGLE_WALL_NORTH:
            case TILE_LASER_SINGLE_WALL_SOUTH:
            case TILE_LASER_SINGLE_WALL_WEST:
                player.takeDamage(1);

            case TILE_LASER_DOUBLE_HORIZONTAL:
            case TILE_LASER_DOUBLE_VERTICAL:
            case TILE_LASER_DOUBLE_WALL_EAST:
            case TILE_LASER_DOUBLE_WALL_NORTH:
            case TILE_LASER_DOUBLE_WALL_SOUTH:
            case TILE_LASER_DOUBLE_WALL_WEST:
            case TILE_LASER_SINGLE_CROSS:
                player.takeDamage(2);
                break;

            case TILE_LASER_DOUBLE_CROSS:
                player.takeDamage(4);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + boardObjects);
        }
    }

    //TODO
    public static boolean outsideGrid (Player player){
        if (player.getPosX() < 0 || 0 > player.getPosY())
            return true;
        return false;
    }
}
