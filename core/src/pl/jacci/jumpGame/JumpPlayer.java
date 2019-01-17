package pl.jacci.jumpGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class JumpPlayer extends Rectangle {

    private Sound jumpSound;
    private Texture texture;
    public boolean canJump = true;
    public float jumpVelocity;                                  //prędkość skoku. >0 - unosimy się w górę, <0 - spadamy

    public JumpPlayer(Texture texture) {
        this.texture = texture;
        this.height = texture.getHeight();
        this.width = texture.getWidth();
        jumpSound = Gdx.audio.newSound(Gdx.files.internal("jumpGame/jump.ogg"));
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture, x, y);
    }

    public void jump(){
        if (canJump && jumpVelocity >= -100){                   // gdy ciut spada...
            jumpVelocity += 800;
            canJump = false;
            jumpSound.play();
        }
    }
}


























