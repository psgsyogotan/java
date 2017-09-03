package gui.ShootingGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy {
	private static final int MOVE_WIDTH = 210;
	private static final Point TOMB = new Point(-50, -50);

	private int speed;

	private int x;
	private int y;
	private int width;
	private int height;
	private Image image;

	private int left;
	private int right;

	private boolean isAlive;

	private MainPanel panel;

	public Enemy(int x, int y, int speed, MainPanel panel) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.panel = panel;

		left = x;
		right = x + MOVE_WIDTH;
		isAlive = true;

		loadImage();
	}

	public void move() {
		x += speed;

		if (x < left) {
			speed = -speed;
		}
		if (x > right) {
			speed = -speed;
		}
	}

	public boolean collideWith(Bullet shot) {
		Rectangle rectAlien = new Rectangle(x, y, width, height);
		Point pos = shot.getPos();
		Rectangle rectShot = new Rectangle(pos.x, pos.y, shot.getWidth(), shot.getHeight());

		return rectAlien.intersects(rectShot);
	}

	public void die() {
		setPos(TOMB.x, TOMB.y);
		isAlive = false;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Point getPos() {
		return new Point(x, y);
	}

	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}

	private void loadImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource("Enemy.jpg"));
		image = icon.getImage();

		width = image.getWidth(panel);
		height = image.getHeight(panel);
	}
}