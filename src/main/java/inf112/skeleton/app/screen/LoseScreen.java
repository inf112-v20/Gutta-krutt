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

public class LoseScreen implements Screen {

    private Stage stage;
    private BitmapFont font;
    private Table youLostTable;

    public LoseScreen() {
        stage = new Stage();
        font = new BitmapFont();
        youLostTable = makeYouLostTable();
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
        font.dispose();
    }

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
