package gameObjects;

import runtime.BufferedImageLoader;
import runtime.EventHandler;

import java.awt.*;
import java.awt.image.RescaleOp;

public class Tree extends GameObject {
    private int health = 15;

    public Tree(int x, int y, ID id, EventHandler eventHandler) {
        super(x, y, id);
        this.eventHandler = eventHandler;

        BufferedImageLoader loader = new BufferedImageLoader();
        sprite = loader.loadImage("/graphics/tree.png");
    }

    public void tick() {
        if (health != 0) {
            for (int i = 0; i < eventHandler.getList().size(); i++) {
                GameObject temp = eventHandler.getList().get(i);

                if (getInnerBounds().intersects(temp.getBounds())) {
                    if (temp.getId().equals(ID.SmallBullet)) {
                        health -= 5;

                        eventHandler.addObject(new Explosion(temp.getX(),temp.getY(),ID.Explosion, eventHandler));

                        eventHandler.removeObject(temp);


                    }
                }
            }
        } else {
            eventHandler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        g.drawImage(sprite, x, y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 96, 128);
    }

    public Rectangle getInnerBounds() {
        return new Rectangle(x+22,y+10,32,116);
    }
}

