package pl.jacci;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class dlaZielonych extends ApplicationAdapter {

	private OrthographicCamera camera;

	private SpriteBatch batch;														//do rysowania po ekranie (puszka z farbą którą otwieramy i zamykamy)
	private Texture texture;
	private BitmapFont font;
	private GameObject gameObject1, gameObject2;
	private float timerHelper;														//timer oparty na deltaTime
	
	@Override
	public void create () {															//tu inicjujemy pola, ładujemy dane, itp.
		camera = new OrthographicCamera(800, 480);			// jak damy viewport równy wymiarom okna to nie będzie przeskalowania gry.
		texture = new Texture("badlogic.jpg");
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.GREEN);

		gameObject1 = new GameObject(texture);
		gameObject1.x = 50;
		gameObject1.y = 50;
		gameObject1.width = gameObject1.getTexture().getWidth();					//potrzebne do poprawnego wykrywania kolizji i działania kamery
		gameObject1.height = gameObject1.getTexture().getHeight();

		gameObject2 = new GameObject(texture);
		gameObject2.x = 500;
		gameObject2.y = 200;
		gameObject2.width = gameObject2.getTexture().getWidth();
		gameObject2.height = gameObject2.getTexture().getHeight();

	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 0);						//czyszczenie ekranu na starcie aplikacji (kolorem black)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();																//otwieramy puszkę
		//batch.draw(texture, 100, 100);											//rysuje (wstawia) na okno plik ze zmiennej texture.
		batch.draw(gameObject1.getTexture(), gameObject1.x, gameObject1.y);			//x,y są odziedziczone z Rectangle
		batch.draw(gameObject2.getTexture(), gameObject2.x, gameObject2.y);			//x,y są odziedziczone z Rectangle
		font.draw(batch, "Hello World", 100, 400);
		batch.end();																//zamykamy puszkę
	}

	private void update() {
		camera.update();
		batch.setProjectionMatrix(camera.combined);									//łączymy SpiriteBatch z odpowiednią kamerą
		camera.position.set(gameObject1.x + gameObject1.width/2, gameObject1.y + gameObject1.height/2, 0);

		if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){							//przybliżanie
			System.out.println("Pressed SHIFT_LEFT");
			camera.zoom += 0.02f;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)){							//oddalanie
			System.out.println("Pressed SHIFT_RIGHT");
			camera.zoom -= 0.02f;
		}


		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			System.out.println("Pressed A");
			gameObject1.x -=300 * Gdx.graphics.getDeltaTime();				//aby na każdym sprzęcie gra działała z tym samym fpsem
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			System.out.println("Pressed W");
			gameObject1.y +=300 * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			System.out.println("Pressed S");
			gameObject1.y -=300 * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			System.out.println("Pressed D");
			gameObject1.x +=300 * Gdx.graphics.getDeltaTime();
		}

		if(gameObject1.overlaps(gameObject2)){										//jeśli obiekt_1 koliduje z obiekt_2 to...
			//Gdx.app.exit();														//...wyjdź z programu
			System.out.println("KOLIZJA OBIEKTÓW");
		}

		timerHelper += Gdx.graphics.getDeltaTime();									//Prosty timer
		if(timerHelper > 0.8){
			System.out.println("timer działa");										//wykonuje to co czas okrślony w warunku powyżej (w sekundach)
			camera.rotate(0.50f);
			timerHelper = 0;
		}
	}

	@Override
	public void dispose () {														//zwalnia używana pamięć po zamknięciu programu
		System.out.println("App closed");
		batch.dispose();
		texture.dispose();
		font.dispose();
	}
}
