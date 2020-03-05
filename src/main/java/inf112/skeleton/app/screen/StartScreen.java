package inf112.skeleton.app.screen;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class StartScreen extends InputAdapter implements ApplicationListener {

    private SpriteBatch batch;
    private BitmapFont font;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap tilemap;
    private Stage stage;
    private Table table;
    private ImageButton button;
    private TextButton button2;
    private TextButton.TextButtonStyle buttonStyle;
    private Texture texture;
    private TextureRegion textureRegion;
    private TextureRegionDrawable textureRegionDrawable;

    @Override
    public void create() {
        stage = new Stage();


        table = new Table();
        table.setFillParent(true);

        font = new BitmapFont();
        buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font;

        texture = new Texture(Gdx.files.internal("startknapp.png"));
        textureRegion = new TextureRegion(texture);
        textureRegionDrawable = new TextureRegionDrawable(textureRegion);

        button = new ImageButton(textureRegionDrawable);
        //button = new TextButton("Start", buttonStyle);
        //button.pad(100, 200, 100, 100);

        Gdx.input.setInputProcessor(stage);



        table.add(button).width(100);
        stage.addActor(table);

        table.setDebug(true); // This is optional, but enables debug lines for tables.

        // Add widgets to the table here.
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor( 180/255F, 180/255F ,180/255F, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
