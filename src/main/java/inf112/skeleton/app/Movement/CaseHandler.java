package inf112.skeleton.app.Movement;


import com.badlogic.gdx.graphics.g3d.particles.ParticleSorter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Player.Player;
import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.cards.Direction;
import inf112.skeleton.app.tiles.TileType;
import org.graalvm.compiler.lir.sparc.SPARCMove;

import java.lang.management.PlatformLoggingMXBean;
import java.util.HashMap;

/**
 * @author Fredrik Larsen
 */
public class CaseHandler {

    private MovementHandler movementHandlerhandler;
    private Player player;
    private TiledMap board;
    private static int Tile_ID;

    public CaseHandler(MovementHandler movementHandler, Player player, TiledMap board) {
        this.player = player;
        this.board = board;
        this.movementHandlerhandler = new MovementHandler(player, board);
    }


    // If a player is pushed onto a "conveyorbelt-turn" by a conveyorbelt, the player should rotate.
    private static boolean fromConveyorBelt = false;

    public void tileHandler() {

        TileType evenSequence = TileType.getTileTypeByID(Tile_ID);
        TileType oddSequence = TileType.getTileTypeByID(Tile_ID);
        TileType allSequences = TileType.getTileTypeByID(Tile_ID);

        switch (oddSequence) {
            case TILE_PUSHER_DOWN_1_3_5:
                movementHandlerhandler.moveSteps(Direction.SOUTH,1);
                break;

            case TILE_PUSHER_LEFT_1_3_5:
                movementHandlerhandler.moveSteps(Direction.WEST,1);
                break;

            case TILE_PUSHER_RIGHT_1_3_5:
                movementHandlerhandler.moveSteps(Direction.EAST,1);
                break;

            case TILE_PUSHER_UP_1_3_5:
                movementHandlerhandler.moveSteps(Direction.NORTH,1);
                break;
        }

        switch (evenSequence) {
            case TILE_PUSHER_DOWN_2_4:
                movementHandlerhandler.moveSteps(Direction.SOUTH,1);
                break;

            case TILE_PUSHER_LEFT_2_4:
                movementHandlerhandler.moveSteps(Direction.WEST,1);
                break;

            case TILE_PUSHER_RIGHT_2_4:
                movementHandlerhandler.movePlayer(Direction.EAST);
                break;

            case TILE_PUSHER_UP_2_4:
                movementHandlerhandler.moveSteps(Direction.NORTH,1);
                break;
        }

        switch (allSequences) {
            //Repair and upgrade
            case TILE_WRENCH:
                player.repairRobot(1);
                break;

            case TILE_WRENCH_HAMMER:
                player.repairRobot(2);
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

            // Cogwheel
            case TILE_GEAR_GREEN:
                Direction.rotateRight(player.getDir());
                break;

            case TILE_GEAR_RED:
                Direction.rotateLeft(player.getDir());
                break;

            // The slow conveyorbelts
            case TILE_CONVEYOR_SLOW_NORTH:
                movementHandlerhandler.moveSteps(Direction.NORTH,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_SOUTH:
                movementHandlerhandler.moveSteps(Direction.SOUTH,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_WEST:
                movementHandlerhandler.moveSteps(Direction.WEST,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_EAST:
                movementHandlerhandler.moveSteps(Direction.EAST,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_WEST_TO_SOUTH:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                movementHandlerhandler.moveSteps(Direction.SOUTH,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_SOUTH_TO_EAST:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                movementHandlerhandler.moveSteps(Direction.EAST,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_EAST_TO_NORTH:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                movementHandlerhandler.moveSteps(Direction.NORTH,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_NORTH_TO_WEST:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                movementHandlerhandler.moveSteps(Direction.WEST,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_EAST_TO_SOUTH:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                movementHandlerhandler.moveSteps(Direction.SOUTH,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_NORTH_TO_EAST:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                movementHandlerhandler.moveSteps(Direction.EAST,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_SOUTH_TO_WEST:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                movementHandlerhandler.moveSteps(Direction.WEST,1);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_SLOW_WEST_TO_NORTH:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                movementHandlerhandler.moveSteps(Direction.NORTH,1);
                fromConveyorBelt = true;
                break;

            // The fast conveyor belts
            case TILE_CONVEYOR_FAST_NORTH:
                movementHandlerhandler.moveSteps(Direction.NORTH,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_SOUTH:
                movementHandlerhandler.moveSteps(Direction.SOUTH,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_WEST:
                movementHandlerhandler.moveSteps(Direction.WEST,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_EAST:
                movementHandlerhandler.moveSteps(Direction.EAST,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_WEST_TO_SOUTH:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                movementHandlerhandler.moveSteps(Direction.SOUTH,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_SOUTH_TO_EAST:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                movementHandlerhandler.moveSteps(Direction.EAST,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_EAST_TO_NORTH:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                movementHandlerhandler.moveSteps(Direction.NORTH,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_NORTH_TO_WEST:
                if (fromConveyorBelt)
                    Direction.rotateLeft(player.getDir());
                movementHandlerhandler.moveSteps(Direction.WEST,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_EAST_TO_SOUTH:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                movementHandlerhandler.moveSteps(Direction.SOUTH,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_NORTH_TO_EAST:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                movementHandlerhandler.moveSteps(Direction.EAST,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_SOUTH_TO_WEST:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                movementHandlerhandler.moveSteps(Direction.WEST,2);
                fromConveyorBelt = true;
                break;

            case TILE_CONVEYOR_FAST_WEST_TO_NORTH:
                if (fromConveyorBelt)
                    Direction.rotateRight(player.getDir());
                movementHandlerhandler.moveSteps(Direction.NORTH,2);
                fromConveyorBelt = true;
                break;

            // Laser
            case TILE_LASER_SINGLE_WALL_EAST:
            case TILE_LASER_SINGLE_WALL_NORTH:
            case TILE_LASER_SINGLE_WALL_SOUTH:
            case TILE_LASER_SINGLE_WALL_WEST:
            case TILE_LASER_SINGLE_HORIZONTAL:
            case TILE_LASER_SINGLE_VERTICAL:
                player.takeDamage(1);
                break;

            case TILE_LASER_DOUBLE_HORIZONTAL:
            case TILE_LASER_DOUBLE_VERTICAL:
            case TILE_LASER_SINGLE_CROSS:
            case TILE_LASER_DOUBLE_WALL_EAST:
            case TILE_LASER_DOUBLE_WALL_NORTH:
            case TILE_LASER_DOUBLE_WALL_SOUTH:
            case TILE_LASER_DOUBLE_WALL_WEST:
                player.takeDamage(2);
                break;

            case TILE_LASER_DOUBLE_CROSS:
                player.takeDamage(4);
                break;
        }
    }

    public boolean outsideGrid (Player player){
        if (player.getPosX() < 0 || 12 < player.getPosX())
            return true;
        else if (player.getPosY() < 0 || 12 < player.getPosY())
            return true;
        return false;
    }
}
