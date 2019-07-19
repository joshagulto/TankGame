package gameObjects.bullets;

import gameObjects.GameObject;
import gameObjects.ID;
import runtime.EventHandler;

import java.awt.*;

public abstract class Bullet extends GameObject {
    private int angle;

    public Bullet(int x, int y, ID id, EventHandler eventHandler) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.eventHandler = eventHandler;
    }

    public Bullet() {
        super();
    }

    public abstract void tick();
    public abstract void render(Graphics g);

   // public void render(Graphics g) {
   //     g.setColor(Color.MAGENTA);
   //     g.fillRect(x,y,16,16);
 //   }

    public abstract Rectangle getBounds();
}
