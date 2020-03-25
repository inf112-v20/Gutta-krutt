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
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import inf112.skeleton.app.RoboRally;
import inf112.skeleton.app.cards.Card;

/**
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
    private Card card;
    private Label label;
    private Label.LabelStyle labelStyle;
    private Skin skin;
    private final String[] cards = { "assets/cards/ace_of_clubs.png", "assets/cards/ace_of_diamonds.png", "assets/cards/ace_of_hearts.png",
            "assets/cards/ace_of_spades.png", "assets/cards/joker.png", "assets/cards/king_of_clubs.png", "assets/cards/king_of_diamonds.png",
            "assets/cards/king_of_hearts.png", "assets/cards/king_of_spades.png"};

    public RegisterScreen(GameScreen gameScreen, RoboRally game) {
        this.game = game;
        this.gameScreen = gameScreen;
        stage = new Stage();
        font = new BitmapFont();
        rootTable = new Table();
        cardTable = new Table();
        chosenTable = new Table();
    }
    //todo
    //adde filename til card?? Problemet blir da at man vil trenge et bilde til hvert kort.
    //Kanskje prvøe å lage en priority over. Kan enkelt lage pilkort med noe tekst.
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);

        //card = new Card(2, 100, 2);
        font.setColor(Color.RED);
        //int distance = card.getDistance();
        //String labelString = Integer.toString(distance);

        rootTable.setFillParent(true);
        rootTable.setDebug(true);

        for (String filename : cards) {
            Drawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture(filename)));
            ImageButton card = new ImageButton(drawable);
            cardTable.add(card).pad(10);
        }
        cardTable.pad(20);

        for (int i = 0; i < 5; i++) {
            Drawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture("assets/cards/not_chosen_card.png")));
            ImageButton chosenCard = new ImageButton(drawable);
            chosenTable.add(chosenCard).pad(10);
        }
        chosenTable.pad(20);
        chosenTable.padTop(20);

        rootTable.add(cardTable);
        rootTable.row();
        rootTable.add(chosenTable);
        stage.addActor(rootTable);



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
        return false;
    }
}
