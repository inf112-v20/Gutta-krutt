package inf112.skeleton.app.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen {
    OrthogonalTiledMapRenderer renderer;
    final private int BOARDSIZE = 12;
    final private int TILESIZE = 300;

    public GameScreen(TiledMap tilemap) {
        //initialize a new camera and renderer for camera
        OrthographicCamera camera = new OrthographicCamera();
        renderer = new OrthogonalTiledMapRenderer(tilemap, 1);

        camera.setToOrtho(false, BOARDSIZE*TILESIZE , BOARDSIZE*TILESIZE);
        camera.update();
        renderer.setView(camera);
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }
}
