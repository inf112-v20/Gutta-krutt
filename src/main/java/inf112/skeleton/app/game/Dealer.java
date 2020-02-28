package inf112.skeleton.app.game;

public class Dealer {

    private int numberOfPlayers; // Number of players
    private int numberOfCards; // Number of cards to be dealt


    public Dealer(int players) {
        this.numberOfPlayers = players;
    }

    public void draw(int cards) {
        this.numberOfCards = cards;
    }

    public void dealer() {
        for(int p = 0; p < numberOfPlayers; p++){
            for (int c = 0; c < numberOfCards; c++){

            }
        }

    }

}
