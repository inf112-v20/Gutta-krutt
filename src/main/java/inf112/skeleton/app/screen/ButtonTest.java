package inf112.skeleton.app.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class ButtonTest extends Game {

    Stage stage;
    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    TextureAtlas buttonAtlas;


    public static void main(String[] args) {
        Skin skin = new Skin();
        // Keep your code clean by creating widgets separate from layout.
        Label nameLabel = new Label("Name:", skin);
        TextField nameText = new TextField("", skin);
        Label addressLabel = new Label("Address:", skin);
        TextField addressText = new TextField("", skin);

        Table table = new Table();
        table.add(nameLabel);              // Row 0, column 0.
        table.add(nameText).width(100);    // Row 0, column 1.
        table.row();                       // Move to next row.
        table.add(addressLabel);           // Row 1, column 0.
        table.add(addressText).width(100); // Row 1, column 1.
    }

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        Skin skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.pack"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("up-button");
        textButtonStyle.down = skin.getDrawable("down-button");
        textButtonStyle.checked = skin.getDrawable("checked-button");
        button = new TextButton("Button1", textButtonStyle);
        stage.addActor(button);
    }

    @Override
    public void render() {
        super.render();
        stage.draw();
    }
}
