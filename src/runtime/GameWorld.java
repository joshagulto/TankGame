package runtime;

import gameObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameWorld extends JPanel implements Runnable{

    private boolean isRunning = false;
    private Thread thread;
    private EventHandler eventHandler;
    private Camera camera1;

    private BufferedImage map;
    private BufferedImage grass;
    private BufferedImage gameOver;
    private BufferedImage player1Win;
    private BufferedImage player2Win;

    public GameWorld() {
        BufferedImageLoader loader = new BufferedImageLoader();
        map = loader.loadImage("/graphics/backdrop.png");
        grass = loader.loadImage("/graphics/grass.png");
        gameOver = loader.loadImage("/graphics/gameOver.png");
        player1Win = loader.loadImage("/graphics/player1Win.png");
        player2Win = loader.loadImage("/graphics/player2Win.png");

        eventHandler = new EventHandler();

        this.addKeyListener(new KeyInput(eventHandler));

        camera1 = new Camera(0,0);
        loadLevel(map);

        init();
        start();
    }

    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    private void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double tickRate = 60;
        double ns = 1000000000 / tickRate;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }

            repaint();

            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void tick() {
        for (int i = 0; i < eventHandler.objectList.size(); i++) {
            if (eventHandler.objectList.get(i).getId() == ID.Player1) {
                camera1.tick(eventHandler.objectList.get(i));
            }
        }

        eventHandler.tick();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.translate(-camera1.getX(), -camera1.getY());

        g2d.drawImage(grass,0,0,null);

        eventHandler.render(g);

        if (eventHandler.getPlayer1Win() || eventHandler.getPlayer2Win()) {
            g.drawImage(gameOver,camera1.getX()+ 360,camera1.getY() + 100,null);

            if (eventHandler.getPlayer1Win()) {
                g.drawImage(player1Win,camera1.getX()+ 180,camera1.getY() + 400,null);
            } else {
                g.drawImage(player2Win,camera1.getX()+ 170,camera1.getY() + 400,null);
            }
        }

        g2d.translate(camera1.getX(), camera1.getY());

        g.dispose();
        g2d.dispose();
    }

    private void loadLevel(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int xx = 0; xx < w; xx++) {
            for (int yy = 0; yy < h; yy++) {
                int pixel =  image.getRGB(xx,yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8 ) & 0xff;
                int blue = (pixel) & 0xff;

                if (green == 0 && blue == 0 && red == 255) eventHandler.addObject(new Rock(xx*64,yy*64,ID.Rock));
                if (green == 0 && blue == 255 && red == 0) eventHandler.addObject(new Player(xx*64,yy*64,ID.Player1,eventHandler));
                if (green == 255 && blue == 255 && red == 0) eventHandler.addObject(new Player(xx*64,yy*64,ID.Player2,eventHandler));
                if (green == 255 && blue == 0 && red == 0) eventHandler.addObject(new Tree(xx*64,yy*64,ID.Tree, eventHandler));
            }
        }
    }

    public void init() {
        JFrame window = new JFrame("Tanky Boyz");

        window.setPreferredSize(new Dimension(1280,720));
        window.setMaximumSize(new Dimension(1280,720));
        window.setMinimumSize(new Dimension(1280,720));

        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.add(this);

        window.setVisible(true);
    }

    public static void main(String args[]) {
        new GameWorld();
    }
}





