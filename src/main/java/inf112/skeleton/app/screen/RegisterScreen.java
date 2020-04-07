package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.cards.Card;
import inf112.skeleton.app.cards.Deck;

/**
 * The screen is built up of a stage containing a root table and two tables inside the root table. One table for the cards to chose from and
 * one table for the cards you chose. When you chose a card the chosen table is removed from the root table, updated and added to the root
 * table again. This is how most of the functions that change the chosen table work.
 *
 * Choose numbers between 1-9 to chose cards, R to remove cards and G to go back to the GameScreen.
 *
 * @author vegardbirkenes
 */
public class RegisterScreen extends InputAdapter implements Screen {

    private GameScreen gameScreen;
    private RoboRally game;
    private Stage stage;
    private BitmapFont font;
    private Table cardTable;
    private Table chosenTable;
    private Table rootTable;
    private Deck deck;
    private final Card[] cards;
    //isChosen is a list of the cardindexes of the cards chosen
    private int[] isChosen;
    private Image[] chosenImages;
    private Card[] chosenCards;

    public RegisterScreen(GameScreen gameScreen, RoboRally game) {
        this.game = game;
        this.gameScreen = gameScreen;
        stage = new Stage();
        font = new BitmapFont();
        isChosen = new int[5];
        chosenImages = new Image[5];
        chosenCards = new Card[5];
        initializeIsChosen();
        initializeChosenImages();
        rootTable = new Table();
        deck = new Deck();
        cards = new Card[9];
        cardTable = makeCardTable();
        chosenTable = makeChosenTable();
        rootTable.setFillParent(true);
        rootTable.setDebug(true);
        rootTable.add(cardTable);
        rootTable.row();
        rootTable.add(chosenTable);
        stage.addActor(rootTable);
    }

    /**
     * @return returns the chosen cards.
     */
    public Card[] getChosenCards() {
        return chosenCards;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor( 110/255F, 110/255F ,110/255F, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public boolean keyUp(int keycode) {
        int indexOfChosen = -1;
        if (keycode == Input.Keys.NUM_1) {
            indexOfChosen = 0;
        }
        else if (keycode == Input.Keys.NUM_2) {
            indexOfChosen = 1;
        }
        else if (keycode == Input.Keys.NUM_3) {
            indexOfChosen = 2;
        }
        else if (keycode == Input.Keys.NUM_4) {
            indexOfChosen = 3;
        }
        else if (keycode == Input.Keys.NUM_5) {
            indexOfChosen = 4;
        }
        else if (keycode == Input.Keys.NUM_6) {
            indexOfChosen = 5;
        }
        else if (keycode == Input.Keys.NUM_7) {
            indexOfChosen = 6;
        }
        else if (keycode == Input.Keys.NUM_8) {
            indexOfChosen = 7;
        }
        else if (keycode == Input.Keys.NUM_9) {
            indexOfChosen = 8;
        }
        else if (keycode == Input.Keys.G) {
            game.setScreen(gameScreen);
        }
        else if (keycode == Input.Keys.R) {
            removeCard();
        }
        else if (keycode == Input.Keys.L) {
            for (int i = 0; i < 5; i++) {
                if (isChosen[i] == -1) {
                    System.out.println("Pick 5 cards to lock in");
                    return true;
                }
            }
            game.setScreen(gameScreen);
        }

        if (isAlreadyPicked(indexOfChosen)) {
            System.out.println("Cannot pick a card twice.");
        }
        else if (indexOfChosen > -1) {
            addCardToChosen(indexOfChosen, cards[indexOfChosen]);
        }
        return true;
    }

    /**
     * checks if a card is already picked
     * @param cardIndex the index of the chosen card
     * @return true if already chosen, false otherwise
     */
    public boolean isAlreadyPicked(int cardIndex) {
        for (int i = 0; i < 5; i++) {
            if (isChosen[i] == cardIndex) {
                return true;
            }
        }
        return false;
    }

    /**
     * visually makes a table of cards
     * @return a table of cards to chose from
     */
    public Table makeCardTable() {
        Table tableForCards = new Table();
        for (int i = 0; i < 9; i++) {
            Card card = deck.randomCard();
            cards[i] = card;
            Image cardImage = new Image(new TextureRegionDrawable(new Texture(card.getFilepath())));
            tableForCards.add(cardImage).pad(10);
        }
        tableForCards.pad(20);
        return tableForCards;
    }

    /**
     * checks if a any cards are chosen, if they are they will show up, otherwise a placeholder is shown
     * @return a table of chosen cards
     */
    public Table makeChosenTable() {
        Table newChosenCards = new Table();
        for (int i = 0; i < 5; i++) {
            if (isChosen[i] > -1) {
                newChosenCards.add(chosenImages[i]).pad(10);
            } else {
                Drawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture("assets/cards/not_chosen_card.png")));
                Image chosenCard = new Image(drawable);
                newChosenCards.add(chosenCard).pad(10);
            }
        }
        newChosenCards.pad(20);
        return newChosenCards;
    }

    /**
     * can be used to initialize or reset isChosen index list.
     */
    public void initializeIsChosen() {
        for (int i = 0; i < 5; i++) {
            isChosen[i] = -1;
        }
    }

    /**
     * Initializes the chosen table to placeholder cards.
     */
    public void initializeChosenImages() {
        for (int i = 0; i < 5; i++) {
            Drawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture("assets/cards/not_chosen_card.png")));
            Image chosenCard = new Image(drawable);
            chosenImages[i] = chosenCard;
        }
    }

    /**
     * removes the card that was added last
     */
    public void removeCard() {
        int removeIndex = -1;
        for (int i = 4; i >= 0 ; i--) {
            if (isChosen[i] > -1) {
                removeIndex = i;
                break;
            }
        }
        if (removeIndex == -1) {
            System.out.println("No cards to remove");
            return;
        }
        rootTable.removeActor(chosenTable);
        isChosen[removeIndex] = -1;
        Table newChosenTable = makeChosenTable();
        newChosenTable.pad(20);
        chosenTable = newChosenTable;
        rootTable.row();
        rootTable.add(newChosenTable);
    }

    /**
     * Adds a card to the chosen table.
     * @param cardIndex index of chosen card
     * @param card chosen card
     */
    public void addCardToChosen(int cardIndex, Card card) {
        int slot = -1;
        for (int i = 0; i < 5; i++) {
            if (isChosen[i] == -1) {
                slot = i;
                break;
            }
        }
        if (slot == -1) {
            System.out.println("Cant add more cards to the sequence");
            return;
        }

        //Removes the table of chosen cards
        rootTable.removeActor(chosenTable);

        //Makes the card with given cardIndex
        Table newChosenTable = new Table();
        Image cardImage = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(card.getFilepath()))));

        isChosen[slot] = cardIndex;
        chosenCards[slot] = card;
        chosenImages[slot] = cardImage;

        newChosenTable.add(cardImage).pad(10);
        newChosenTable = makeChosenTable();
        newChosenTable.pad(20);

        chosenTable = newChosenTable;

        rootTable.row();
        rootTable.add(newChosenTable);
    }
}
