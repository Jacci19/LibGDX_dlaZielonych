package pl.jacci.desktop;

/***Projekt na podstawie kursu you tube javaDevMatt - LibGDX dla zielonych
*	dlaZielonych - lekcje 1-7		(800x480)
 *	jumpGame 	- lekcje 8-10		(480x800)
*/
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.jacci.dlaZielonych.DlaZielonych;
import pl.jacci.jumpGame.JumpGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 480;
		config.height = 800;
		config.resizable = false;
		//new LwjglApplication(new DlaZielonych(), config);
		new LwjglApplication(new JumpGame(), config);
	}
}
