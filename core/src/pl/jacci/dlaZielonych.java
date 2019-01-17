package pl.jacci;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class dlaZielonych extends ApplicationAdapter {
	private SpriteBatch batch;														//do rysowania po ekranie (puszka z farbą którą otwieramy i zamykamy)
	private Texture texture;
	private BitmapFont font;
	
	@Override
	public void create () {															//tu inicjujemy pola, ładujemy dane, itp.
		texture = new Texture("badlogic.jpg");
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.GREEN);
	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);						//czyszczenie ekranu na starcie aplikacji (kolorem black)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();																//otwieramy puszkę
		batch.draw(texture, 100, 100);											//rysuje (wstawia) na okno plik ze zmiennej texture
		font.draw(batch, "Hello World", 500, 300);
		batch.end();																//zamykamy puszkę
	}
	
	@Override
	public void dispose () {														//zwalnia używana pamięć po zamknięciu programu
		System.out.println("App closed");
		batch.dispose();
		texture.dispose();
		font.dispose();
	}
}
