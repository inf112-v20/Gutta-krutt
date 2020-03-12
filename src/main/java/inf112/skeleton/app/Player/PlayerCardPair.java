package inf112.skeleton.app.Player;

import inf112.skeleton.app.cards.Card;

public class PlayerCardPair {
    private int playerID;
    private Card card;

    public PlayerCardPair(int playerID, Card card){
        this.playerID = playerID;
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public int getPlayerID() {
        return playerID;
    }
}
