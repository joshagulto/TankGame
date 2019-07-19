package gameObjects.powerUp;

import gameObjects.GameObject;
import gameObjects.ID;

public abstract class PowerUp extends GameObject {
    public PowerUp(int x, int y, ID id) {
        super(x, y, id);
    }

    public PowerUp() {
        super();
    }
}
