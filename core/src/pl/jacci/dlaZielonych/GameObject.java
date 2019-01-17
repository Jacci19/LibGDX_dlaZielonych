package pl.jacci.dlaZielonych;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


public class GameObject extends Rectangle {
    private Texture texture;

    public GameObject(Texture texture) {                                        //constructor
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
    }
}


