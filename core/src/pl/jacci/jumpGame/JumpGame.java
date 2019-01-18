package pl.jacci.jumpGame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;


public class JumpGame extends ApplicationAdapter {

    private Assets assets;
    private Music music;
    private Texture playerTexture, platformTexture;
    private Player player;
    private Array<Platform> platformArray;
    private OrthographicCamera camera;
    private float gravity = -20;
    private SpriteBatch batch;														//do rysowania po ekranie (puszka z farbą którą otwieramy i zamykamy)


    @Override
    public void create () {															//tu inicjujemy pola, ładujemy dane, itp.
        assets = new Assets();
        assets.load();
        assets.manager.finishLoading();
        if(assets.manager.update()){                                //gra wystartuje dopiero jak załadują się wszystkie assety
            loadDataFromFiles();
            initGame();
        }
    }

    private void loadDataFromFiles() {
//        playerTexture = new Texture("jumpGame/jajo.png");                                    //stary sposób ładowania bez wykorzystania managera
//        platformTexture = new Texture("jumpGame/platform.png");
//        music = Gdx.audio.newMusic(Gdx.files.internal("jumpGame/music.ogg"));
        playerTexture = assets.manager.get("jumpGame/jajo.png", Texture.class);             //ten sposób zalecany jest gdy jest dużo assetów
        platformTexture = assets.manager.get("jumpGame/platform.png", Texture.class);
        music = assets.manager.get("jumpGame/music.ogg", Music.class);

    }

    private void initGame() {
        batch = new SpriteBatch();
        music.play();
        camera = new OrthographicCamera(480, 800);

        player = new Player(playerTexture, assets);
        platformArray = new Array<Platform>();

        for (int i=1; i<10; i++){
            Platform platform = new Platform(platformTexture);
            platform.x = MathUtils.random(480);
            platform.y = 200 * i;
            platformArray.add(platform);
        }
    }


    @Override
    public void render () {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 0);						//czyszczenie ekranu na starcie aplikacji (kolorem black)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();																//otwieramy puszkę
        batch.setProjectionMatrix(camera.combined);
        for(Platform platform : platformArray){
            platform.draw(batch);
        }

        player.draw(batch);
        batch.end();																//zamykamy puszkę
    }

    private void update() {
        handleInput();

        camera.update();
        camera.position.set(player.x + player.width / 2,player.y + 300, 0);

        player.y += player.jumpVelocity * Gdx.graphics.getDeltaTime();

        if (player.y > 0) {
            player.jumpVelocity += gravity;
        } else {
            player.y = 0;                                   //aby nie spadł poniżej podłogi
            player.canJump = true;
            player.jumpVelocity = 0;
        }

        for (Platform platform : platformArray) {
            if (isPlayerOnPlatform(platform)) {
                player.canJump = true;
                player.jumpVelocity = 0;
                player.y = platform.y + platform.height;
            }
        }
    }

    private boolean isPlayerOnPlatform(Platform platform) {
        return (player.jumpVelocity <= 0) && (player.overlaps(platform)) && !(player.y <= platform.y);
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.x -= 500 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.x += 500 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.justTouched()) {
            player.jump();
        }
    }

    @Override
    public void dispose () {														//zwalnia używana pamięć po zamknięciu programu
        System.out.println("App closed");
        batch.dispose();
        music.dispose();

    }
}