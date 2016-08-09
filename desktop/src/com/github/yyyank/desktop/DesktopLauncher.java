package com.github.yyyank.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.yyyank.libGDXGame;
import com.github.yyyank.libGDXGame3;
import com.github.yyyank.libGDXGame4;
import com.github.yyyank.libGDXGame5;

import java.util.stream.IntStream;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new libGDXGame5(), config);
	}
}
