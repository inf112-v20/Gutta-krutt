package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import inf112.skeleton.app.player.Player;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.cards.Card;
import inf112.skeleton.app.cards.Deck;

import java.util.ArrayList;

/**
 * The screen is built up of a stage containing a root table and two tables inside the root table. One table for the cards to chose from and
 * one table for the cards you chose. When you chose a card the chosen table is removed from the root table, updated and added to the root
 * table again. This is how most of the functions that change the chosen table work.
 *
 * Choose numbers between 1-9 to chose cards, R to remove cards and G to go back to the GameScreen.
 *
 * @author Vegard Birkenes
 */
public class RegisterScreen extends InputAdapter implements Screen {

    private final GameScreen gameScreen;
    private final RoboRally game;
    private final Player player;
    private final Stage stage;
    private final BitmapFont font;
    private Table chosenTable;
    private final Table rootTable;
    private final Deck deck;
    private final ArrayList<Card> cards;
    //isChosen is a list of the cardindexes of the cards chosen
    private final int[] isChosen;
    private Boolean[] isLocked;
    private Image[] chosenImages;
    private ArrayList<Card> chosenCards;

    public RegisterScreen(GameScreen gameScreen, RoboRally game, Player player) {
        this.game = game;
        this.gameScreen = gameScreen;
        this.player = player;
        stage = new Stage();
        font = new BitmapFont();
        isChosen = new int[5];
        isLocked = new Boolean[5];
        chosenImages = new Image[5];
        chosenCards = new ArrayList<>();
        initializeIsChosenAndIsLocked();
        initializeChosenImages();
        rootTable = new Table();
        deck = new Deck();
        cards = new ArrayList<>();
        Table cardTable = makeCardTable(player.getCurrentHealth()-1);
        chosenTable = makeChosenTable();
        Table priorityTable = makePriorityTable();
        rootTable.setFillParent(true);
        rootTable.add(priorityTable);
        rootTable.row();
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
        //empty method body
    }

    @Override
    public void pause() {
        //empty method body
    }

    @Override
    public void resume() {
        //empty method body
    }

