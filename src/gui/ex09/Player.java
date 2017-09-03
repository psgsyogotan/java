package gui.ex09;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    private static final int SPEED = 5;

    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    private MainPanel panel;

    public Player(int x, int y, MainPanel panel) {
        this.x = x;
        this.y = y;
        this.panel = panel;

        loadImage();
    }

    public void move(int dir) {
        if (dir == LEFT) {
            x -= SPEED;
        } else if (dir == RIGHT) {
            x += SPEED;
        }

        if (x < 0) {
            x = 0;
        }
        if (x > MainPanel.WIDTH - width) {
            x = MainPanel.WIDTH - width;
        }
    }

    public boolean collideWith(Beam beam) {
        Rectangle rectPlayer = new Rectangle(x, y, width, height);
        Point pos = beam.getPos();
        Rectangle rectBeam = new Rectangle(pos.x, pos.y, 
                beam.getWidth(), beam.getHeight());

        return rectPlayer.intersects(rectBeam);
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public Point getPos() {
        return new Point(x, y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    private void loadImage() {

        ImageIcon icon = new ImageIcon(getClass().getResource(
                "player.jpg"));
        image = icon.getImage();

        width = image.getWidth(panel);
        height = image.getHeight(panel);
    }
}