package gameObjects;

import runtime.BufferedImageLoader;

import java.awt.*;

public class Rock extends GameObject {

    public Rock(int x, int y, ID id) {
        super(x, y, id);

        BufferedImageLoader loader = new BufferedImageLoader();
        sprite = loader.loadImage("/graphics/rock.png");
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(sprite,x,y,null);

    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,64,64);
    }
}