    @Override
    public void hide() {
        //empty method body
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
            return true;
        }
        else if (keycode == Input.Keys.R) {
            removeCard();
            return true;
        }
        else if (keycode == Input.Keys.L) {
            for (int i = 0; i < 5; i++) {
                if (isChosen[i] == -1) {
                    System.out.println("Pick more cards to lock in");
                    return true;
                }
            }
            gameScreen.setRegisterScreen(new RegisterScreen(gameScreen, game, player));
            game.setScreen(gameScreen);
            game.executeCards(chosenCards);
            return true;
        }
        else if (keycode == Input.Keys.P) {
            player.powerDown();
            System.out.println("Player announces powerdown");
            game.setScreen(gameScreen);
            return true;
        }
        if (isAlreadyPicked(indexOfChosen)) {
            System.out.println("Cannot pick a card twice.");
            return true;
        }
        if (indexOfChosen > cards.size()-1) {
            System.out.println("There is no card corresponding to the chosen index");
        }
        else if (indexOfChosen > -1) {
            addCardToChosen(indexOfChosen, cards.get(indexOfChosen));
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
     * Makes a table showing the priorities of the cards.
     * @return Table consisting of priorities of the cards.
     */
    public Table makePriorityTable() {
        Table rootPriorityTable = new Table();
        Table priorityTable = new Table();
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = font;
        style.fontColor = Color.RED;
        for (Card card : cards) {
            int priority = card.getPriority();
            String priorityString = Integer.toString(priority);
            TextField text = new TextField(priorityString, style);
            text.setAlignment(Align.center);
            priorityTable.add(text).width(90).height(20).pad(10);
        }
        rootPriorityTable.add(makePriorityHeadline()).height(70);
        rootPriorityTable.row();
        rootPriorityTable.add(priorityTable);
        rootPriorityTable.pad(20);
        return rootPriorityTable;
    }

    /**
     * Uses textfield inside a table in order to write a headline for the priorities.
     * @return table with the headline for priorities
     */
    public Table makePriorityHeadline() {
        Table headline = new Table();
        BitmapFont headlineFont = new BitmapFont();
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = headlineFont;
        style.fontColor = Color.RED;
        headlineFont.getData().setScale(2);
        TextField text = new TextField("Priority", style);
        text.setAlignment(Align.center);
        headline.add(text);
        return headline;
    }

    /**
     * visually makes a table of cards
     * @return a table of cards to chose from
     */
    public Table makeCardTable(int health) {
        Table rootCardTable = new Table();
        Table tableForCards = new Table();
        int cardsToDeal = health;
        if (health <= 5) {
            cardsToDeal = 5;
        }
        for (int i = 0; i < cardsToDeal; i++) {
            Card card = deck.randomCard();
            cards.add(card);
            Image cardImage = new Image(new TextureRegionDrawable(new Texture(card.getFilepath())));
            tableForCards.add(cardImage).width(90).height(120).pad(10);
        }
        rootCardTable.add(tableForCards);
        rootCardTable.row();
        rootCardTable.add(makeNumberHeadline(health));
        rootCardTable.pad(20);
        return rootCardTable;
    }

    /**
     * Makes a headline over the cards to choose from to make the registerscreen more user-friendly
     * @param numberOfCards amount of cards needed
     * @return A table with numbers corresponding to the cards you can choose between
     */
    public Table makeNumberHeadline(int numberOfCards) {
        Table headline = new Table();
        BitmapFont headlineFont = new BitmapFont();
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = headlineFont;
        style.fontColor = Color.BROWN;
        for (int i = 1; i <= numberOfCards; i++) {
            String number = Integer.toString(i);
            TextField text = new TextField(number, style);
            text.setAlignment(Align.center);
            headline.add(text).width(90).height(10).pad(10);
        }
        return headline;
    }

    /**
     * Checks if a any cards are chosen, if they are they will show up, otherwise a placeholder is shown.
     * Locks cards if player has taken more than 4 damage.
     * @return a table of chosen cards
     */
    public Table makeChosenTable() {
        Table newChosenCards = new Table();
        int amountOfCardsToChoose = 5;
        int lockedCardHolders = 0;
        if (player.getDamageTaken() >= 5) {
            amountOfCardsToChoose = player.getCurrentHealth()-1;
            lockedCardHolders = 5 - amountOfCardsToChoose;
        }
        for (int i = 0; i < amountOfCardsToChoose; i++) {
            if (isChosen[i] > -1) {
                newChosenCards.add(chosenImages[i]).pad(10);
            } else {
                Image chosenCard = new Image(new TextureRegionDrawable(new TextureRegion(new Texture("assets/cards/not_chosen_card.png"))));
                newChosenCards.add(chosenCard).pad(10);
            }
        }
        for (int i = 0; i < lockedCardHolders; i++) {
            Image lockedCardholder = new Image(new TextureRegionDrawable(new TextureRegion(new Texture("assets/cards/lock.png"))));
            newChosenCards.add(lockedCardholder).pad(10);
            isLocked[4-i] = true;
            isChosen[4-i] = 10;
        }
        newChosenCards.pad(20);
        return newChosenCards;
    }

    /**
     * Is used to initialize isChosen and isLocked
     */
    public void initializeIsChosenAndIsLocked() {
        for (int i = 0; i < 5; i++) {
            isChosen[i] = -1;
            isLocked[i] = false;
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
                if (isChosen[i] > 9) {
                    continue;
                }
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
        chosenCards.remove(chosenCards.size()-1);
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
        if (isLocked[slot]) {
            System.out.println("Can´t add more cards, the rest are locked");
            return;
        }
        //Removes the table of chosen cards
        rootTable.removeActor(chosenTable);

        //Makes the card with given cardIndex
        Table newChosenTable = new Table();
        Image cardImage = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(card.getFilepath()))));

        isChosen[slot] = cardIndex;
        chosenCards.add(card);
        chosenImages[slot] = cardImage;

        newChosenTable.add(cardImage).pad(10);
        newChosenTable = makeChosenTable();
        newChosenTable.pad(20);

        chosenTable = newChosenTable;

        rootTable.row();
        rootTable.add(newChosenTable);
    }
}
