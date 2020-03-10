package inf112.skeleton.app.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.skeleton.app.Game;
import inf112.skeleton.app.RoboRally;

public class MenuScreen implements Screen {

    private SpriteBatch batch;
    private RoboRally game;
    private Texture texture;
    private TextureRegion textureRegion;
    private Sprite button;
    private ImageButton playButton;
    private TextureRegionDrawable textureDrawable;
    private Stage stage;
    private Table table;
    private SpriteDrawable drawButton;


    public MenuScreen(final RoboRally game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.stage = new Stage();
        texture = new Texture(Gdx.files.internal("startknapp.png"));
        textureRegion = new TextureRegion(texture);

        button = new Sprite(textureRegion);
        drawButton = new SpriteDrawable(button);

        playButton = new ImageButton(drawButton);
        playButton.getImage().setOrigin(Align.center);
        stage.addActor(playButton);

        playButton.addListener(new ClickListener() {
            @Override
            public boolean handle(Event event) {
                game.setScreen(new GameScreen());
                return true;
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
        //batch.begin();
        //batch.draw(button, 350,250);
        //batch.end();
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

    }
}
