package pl.jacci.desktop;

/***Projekt na podstawie kursu you tube javaDevMatt - LibGDX dla zielonych
*	dlaZielonych - lekcje 1-7		(800x480)
 *	jumpGame 	- lekcje 8-10		(480x800)
 *	https://www.youtube.com/watch?v=e_liJETU3u8&list=PLFq6ri1W22hyyGVo7pmTMstd-pZWZBmRg&index=1
 * 	https://bitbucket.org/mateuszkupilas/jump-tutorial/src
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
																	//Uncomment a line to program which you want to run:
		//new LwjglApplication(new DlaZielonych(), config);				// 1. logo badlogic przesuwa się i obraca
		new LwjglApplication(new JumpGame(), config);					// 2. gra, coś jak Icy Tower
	}
}
