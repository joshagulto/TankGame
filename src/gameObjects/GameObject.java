package gameObjects;

import runtime.EventHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject  {

    protected ID id;
    protected int x, y;
    protected float vx = 0, vy = 0;
    protected BufferedImage sprite;

    protected EventHandler eventHandler;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public GameObject() {
        x = 0;
        y = 0;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getVx() {
        return vx;
    }

    public float getVy() {
        return vy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVx(float x) {
        this.vx = x;
    }

    public void setVy(float x) {
        this.vy = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
