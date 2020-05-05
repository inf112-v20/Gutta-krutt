package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;

public class WinScreen extends InputAdapter implements Screen  {

    private Stage stage;
    private BitmapFont font;

    public WinScreen() {
        stage = new Stage();
        font = new BitmapFont();
        font.getData().setScale(4);
        Table table = new Table();
        TextField textField = makeTextField();
        //TextButton textButton = makeTextButton();
        table.setFillParent(true);
        table.add(textField).width(1000);
        table.row();
        //table.add(textButton);
        stage.addActor(table);
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
        font.dispose();
    }

    public TextField makeTextField() {
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = font;
        style.fontColor = Color.RED;
        TextField text = new TextField("Congratulations, you win!", style);
        text.setAlignment(Align.center);
        return text;
    }


}
