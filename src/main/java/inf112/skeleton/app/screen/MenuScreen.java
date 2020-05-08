package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import inf112.skeleton.app.RoboRally;

/**
 * @author Vegard Birkenes
 */
public class MenuScreen implements Screen {

    private Stage stage;
    private BitmapFont font;
    private RoboRally game;

    /**
     * Makes a new menuscreen with an image button. The button is not yet centered because we are considering using a skin.
     * Makes a texture and adds this to an imagebutton. The imagebutton is then added to a stage which is displayed using show and render.
     * There is also added a clickevent to the button in order to switch screens when you press the button.
     * @param game, has to take in a final game in order to be able to handle a clickevent.
     */
    public MenuScreen(RoboRally game) {
        this.game = game;
        stage = new Stage();
        font = new BitmapFont();
        Table table = new Table();
        table.setFillParent(true);
        table.add(makeStartButton(game));
        table.row();
        table.add(chooseDifficulty());
        stage.addActor(table);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor( 180/255F, 180/255F ,180/255F, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    /**
     * Override method that sets the width and the height of the board
     * @param width = board width
     * @param height = board height
     */
    @Override
    public void resize(int width, int height) {
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

    public ImageButton makeStartButton(final RoboRally game) {
        TextureRegionDrawable textureDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("startknapp.png"))));
        ImageButton playButton = new ImageButton(textureDrawable);
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Started new game");
                game.setScreen(game.getGameScreen());
            }
        });
        return playButton;
    }

    public Table chooseDifficulty() {
        Table difficultyTable = new Table();
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = font;
        style.fontColor = Color.BROWN;
        font.getData().setScale(2);
        makeDifficultyButton("Easy", style, difficultyTable, game);
        makeDifficultyButton("Hard", style, difficultyTable, game);
        difficultyTable.setDebug(true);
        return difficultyTable;
    }

    public TextButton makeDifficultyButton(final String difficulty, TextButton.TextButtonStyle style, Table table, final RoboRally game) {
        TextButton textButton = new TextButton(difficulty, style);
        table.add(textButton).width(100).height(80);
        textButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setGameScreen(difficulty);
                System.out.println("Difficulty set to " + difficulty + ".");
                game.getGameScreen().render(0);
            }
        });
        return textButton;
    }
}
