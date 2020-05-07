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
 * @author Vegard Birkenes
 */
public class MenuScreen implements Screen {

    private Stage stage;

    /**
     * Makes a new menuscreen with an image button. The button is not yet centered because we are considering using a skin.
     * Makes a texture and adds this to an imagebutton. The imagebutton is then added to a stage which is displayed using show and render.
     * There is also added a clickevent to the button in order to switch screens when you press the button.
     * @param game, has to take in a final game in order to be able to handle a clickevent.
     */
    public MenuScreen(final RoboRally game) {
        RoboRally roboRally = game;
        stage = new Stage();
        Table table = new Table();
        TextureRegionDrawable textureDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("startknapp.png"))));
        ImageButton playButton = new ImageButton(textureDrawable);
        table.setFillParent(true);
        table.add(playButton);
        stage.addActor(table);

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Started new game");
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

    /**
     * Override method that sets the width and the height of the board
     * @param width = board width
     * @param height = board height
     */
    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
    }
}
