package inf112.skeleton.app.Player;

import inf112.skeleton.app.Movement.MovementHandler;
import inf112.skeleton.app.cards.Card;

/**
 * @author Oskar Marthinussen
 */
public class PlayerMovementHandlerPair {
    private MovementHandler movementHandler;
    private Card card;

    public PlayerMovementHandlerPair(MovementHandler movementHandler, Card card){
        this.movementHandler = movementHandler;
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public MovementHandler getMovementHandler() {
        return movementHandler;
    }
}
