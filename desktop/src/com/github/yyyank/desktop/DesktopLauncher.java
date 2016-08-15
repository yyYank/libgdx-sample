package com.github.yyyank.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.yyyank.LibGDXGame5;
import com.github.yyyank.LibGDXGame7;
import com.github.yyyank.LibGDXGame8;
import com.github.yyyank.LibGDXGame9;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new LibGDXGame9(), config);
	}
}
