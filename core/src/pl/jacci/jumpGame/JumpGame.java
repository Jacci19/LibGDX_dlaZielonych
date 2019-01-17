package pl.jacci.jumpGame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JumpGame extends ApplicationAdapter {

    private SpriteBatch batch;														//do rysowania po ekranie (puszka z farbą którą otwieramy i zamykamy)


    @Override
    public void create () {															//tu inicjujemy pola, ładujemy dane, itp.
        batch = new SpriteBatch();
    }

    @Override
    public void render () {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 0);						//czyszczenie ekranu na starcie aplikacji (kolorem black)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();																//otwieramy puszkę
        batch.end();																//zamykamy puszkę
    }

    private void update() {
    }

    @Override
    public void dispose () {														//zwalnia używana pamięć po zamknięciu programu
        System.out.println("App closed");
    }
}