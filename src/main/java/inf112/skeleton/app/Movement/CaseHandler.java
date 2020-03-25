package inf112.skeleton.app.Movement;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.cards.Direction;
import inf112.skeleton.app.tiles.TileType;

/**
 * @author Fredrik Larsen
 */
public class CaseHandler {

    private static MovementHandler move;


    // If a player is pushed onto a "conveyorbelt-turn" by a conveyorbelt, the player should rotate.
    private static boolean fromConveyorBelt;

    private static boolean canGo;

    public static void tileHandler(Board board, Player player) {


        TileType pushers = TileType.getTileTypeByID(id);

        switch (pushers) {

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
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_180);
                player.setPosY(-1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_SOUTH_TO_EAST:
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_90);
                player.setPosX(1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_EAST_TO_NORTH:
                if(fromConveyorBelt)
                    Direction.rotateRight(Direction.NORTH);
                player.setPosY(1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_NORTH_TO_WEST:
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_270);
                player.setPosX(-1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_EAST_TO_SOUTH:
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_180);
                player.setPosY(-1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_NORTH_TO_EAST:
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_270);
                player.setPosX(-1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_SOUTH_TO_WEST:
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_270);
                player.setPosX(-1);
                fromConveyorBelt = true;
                break;
            case TILE_CONVEYOR_SLOW_WEST_TO_NORTH:
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_270);
                player.setPosX(-1);
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
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_180);
                player.setPosY(-2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_SOUTH_TO_EAST:
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_90);
                player.setPosX(2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_EAST_TO_NORTH:
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_0);
                player.setPosY(2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_NORTH_TO_WEST:
                if(fromConveyorBelt)
                    player.setRotation(TiledMapTileLayer.Cell.ROTATE_270);
                player.setPosY(-2);
                fromConveyorBelt = true;
                break;

            //Pushers
            case TILE_PUSHER_DOWN_1_3_5:
                if((player.getPlayerID * 5) % 10 == 5) {
                    player.setPosY(-1);
                }
                player.setPosY(-1);
                break;

            case TILE_PUSHER_DOWN_2_4_6:
                if((player.getPlayerID * 5) % 10 == 0) {
                    player.setPosY(-1);
                }
                break;

            case TILE_PUSHER_LEFT_1_3_5:
                if((player.getPlayerID * 5) % 10 == 5) {
                    player.setPosX(-1);
                }
                break;

            case TILE_PUSHER_LEFT_2_4_6:
                if((player.getPlayerID * 5) % 10 == 0) {
                    player.setPosX(-1);
                }
                break;

            case TILE_PUSHER_RIGHT_1_3_5:
                if((player.getPlayerID * 5) % 10 == 5) {
                    player.setPosX(1);
                }
                break;

            case TILE_PUSHER_RIGHT_2_4_6:
                if((player.getPlayerID * 5) % 10 == 0) {
                    player.setPosX(1);
                }
                break;

            case TILE_PUSHER_UP_1_3_5:
                if((player.getPlayerID * 5) % 10 == 0) {
                    player.setPosY(1);
                }
                break;

            case TILE_PUSHER_UP_2_4_6:
                if((player.getPlayerID * 5) % 10 == 5) {
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
        }

        public static int outsideBoard (Player player) {
            if (player.getPosX() < 0 || player.getPosY() < 0)
                player.destroyed();
            return;

        }
    }
}
