package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import inf112.skeleton.app.cards.DisplayCard;
import inf112.skeleton.app.screen.StartScreen;


public class Main {

    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "RoboRally Game";
        cfg.width = 1000;
        cfg.height = 1000;

        new LwjglApplication(new Game(), cfg);
    }
}