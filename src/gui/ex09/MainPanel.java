package gui.ex09;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable, KeyListener {
	// パネルサイズ
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;

	private static final int LEFT = 0;
	private static final int RIGHT = 1;

	private static final int NUM_SHOT = 5;
	private static final int FIRE_INTERVAL = 300;

	private static final int NUM_ALIEN = 50;
	private static final int NUM_BEAM = 20;

	private Player player;
	private Shot[] shots;
	private long lastFire = 0;
	private Alien[] aliens;
	private Beam[] beams;

	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean firePressed = false;

	private Thread gameLoop;

	private Random rand;

	public MainPanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);

		initGame();

		rand = new Random();

		addKeyListener(this);

		gameLoop = new Thread(this);
		gameLoop.start();
	}

	/**
	 * ゲームループ
	 */
	public void run() {

		while (true) {
			move();
			if (firePressed) {
				tryToFire();
			}
			alienAttack();
			collisionDetection();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void initGame() {
		player = new Player(0, HEIGHT - 20, this);

		shots = new Shot[NUM_SHOT];
		for (int i = 0; i < NUM_SHOT; i++) {
			shots[i] = new Shot(this);
		}

		aliens = new Alien[NUM_ALIEN];
		for (int i = 0; i < NUM_ALIEN; i++) {
			aliens[i] = new Alien(20 + (i % 10) * 40, 20 + (i / 10) * 40, 3, this);
		}

		beams = new Beam[NUM_BEAM];
		for (int i = 0; i < NUM_BEAM; i++) {
			beams[i] = new Beam(this);
		}
	}

	private void move() {
		if (leftPressed) {
			player.move(LEFT);
		} else if (rightPressed) {
			player.move(RIGHT);
		}

		for (int i = 0; i < NUM_ALIEN; i++) {
			aliens[i].move();
		}

		for (int i = 0; i < NUM_SHOT; i++) {
			shots[i].move();
		}

		for (int i = 0; i < NUM_BEAM; i++) {
			beams[i].move();
		}
	}

	/**
	 * 弾を発射する
	 */
	private void tryToFire() {
		if (System.currentTimeMillis() - lastFire < FIRE_INTERVAL) {
			return;
		}

		lastFire = System.currentTimeMillis();
		for (int i = 0; i < NUM_SHOT; i++) {
			if (shots[i].isInStorage()) {
				Point pos = player.getPos();
				shots[i].setPos(pos.x + player.getWidth() / 2, pos.y);
				break;
			}
		}
	}

	private void alienAttack() {
		for (int i = 0; i < NUM_BEAM; i++) {
			int n = rand.nextInt(NUM_ALIEN);
			if (aliens[n].isAlive()) {
				for (int j = 0; j < NUM_BEAM; j++) {
					if (beams[j].isInStorage()) {
						Point pos = aliens[n].getPos();
						beams[j].setPos(pos.x + aliens[n].getWidth() / 2, pos.y);
						break;
					}
				}
			}
		}
	}

	private void collisionDetection() {

		for (int i = 0; i < NUM_ALIEN; i++) {
			for (int j = 0; j < NUM_SHOT; j++) {
				if (aliens[i].collideWith(shots[j])) {

					aliens[i].die();
					shots[j].store();
					break;
				}
			}
		}

		for (int i = 0; i < NUM_BEAM; i++) {
			if (player.collideWith(beams[i])) {
				beams[i].store();
				initGame();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		player.draw(g);

		for (int i = 0; i < NUM_ALIEN; i++) {
			aliens[i].draw(g);
		}

		for (int i = 0; i < NUM_SHOT; i++) {
			shots[i].draw(g);
		}

		for (int i = 0; i < NUM_BEAM; i++) {
			beams[i].draw(g);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if (key == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		if (key == KeyEvent.VK_SPACE) {
			firePressed = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
		if (key == KeyEvent.VK_SPACE) {
			firePressed = false;
		}
	}
}