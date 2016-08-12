package com.github.yyyank;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.github.yyyank.character.GameCharacter;

import java.util.Random;

/**
 * http://qiita.com/shinsan68k/items/ef8aeec2a1f7724ec429
 */
public class LibGDXGame7 implements ApplicationListener {

    TextureAtlas atlas;
    Stage stage;


    @Override
    public void create() {
        atlas = GameCharacter.atlas();
        stage = new Stage();

        // InputProcessorがキー入力のリスナーらしい。
        // StageはInputAdapterを継承しているが
        // InputProcessorのインターフェース実装メソッドを
        // Overrideしてるんかな、と思ったら
        // やっぱそうらしい。
        Gdx.input.setInputProcessor(stage);


        TextureAtlas.AtlasRegion region = atlas.findRegion(GameCharacter.FRUED);
        final Image image = new Image(region);
        image.setPosition(0, 0);
        final Random random = new Random();
        ClickListener listener = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("クリックされたやーつ１");
                super.clicked(event, x, y);
                image.setPosition(random.nextInt(10), random.nextInt(10));
                image.setRotation(random.nextInt(45) * -1);
                image.setScale(random.nextFloat());
            }
        };

        image.addListener(listener);
        stage.addActor(image);

        TextureAtlas.AtlasRegion region2 = atlas.findRegion(GameCharacter.GOEMON);
        final Image image2 = new Image(region2);
        image2.setPosition(200, 200);

        ClickListener listener2 = new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("クリックされたやつ２");
                super.clicked(event, x, y);
                image2.setPosition(200 - random.nextInt(20), random.nextInt(200));
            }
        };
        image2.addListener(listener2);
        stage.addActor(image2);
    }


    @Override
    public void dispose() {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
