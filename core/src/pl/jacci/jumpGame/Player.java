package pl.jacci.jumpGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Rectangle {

    private Sound jumpSound;
    private Texture texture;
    public boolean canJump = true;
    public float jumpVelocity;                                  //prędkość skoku. >0 - unosimy się w górę, <0 - spadamy

    public Player(Texture texture, Assets assets) {
        this.texture = texture;
        this.height = texture.getHeight();
        this.width = texture.getWidth();
        //jumpSound = Gdx.audio.newSound(Gdx.files.internal("jumpGame/jump.ogg"));
        jumpSound = assets.manager.get("jumpGame/jump.ogg", Sound.class);
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture, x, y);
    }

    public void jump(){
        if (canJump && jumpVelocity >= -100){                   // gdy ciut spada... (https://youtu.be/4nv3MPgo9vI?list=PLFq6ri1W22hyyGVo7pmTMstd-pZWZBmRg&t=400)
            jumpVelocity += 800;
            canJump = false;
            jumpSound.play();
        }
    }
}


























