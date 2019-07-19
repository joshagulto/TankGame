package runtime;

import gameObjects.GameObject;
import gameObjects.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    EventHandler eventHandler;

    public KeyInput(EventHandler h) {
        this.eventHandler = h;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) eventHandler.setToggleForward1(true);
        else if (key == KeyEvent.VK_S) eventHandler.setToggleBackward1(true);
        else if (key == KeyEvent.VK_A) eventHandler.setToggleLeftRotate1(true);
        else if (key == KeyEvent.VK_D) eventHandler.setToggleRightRotate1(true);
        else if (key == KeyEvent.VK_R) eventHandler.setShoot1(true);

        if (key == KeyEvent.VK_O) eventHandler.setToggleForward2(true);
        else if (key == KeyEvent.VK_L) eventHandler.setToggleBackward2(true);
        else if (key == KeyEvent.VK_K) eventHandler.setToggleLeftRotate2(true);
        else if (key == KeyEvent.VK_SEMICOLON || key == KeyEvent.VK_COLON) eventHandler.setToggleRightRotate2(true);
        else if (key == KeyEvent.VK_BRACELEFT || key == KeyEvent.VK_OPEN_BRACKET) eventHandler.setShoot2(true);


    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) eventHandler.setToggleForward1(false);
        else if (key == KeyEvent.VK_S) eventHandler.setToggleBackward1(false);
        else if (key == KeyEvent.VK_A) eventHandler.setToggleLeftRotate1(false);
        else if (key == KeyEvent.VK_D) eventHandler.setToggleRightRotate1(false);
        else if (key == KeyEvent.VK_R) eventHandler.setShoot1(false);

        if (key == KeyEvent.VK_O) eventHandler.setToggleForward2(false);
        else if (key == KeyEvent.VK_L) eventHandler.setToggleBackward2(false);
        else if (key == KeyEvent.VK_K) eventHandler.setToggleLeftRotate2(false);
        else if (key == KeyEvent.VK_SEMICOLON || key == KeyEvent.VK_COLON) eventHandler.setToggleRightRotate2(false);
        else if (key == KeyEvent.VK_BRACELEFT || key == KeyEvent.VK_OPEN_BRACKET) eventHandler.setShoot2(false);
    }

}
