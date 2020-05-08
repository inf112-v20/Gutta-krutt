package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;

/**
 * Just a basic "Lose" screen to display when a player either dies or loses the game.
 */
public class LoseScreen implements Screen {

    private Stage stage;
    private BitmapFont font;

    public LoseScreen() {
        stage = new Stage();
        font = new BitmapFont();
        Table youLostTable = makeYouLostTable();
        youLostTable.setFillParent(true);
        stage.addActor(youLostTable);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
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
        font.dispose();
    }

    /**
     * Displays a "you lose" text on the screen
     * @return table containing the text
     */
    public Table makeYouLostTable() {
        Table youLostTable = new Table();
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = font;
        style.fontColor = Color.RED;
        font.getData().setScale(3);
        TextField text = new TextField("You lose!", style);
        text.setAlignment(Align.center);
        youLostTable.add(text).width(500);
        return youLostTable;
    }
}
