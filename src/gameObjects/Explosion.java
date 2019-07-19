package gameObjects;

import runtime.BufferedImageLoader;
import runtime.EventHandler;

import java.awt.*;

public class Explosion extends GameObject {
    private int counter = 0;

    public Explosion(int x, int y, ID id, EventHandler eventHandler) {
        super(x,y,id);
        this.eventHandler = eventHandler;

        BufferedImageLoader loader = new BufferedImageLoader();
        sprite = loader.loadImage("/graphics/explode1.png");
    }

    public void tick() {
        BufferedImageLoader loader = new BufferedImageLoader();

        switch (counter) {
            case 2:
                sprite = loader.loadImage("/graphics/explode2.png");
                break;
            case 4:
                sprite = loader.loadImage("/graphics/explode3.png");
                break;
            case 6:
                sprite = loader.loadImage("/graphics/explode4.png");
                break;
            case 8:
                sprite = loader.loadImage("/graphics/explode5.png");
                break;
            case 10:
                sprite = loader.loadImage("/graphics/explode6.png");
                break;
            case 12:
                sprite = loader.loadImage("/graphics/explode7.png");
                break;
            case 14:
                sprite = loader.loadImage("/graphics/explode8.png");
                break;
            case 16:
                sprite = loader.loadImage("/graphics/explode9.png");
                break;
            case 18:
                sprite = loader.loadImage("/graphics/explode10.png");
                break;
            case 20:
                sprite = loader.loadImage("/graphics/explode11.png");
                break;
            case 22:
                sprite = loader.loadImage("/graphics/explode12.png");
                break;
            case 24:
                sprite = loader.loadImage("/graphics/explode13.png");
                break;
            case 26:
                sprite = loader.loadImage("/graphics/explode14.png");
                break;
            case 28:
                sprite = loader.loadImage("/graphics/explode15.png");
                break;
            case 30:
                eventHandler.removeObject(this);
                break;
        } counter++;
    }

    public void render(Graphics g) {
        g.drawImage(sprite,x,y,null);
    }
    public Rectangle getBounds() {
        return new Rectangle (0,0,1,1);
    }
}
