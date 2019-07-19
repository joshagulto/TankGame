package runtime;

import gameObjects.GameObject;

public class Camera {
    private int x, y;

    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject object) {
        x += ((object.getX() - x) - (1280 - 128)/2) * 0.05f;
        y += ((object.getY() - y) - (720 - 128)/2) * 0.05f;

        if (x <= 0) x = 0;
        if (x >= 2832) x = 2832;
        if (y <= 0) y = 0;
        if (y >= 1616) y = 1616;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
