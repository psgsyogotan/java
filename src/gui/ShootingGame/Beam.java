package gui.ShootingGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Beam {
	private static final int SPEED = 5;
	private static final Point STORAGE = new Point(-20, -20);

	private int x;
	private int y;
	private int width;
	private int height;
	private Image image;

	private MainPanel panel;

	public Beam(MainPanel panel) {
		x = STORAGE.x;
		y = STORAGE.y;
		this.panel = panel;

		loadImage();
	}

	public void move() {
		if (isInStorage())
			return;

		y += SPEED;
		if (y > MainPanel.HEIGHT) {
			store();
		}
	}

	public Point getPos() {
		return new Point(x, y);
	}

	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void store() {
		x = STORAGE.x;
		y = STORAGE.y;
	}

	public boolean isInStorage() {
		if (x == STORAGE.x && y == STORAGE.x)
			return true;
		return false;
	}

	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}

	private void loadImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource("beam.gif"));
		image = icon.getImage();

		width = image.getWidth(panel);
		height = image.getHeight(panel);
	}
}