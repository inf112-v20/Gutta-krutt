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
    private final String[] cards = { "assets/cards/ace_of_clubs.png", "assets/cards/ace_of_diamonds.png", "assets/cards/ace_of_hearts.png",
            "assets/cards/ace_of_spades.png", "assets/cards/joker.png", "assets/cards/king_of_clubs.png", "assets/cards/king_of_diamonds.png",
            "assets/cards/king_of_hearts.png", "assets/cards/king_of_spades.png"};
    //isChosen is a list of the cardindexes of the cards chosen
    private int[] isChosen;
    private Image[] chosenImages;

    public RegisterScreen(GameScreen gameScreen, RoboRally game) {
        this.game = game;
        this.gameScreen = gameScreen;
        stage = new Stage();
        font = new BitmapFont();
        isChosen = new int[5];
        chosenImages = new Image[5];
        initializeIsChosen();
        initializeChosenImages();
        rootTable = new Table();
        cardTable = makeCardTable();
        chosenTable = makeChosenTable();
        rootTable.setFillParent(true);
        rootTable.setDebug(true);
        rootTable.add(cardTable);
        rootTable.row();
        rootTable.add(chosenTable);
        stage.addActor(rootTable);
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
        if (keycode == Input.Keys.G) {
            game.setScreen(gameScreen);
            return true;
        }
        if (keycode == Input.Keys.NUM_1) {
            if (isAlreadyPicked(0)) {
                System.out.println("Cannot pick a card twice.");
            } else {
                String filename = cards[0];
                addCardToChosen(0, filename);
            }
            return true;
        }
        if (keycode == Input.Keys.NUM_2) {
            if (isAlreadyPicked(1)) {
                System.out.println("Cannot pick a card twice");
            } else {
                String filename = cards[1];
                addCardToChosen(1, filename);
            }
            return true;
        }
        if (keycode == Input.Keys.NUM_3) {
            if (isAlreadyPicked(2)) {
                System.out.println("Cannot pick a card twice");
            } else {
                String filename = cards[2];
                addCardToChosen(2, filename);
            }
            return true;
        }
        if (keycode == Input.Keys.NUM_4) {
            if (isAlreadyPicked(3)) {
                System.out.println("Cannot pick a card twice");
            } else {
                String filename = cards[3];
                addCardToChosen(3, filename);
            }
            return true;
        }
        if (keycode == Input.Keys.NUM_5) {
            if (isAlreadyPicked(4)) {
                System.out.println("Cannot pick a card twice");
            } else {
                String filename = cards[4];
                addCardToChosen(4, filename);
            }
            return true;
        }
        if (keycode == Input.Keys.NUM_6) {
            if (isAlreadyPicked(5)) {
                System.out.println("Cannot pick a card twice");
            } else {
                String filename = cards[5];
                addCardToChosen(5, filename);
            }
            return true;
        }
        if (keycode == Input.Keys.NUM_7) {
            if (isAlreadyPicked(6)) {
                System.out.println("Cannot pick a card twice");
            } else {
                String filename = cards[6];
                addCardToChosen(6, filename);
            }
            return true;
        }
        if (keycode == Input.Keys.NUM_8) {
            if (isAlreadyPicked(7)) {
                System.out.println("Cannot pick a card twice");
            } else {
                String filename = cards[7];
                addCardToChosen(7, filename);
            }
            return true;
        }
        if (keycode == Input.Keys.NUM_9) {
            if (isAlreadyPicked(8)) {
                System.out.println("Cannot pick a card twice");
            } else {
                String filename = cards[8];
                addCardToChosen(8, filename);
            }
            return true;
        }
        if (keycode == Input.Keys.R) {
            removeCard();
        }
        if (keycode == Input.Keys.L) {
            for (int i = 0; i < 5; i++) {
                if (isChosen[i] == -1) {
                    System.out.println("Pick 5 cards to lock in");
                    return true;
                }
            }
            game.setScreen(gameScreen);
        }
        return false;
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
        for (String filename : cards) {
            Drawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture(filename)));
            Image card = new Image(drawable);
            tableForCards.add(card).pad(10);
        }
        tableForCards.pad(20);
        return tableForCards;
    }

    /**
     * checks if a any cardsa are chosen, if they are they will show up, otherwise a placeholder is shown
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
     * can be used to initialize or reset isChosen boolean list.
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
     * @param filename filepath to picture of chosen card.
     */
    public void addCardToChosen(int cardIndex, String filename) {
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
        Drawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture(filename)));
        Image chosenCard = new Image(drawable);

        isChosen[slot] = cardIndex;
        chosenImages[slot] = chosenCard;

        newChosenTable.add(chosenCard).pad(10);
        newChosenTable = makeChosenTable();
        newChosenTable.pad(20);

        chosenTable = newChosenTable;

        rootTable.row();
        rootTable.add(newChosenTable);
    }

    public Image[] getChosenImages() {
        return chosenImages;
    }
}
