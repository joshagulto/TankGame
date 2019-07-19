package runtime;

import gameObjects.GameObject;
import gameObjects.ID;
import gameObjects.Player;
import gameObjects.powerUp.HealthPowerUp;

import java.awt.*;
import java.util.LinkedList;

public class EventHandler {
    LinkedList<GameObject> objectList = new LinkedList<GameObject>();
    private final int maxHealthPacks = 10;
    private int healthPacks = 0;

    private final int coolTimeHealthPack = 500;
    private int healthPackTimer = 0;

    private Rectangle temp;

    private final int mapHeight = 4096;
    private final int mapWidth = 2048;


    /** Player 1 **/
    private boolean shoot1 = false;

    private boolean toggleForward1 = false;
    private boolean toggleBackward1 = false;

    private boolean toggleLeftRotate1 = false;
    private boolean toggleRightRotate1 = false;

    /** Player 2 **/
    private boolean toggleForward2 = false;
    private boolean toggleBackward2 = false;

    private boolean shoot2 = false;

    private boolean toggleLeftRotate2 = false;
    private boolean toggleRightRotate2 = false;


    private boolean player1Win = false;
    private boolean player2Win = false;


    /** Player 1 Get/Set **/
    public boolean isShoot1() {
        return shoot1;
    }
    public void setShoot1(boolean shoot1) {
        this.shoot1 = shoot1;
    }

    public boolean isToggleLeftRotate1() {
        return toggleLeftRotate1;
    }
    public void setToggleLeftRotate1(boolean toggleLeftRotate1) {
        this.toggleLeftRotate1 = toggleLeftRotate1;
    }

    public boolean isToggleRightRotate1() {
        return toggleRightRotate1;
    }
    public void setToggleRightRotate1(boolean toggleRightRotate1) {
        this.toggleRightRotate1 = toggleRightRotate1;
    }

    public boolean isToggleForward1() {
        return toggleForward1;
    }
    public void setToggleForward1(boolean toggleForward1) {
        this.toggleForward1 = toggleForward1;
    }

    public boolean isToggleBackward1() {
        return toggleBackward1;
    }
    public void setToggleBackward1(boolean toggleBackward1) {
        this.toggleBackward1 = toggleBackward1;
    }

    /** Player 2 Get/Set **/
    public boolean isToggleForward2() {
        return toggleForward2;
    }

    public void setToggleForward2(boolean toggleForward2) {
        this.toggleForward2 = toggleForward2;
    }

    public boolean isToggleBackward2() {
        return toggleBackward2;
    }

    public void setToggleBackward2(boolean toggleBackward2) {
        this.toggleBackward2 = toggleBackward2;
    }

    public boolean isShoot2() {
        return shoot2;
    }

    public void setShoot2(boolean shoot2) {
        this.shoot2 = shoot2;
    }

    public boolean isToggleLeftRotate2() {
        return toggleLeftRotate2;
    }

    public void setToggleLeftRotate2(boolean toggleLeftRotate2) {
        this.toggleLeftRotate2 = toggleLeftRotate2;
    }

    public boolean isToggleRightRotate2() {
        return toggleRightRotate2;
    }

    public void setToggleRightRotate2(boolean toggleRightRotate2) {
        this.toggleRightRotate2 = toggleRightRotate2;
    }


    public void tick() {
        for (int i = 0; i < objectList.size(); i++) {
            GameObject temp = objectList.get(i);
            temp.tick();

            if (temp.getId().equals(ID.Player1)) {
                if(((Player) temp).getLives() == 0) {
                    player2Win = true;
                }
            } else if (temp.getId().equals(ID.Player2)) {
                if(((Player) temp).getLives() == 0) {
                    player1Win = true;
                }
            }
        }

        /** Health Pack Spawn **/

        if (healthPacks < maxHealthPacks && healthPackTimer == 0) {
            int tempx = (int) (Math.random() * (mapWidth - 64) + (0 + 64));
            int tempy = (int) (Math.random() * (mapHeight - 64) + (0 + 64));

            for (int i = 0; i < objectList.size(); i++) {
                temp = new Rectangle(tempx,tempy,64,64);

                while (temp.intersects(objectList.get(i).getBounds())) {
                    tempx = (int) (Math.random() * ((mapWidth + 64) - (0 + 64)) + (0 + 64));
                    tempy = (int) (Math.random() * ((mapHeight + 64) - (0 + 64)) + (0 + 64));

                    temp = new Rectangle(tempx,tempy,64,64);
                }
            }

            addObject(new HealthPowerUp(tempx,tempy, ID.HealthPowerUp, this));

            healthPackTimer = 100;
            healthPacks++;
        }

        healthPackTimer--;
    }

    public void render(Graphics g) {
        for (int i = 0; i < objectList.size(); i++) {
            GameObject temp = objectList.get(i);

            temp.render(g);
        }
    }

    public void addObject(GameObject temp) {
        objectList.add(temp);
    }

    public void removeObject(GameObject temp) {
        objectList.remove(temp);
    }

    public LinkedList<GameObject> getList() {
        return this.objectList;
    }

    public boolean getPlayer1Win() {return player1Win;}
    public boolean getPlayer2Win() {return player2Win;}
}
