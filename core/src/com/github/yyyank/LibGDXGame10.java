package com.github.yyyank;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.github.yyyank.character.GameCharacter;

/**
 * http://qiita.com/shinsan68k/items/db51b2b711fd42dbace5
 */
public class LibGDXGame10 implements ApplicationListener {

    ShaderProgram shaderProgram;
    SpriteBatch batch;
    Texture texture;

    @Override
    public void create() {
        batch = new SpriteBatch();
        texture = new Texture(GameCharacter.FH_PNG);
        // ここらへんでハマる
        // http://stackoverflow.com/questions/26835347/no-uniform-with-name-u-proj-in-shader
        // ShaderProgram.pedantic = false;

        // シェーダーのセットアップ
        {

            String vertex = "attribute vec4 " + ShaderProgram.POSITION_ATTRIBUTE + ";\n" //
                    + "attribute vec4 " + ShaderProgram.COLOR_ATTRIBUTE + ";\n" //
                    + "attribute vec2 " + ShaderProgram.TEXCOORD_ATTRIBUTE + "0;\n" //
                    + "uniform mat4 u_projTrans;\n" //
                    + "varying vec4 v_color;\n" //
                    + "varying vec2 v_texCoords;\n" //
                    + "\n" //
                    + "void main()\n" //
                    + "{\n" //
                    + "   v_color = " + ShaderProgram.COLOR_ATTRIBUTE + ";\n" //
                    + "   v_color.a = v_color.a * (256.0/255.0);\n" //
                    + "   v_texCoords = " + ShaderProgram.TEXCOORD_ATTRIBUTE + "0;\n" //
                    + "   gl_Position =  u_projTrans * " + ShaderProgram.POSITION_ATTRIBUTE + ";\n" //
                    + "}\n";

            String fragment = "#ifdef GL_ES\n" //
                    + "#define LOWP lowp\n" //
                    + "precision mediump float;\n" //
                    + "#else\n" //
                    + "#define LOWP \n" //
                    + "#endif\n" //
                    + "varying LOWP vec4 v_color;\n" //
                    + "varying vec2 v_texCoords;\n" //
                    + "uniform sampler2D u_texture;\n" //
                    + "void main()\n"//
                    + "{\n" //
                    + "    vec4 c4 = texture2D(u_texture, v_texCoords);\n"
                    + "    gl_FragColor = v_color * vec4(1, 1, 1, c4.a);\n"
                    + "}";
            shaderProgram = new ShaderProgram(vertex, fragment);
        }




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
        batch.begin();

        batch.setShader(shaderProgram);
        batch.draw(texture, 0, 0);
        batch.setShader(null); // 元に戻す

        batch.end();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
