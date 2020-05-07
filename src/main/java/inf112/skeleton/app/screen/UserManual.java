package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;
import inf112.skeleton.app.RoboRally;

public class UserManual extends InputAdapter implements Screen {

    private GameScreen gameScreen;
    private RoboRally game;
    private BitmapFont font;
    private Stage stage;

    public UserManual(GameScreen gameScreen, RoboRally game) {
        this.gameScreen = gameScreen;
        this.game = game;
        font = new BitmapFont();
        stage = new Stage();
        Table instructionTable = writeInstructions();
        instructionTable.setFillParent(true);
        stage.addActor(instructionTable);
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

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.P) {
            game.setScreen(gameScreen);
        }
        return true;
    }

    public Table writeInstructions() {
        Table instructionTable = new Table();
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = font;
        style.fontColor = Color.RED;
        font.getData().setScale(2);
        sentenceToWrite("User manual (press P to return to the game):", instructionTable, style);
        sentenceToWrite("To win the game capture all flags on the board.", instructionTable, style);
        sentenceToWrite("You die if you fall of the board or in a hole.", instructionTable, style);
        sentenceToWrite("You can die three times.", instructionTable, style);
        sentenceToWrite("Press G in the game screen to enter the sequence screen.", instructionTable, style);
        sentenceToWrite("Press L after laying a sequence to execute your chosen cards.", instructionTable, style);
        sentenceToWrite("Press P to announce a powerdown, thereby skipping a turn, ", instructionTable, style);
        sentenceToWrite("but healing to full health.", instructionTable, style);
        sentenceToWrite("Use 1-9 to choose cards and press R to remove a card.", instructionTable, style);
        return instructionTable;
    }

    public Table sentenceToWrite(String string, Table table, TextField.TextFieldStyle style) {
        TextField text = new TextField(string, style);
        text.setAlignment(Align.center);
        table.add(text).width(800);
        table.row();
        return table;
    }
}
