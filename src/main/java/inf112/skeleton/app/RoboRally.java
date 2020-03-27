package inf112.skeleton.app;

import com.badlogic.gdx.Game;
import inf112.skeleton.app.screen.MenuScreen;
import inf112.skeleton.app.screen.RegisterScreen;

/**
 * @author vegardbirkenes
 */
//This is libgdx own Game class, this makes it possible to switch between screens.
public class RoboRally extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }



}
