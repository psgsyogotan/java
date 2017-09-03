package gui.ShootingGame;

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

	public int NUM_SHOT;
	private static final int FIRE_INTERVAL = 300;

	private final static int MURASE = 0;
	private final static int TESHIMA = 1;
	private final static int INOUE = 2;
	private final static int SHIBATA = 3;

	private int NUM_ALIEN = 50;
	private int NUM_BEAM = 20;

	private Player player;
	private Bullet[] bullets;
	private long lastFire = 0;
	private Enemy[] enemy;
	private Beam[] beams;

	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean firePressed = false;

	private Configuration configuration;
	private boolean isGameOver = false;

	private Game game;
	private Thread gameLoop;

	private Random rand;

	public MainPanel(Configuration configuration, Game game, int characterIndex) {
		this.configuration = configuration;
		NUM_ALIEN = configuration.getEnemyLevel() * 8;
		NUM_BEAM = configuration.getBeamLevel() * 3;
		this.game = game;

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);

		initGame(characterIndex);

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
			if (isGameOver == true) {
				return;
			}
			if (isClear() == true) {
				game.showClearScreen(configuration);
				return;
			}
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

	private void initGame(int characterIndex) {
		if (characterIndex == MURASE) {
			player = new Murase(0, HEIGHT - 30, this);
			NUM_SHOT = 1;
		} else if (characterIndex == TESHIMA) {
			player = new Teshima(0, HEIGHT - 100, this);
			NUM_SHOT = 3;
		} else if (characterIndex == INOUE) {
			player = new Inoue(0, HEIGHT - 30, this);
			NUM_SHOT = 5;
		} else if (characterIndex == SHIBATA) {
			player = new Shibata(0, HEIGHT - 30, this);
			NUM_SHOT = 1000;
		} else {
			player = new Murase(0, HEIGHT - 30, this);
		}

		bullets = new Bullet[NUM_SHOT];
		for (int i = 0; i < NUM_SHOT; i++) {
			bullets[i] = new Bullet(this, player.getBulletSpeed());
		}

		enemy = new Enemy[NUM_ALIEN];
		for (int i = 0; i < NUM_ALIEN; i++) {
			enemy[i] = new Enemy(20 + (i % 10) * 40, 20 + (i / 10) * 40, 3, this);
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
			enemy[i].move();
		}

		for (int i = 0; i < NUM_SHOT; i++) {
			bullets[i].move();
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
			if (bullets[i].isInStorage()) {
				Point pos = player.getPos();
				bullets[i].setPos(pos.x + player.getWidth() / 2, pos.y);
				break;
			}
		}
	}

	private void alienAttack() {
		for (int i = 0; i < NUM_BEAM; i++) {
			int n = rand.nextInt(NUM_ALIEN);
			if (enemy[n].isAlive()) {
				for (int j = 0; j < NUM_BEAM; j++) {
					if (beams[j].isInStorage()) {
						Point pos = enemy[n].getPos();
						beams[j].setPos(pos.x + enemy[n].getWidth() / 2, pos.y);
						break;
					}
				}
			}
		}
	}

	private void collisionDetection() {

		for (int i = 0; i < NUM_ALIEN; i++) {
			for (int j = 0; j < NUM_SHOT; j++) {
				if (enemy[i].collideWith(bullets[j])) {
					enemy[i].die();
					bullets[j].store();
					break;
				}
			}
		}

		for (int i = 0; i < NUM_BEAM; i++) {
			if (player.collideWith(beams[i])) {
				beams[i].store();

				game.showGameOver();
				isGameOver = true;
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		player.draw(g);

		for (int i = 0; i < NUM_ALIEN; i++) {
			enemy[i].draw(g);
		}

		for (int i = 0; i < NUM_SHOT; i++) {
			bullets[i].draw(g);
		}

		for (int i = 0; i < NUM_BEAM; i++) {
			beams[i].draw(g);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public Boolean isClear() {
		for (int i = 0; i < enemy.length; i++) {
			if (enemy[i].isAlive() == true)
				return false;
		}
		return true;
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