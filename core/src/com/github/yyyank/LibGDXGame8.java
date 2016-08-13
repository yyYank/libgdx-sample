package com.github.yyyank;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
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

import javax.swing.*;
import java.util.Random;

/**
 * http://qiita.com/shinsan68k/items/ef8aeec2a1f7724ec429
 */
public class LibGDXGame8 implements ApplicationListener {

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
        FileHandle fh = GameCharacter.handlePng();
        Texture tex = new Texture(fh);
//        stage.addActor(createAccelerationSequentialActionImage(tex, Interpolation.fade));
//        stage.addActor(createAccelerationSequentialActionImage(tex, Interpolation.swingOut));
//        stage.addActor(createAccelerationSequentialActionImage(tex, Interpolation.bounceOut));
        stage.addActor(createRepeatedToEndActionImage(tex, Interpolation.bounceOut));
    }



    Image createSequentialActionImage(Texture tex) {
        Image image = new Image(tex);

        // Actionsはstaticなファクトリメソッド
        // moveByメソッドではMoveByActionが返される
        // MoveByAction extends RelativeTemporalAction
        // RelativeTemporalAction extends TemporalAction
        // TemporalAction extends Action
        Action moveByAction = Actions.moveBy(60, 0, 1);
        Action moveByActionBack = Actions.moveBy(-60, 0, 1);

        // 複数のActionを行うSequenceAction
        SequenceAction seq = Actions.sequence();
        seq.addAction(moveByAction);
        seq.addAction(moveByActionBack);
        // 繰り返し行うRepeatAction
        RepeatAction repeat = Actions.forever(seq);
        image.addAction(repeat);
        image.setPosition(50, 50);
        return image;
    }

    Image createSequentialParallelActionImage(Texture tex) {
        Image image = new Image(tex);

        Action toRight = Actions.parallel(
                Actions.moveBy(60, 0, 1),
                Actions.scaleTo(2, 2, 1)
        );
        Action toLeft = Actions.parallel(
                Actions.moveBy(-60, 0, 1),
                Actions.scaleTo(1, 2, 1)
        );

        SequenceAction seq = Actions.sequence();
        seq.addAction(toRight);
        seq.addAction(toLeft);
        RepeatAction repeat = Actions.forever(seq);
        image.addAction(repeat);

        return image;
    }

    Image createAccelerationSequentialActionImage(Texture tex, Interpolation mode) {
        Image image = new Image(tex);
        Action toRight = Actions.moveBy(300, 0, 1, mode);
        Action toLeft = Actions.moveBy(-300, 0, 1, mode);

        SequenceAction seq = Actions.sequence();
        seq.addAction(toRight);
        seq.addAction(toLeft);

        RepeatAction forever = Actions.forever(seq);
        image.addAction(forever);
        return image;
    }

    Image createRepeatedToEndActionImage(Texture tex, Interpolation mode) {
        Image image = new Image(tex);
        Action toRight = Actions.moveBy(300, 0, 1, mode);
        Action toLeft = Actions.moveBy(-300, 0, 1, mode);

        Action end = Actions.run(() -> image.clearActions());

        SequenceAction seq = Actions.sequence();
        seq.addAction(toRight);
        seq.addAction(toLeft);
        seq.addAction(end);

        RepeatAction repeat = Actions.forever(seq);
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
