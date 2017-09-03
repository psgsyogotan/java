package gui.ShootingGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Bullet {
	// 弾のスピード
	public int SPEED;
	private static final Point STORAGE = new Point(-20, -20);

	private int x;
	private int y;
	private int width;
	private int height;
	private Image image;

	private MainPanel panel;

	public Bullet(MainPanel panel, int bulletSpeed) {
		x = STORAGE.x;
		y = STORAGE.y;
		this.panel = panel;
		this.SPEED = bulletSpeed;

		loadImage();
	}

	public void move() {
		if (isInStorage())
			return;

		y -= SPEED;
		if (y < 0) {
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
		// 弾を描画する
		g.drawImage(image, x, y, null);
	}

	private void loadImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource("bullet.png"));
		image = icon.getImage();

		// 幅と高さをセット
		width = image.getWidth(panel);
		height = image.getHeight(panel);
	}

}