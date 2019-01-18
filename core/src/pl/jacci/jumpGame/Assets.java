package pl.jacci.jumpGame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

    public final AssetManager manager = new AssetManager();

    public void load(){
        manager.load("jumpGame/jajo.png", Texture.class);
        manager.load("jumpGame/platform.png", Texture.class);
        manager.load("jumpGame/music.ogg", Music.class);
        manager.load("jumpGame/jump.ogg", Sound.class);
    }

    @Override
    public void dispose() {
        manager.dispose();
    }
}
