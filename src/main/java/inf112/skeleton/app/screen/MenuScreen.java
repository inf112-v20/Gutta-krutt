package inf112.skeleton.app.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.skeleton.app.Game;

public class MenuScreen implements Screen {

    private inf112.skeleton.app.Game game;
    private Viewport viewport;

    public MenuScreen (Game  game){
        this.game = game;
        viewport = new FitViewport();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
