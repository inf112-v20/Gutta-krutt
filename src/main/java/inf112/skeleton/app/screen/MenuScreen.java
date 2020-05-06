package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import inf112.skeleton.app.RoboRally;

/**
 * @author vegardbirkenes
 */
public class MenuScreen implements Screen {

    private Texture texture;
    private TextureRegion textureRegion;
    private ImageButton playButton;
    private Stage stage;
    private TextureRegionDrawable textureDrawable;
    private RoboRally game;
    private Table table;

    /**
     * Makes a new menuscreen with an image button. The button is not yet centered because we are considering using a skin.
     * Makes a texture and adds this to an imagebutton. The imagebutton is then added to a stage which is displayed using show and render.
     * There is also added a clickevent to the button in order to switch screens when you press the button.
     * @param game, has to take in a final game in order to be able to handle a clickevent.
     */
    public MenuScreen(final RoboRally game) {
        this.game = game;
        stage = new Stage();
        table = new Table();
        texture = new Texture(Gdx.files.internal("startknapp.png"));
        textureRegion = new TextureRegion(texture);
        textureDrawable = new TextureRegionDrawable(textureRegion);

        playButton = new ImageButton(textureDrawable);
        table.setFillParent(true);
        table.add(playButton);
        stage.addActor(table);

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("clicked start");
                game.setScreen(game.getGameScreen());
            }
        });
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

    @Override
    public void resize(int width, int height) {
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
}
