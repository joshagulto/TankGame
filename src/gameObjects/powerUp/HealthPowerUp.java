package gameObjects.powerUp;

import gameObjects.GameObject;
import gameObjects.ID;
import runtime.BufferedImageLoader;
import runtime.EventHandler;

import java.awt.*;

public class HealthPowerUp extends PowerUp {
    public HealthPowerUp(int x, int y, ID id, EventHandler eventHandler) {
        super(x,y,id);
        this.eventHandler = eventHandler;

        BufferedImageLoader loader = new BufferedImageLoader();
        sprite = loader.loadImage("/graphics/healthpowerup.png");
    }
    public void tick() {
        for (int i = 0; i < eventHandler.getList().size(); i++) {
            GameObject temp = eventHandler.getList().get(i);

            if (getBounds().intersects(temp.getBounds())) {
                if (temp.getId().equals(ID.Tree) || temp.getId().equals(ID.Rock) || temp.getId().equals(ID.Player1)) {
                    eventHandler.removeObject(this);
                }
            }

        }
    }

    public void render(Graphics g) {
        g.drawImage(sprite, x ,y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y, 32,32);
    }

    public Rectangle getOuterBounds() {
        return new Rectangle(x,y,64,64);
    }
}
