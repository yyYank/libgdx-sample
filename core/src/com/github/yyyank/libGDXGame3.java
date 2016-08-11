package com.github.yyyank;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class LibGDXGame3 extends ApplicationAdapter {
	SpriteBatch batch;
	TextureAtlas atlas;
	
	@Override
	public void create () {
		FileHandle fh = Gdx.files.internal("001.txt");
		batch = new SpriteBatch();
		atlas = new TextureAtlas(fh);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setColor(1, 1, 1, 1);
		TextureAtlas.AtlasRegion region1 = atlas.findRegion("7TZK1gqH_400x400");
		batch.draw(region1, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		atlas.dispose();
	}
}
