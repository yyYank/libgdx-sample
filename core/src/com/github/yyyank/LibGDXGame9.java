package com.github.yyyank;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.github.yyyank.character.GameCharacter;

/**
 * http://qiita.com/shinsan68k/items/ef8aeec2a1f7724ec429
 */
public class LibGDXGame9 implements ApplicationListener {

    TextureAtlas atlas;
    Stage stage;


    Image example = new Image() {
        @Override
        public void act(float delta) {
            super.act(delta);

//            if(count < 60) {
//                setX(getX() +  1);
//                count++;
//            }
        }
    };


    @Override
    public void create() {
        atlas = GameCharacter.atlas();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        FileHandle fh = GameCharacter.handlePng();
        Texture tex = new Texture(fh);
        stage.addActor(makeSoundImage(tex, Interpolation.bounceOut));
    }




    Image makeSoundImage(Texture tex, Interpolation mode) {
        Image image = new Image(tex);
        Action toRight = Actions.moveBy(300, 0, 1, mode);
        Action toLeft = Actions.moveBy(-300, 0, 1, mode);


        SequenceAction seq = Actions.sequence();
        seq.addAction(toRight);
        seq.addAction(toLeft);

        RepeatAction repeat = Actions.forever(seq);
        image.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                // http://otosozai.com/?se=mob
                Sound sound = Gdx.audio.newSound(Gdx.files.internal("se_mob02.wav"));
                // 読み込ませるwavだが、ビットレートが16以上じゃないとGdxRuntimeExceptionが発生した
                // この辺りの話
                // -> http://stackoverflow.com/questions/24305630/android-java-libgdx-music-sound
                sound.play();
            }

        });
        image.addAction(repeat);
        return image;
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
