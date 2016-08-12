package com.github.yyyank;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class LibGDXGame4 extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite fruedSprite;
	Sprite shikouteiSprite;
	Sprite masaokaShikiSprite;
	Sprite goemonSprite;
	Sprite marugotoSprite;//テクスチャまるごと
	
	@Override
	public void create () {
		FileHandle fh = Gdx.files.internal("freud.txt");
		TextureAtlas atlas = new TextureAtlas(fh);

		// フロイト
		TextureAtlas.AtlasRegion freud = atlas.findRegion("nigaoe_freud");
		fruedSprite = new Sprite(freud);
		fruedSprite.setPosition(0, 0);

		// 始皇帝
		TextureAtlas.AtlasRegion shikoutei = atlas.findRegion("nigaoe_shikoutei");
		shikouteiSprite = new Sprite(shikoutei);
		shikouteiSprite.setPosition(200, 0);
		shikouteiSprite.setAlpha(0.5f);

		// 正岡子規
		TextureAtlas.AtlasRegion masaokaShiki = atlas.findRegion("nigaoe_masaoka_shiki");
		masaokaShikiSprite = new Sprite(masaokaShiki);
		masaokaShikiSprite.setPosition(0, 200);
		masaokaShikiSprite.setFlip(true, true);

		// ごえもん
		TextureAtlas.AtlasRegion goemon = atlas.findRegion("nigaoe_ishikawa_goemon");
		goemonSprite = new Sprite(goemon);
		goemonSprite.setPosition(200, 200);
		goemonSprite.setColor(0,0,1,1);




		// テクスチャをまるごと1枚で
		FileHandle fh2 = Gdx.files.internal("freud.png");
		Texture texture = new Texture(Gdx.files.internal("freud.png"));
		marugotoSprite = new Sprite(texture);
		marugotoSprite.setScale(2);
		marugotoSprite.setRotation(2); // 拡大
		marugotoSprite.setPosition(100, 100);


		// バッチをnew
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		// spriteたちを描画
		drawSprites(marugotoSprite, fruedSprite, masaokaShikiSprite, goemonSprite, shikouteiSprite);

		batch.end();
	}


	/**
	 * めんどくさいからまとめてやりたくなるやん
	 * @param sprites スプライトたち
     */
	private void drawSprites(Sprite... sprites) {
		for (Sprite sprite : sprites) {
			sprite.draw(batch);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
