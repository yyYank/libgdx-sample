package com.github.yyyank.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.yyyank.libGDXGame;
import com.github.yyyank.libGDXGame3;

import java.util.stream.IntStream;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new libGDXGame3(), config);
	}
}
