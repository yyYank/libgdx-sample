package com.github.yyyank;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class libGDXGame5 implements ApplicationListener {

    Stage stage;




    @Override
    public void dispose() {
    }

    @Override
    public void create() {
        FileHandle fh = Gdx.files.internal("freud.txt");
        TextureAtlas atlas = new TextureAtlas(fh);
        stage = new Stage();

        // ======= フロイト ==========
        TextureAtlas.AtlasRegion fruedRegion = atlas.findRegion("nigaoe_freud");
        // Imageクラスにregionを食わせるらしい
        Image fruedImage = new Image(fruedRegion);
        fruedImage.setPosition(0, 0);

        // ステージにActorを突っ込む
        // Imageはextends Widget。
        // Widgetはextends Actor implementes Layout
        stage.addActor(fruedImage); // stageの直下に追加


        // ======= 始皇帝 ==========
        TextureAtlas.AtlasRegion shikouteiRegion = atlas.findRegion("nigaoe_shikoutei");
        Image shikouteiImage = new Image(shikouteiRegion);
        shikouteiImage.setPosition(200, 0);
        stage.addActor(shikouteiImage); // stageの直下に追加



        // グループを生成する
        // Groupもextends Actor implemnts Cullable
        // Cullableはよく分からん
        // 多分Groupのabilityなんだと思うんだが
        // 親子関係の描画操作かな
        Group group = new Group();
        group.setPosition(0, 200);


        // ======= 正岡子規 ==========
        TextureAtlas.AtlasRegion masaokaRegion = atlas.findRegion("nigaoe_masaoka_shiki");
        Image masaokaImage = new Image(masaokaRegion);
        masaokaImage.setPosition(0, 0);
        group.addActor(masaokaImage); // groupの下に追加


        TextureAtlas.AtlasRegion goemonRegion = atlas.findRegion("nigaoe_ishikawa_goemon");
        Image goemonImage = new Image(masaokaRegion);
        goemonImage.setPosition(200, 0);
        group.addActor(goemonImage); // groupの下に追加




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
