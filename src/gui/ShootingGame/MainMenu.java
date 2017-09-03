package gui.ShootingGame;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainMenu extends Frame {
	private final int CLOCKSNUM = 7;

	Image mainPic;
	private int level;
	Choice choice;
	Choice character;
	Label label;

	public MainMenu() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		mainPic = tk.getImage("C:\\Users\\Syogo\\git\\java\\src\\gui\\ShootingGame\\Zaku.jpg");
		addWindowListener(new MyWindowAdapter());
		setSize(320, 500);
		setVisible(true);
		setResizable(false);
		choice = new Choice();
		character = new Choice();
		setLayout(null);
	}

	public void paint(Graphics g) {
		g.drawImage(mainPic, 0, 20, this);
	}

	private void showList(int level) {
		for (int i = 0; i <= level; i++) {
			choice.add("難易度" + (i + 1));
		}
		choice.setBounds(50, 260, 220, 40);

		this.add(choice);
	}

	private void showCharacter() {

		Font f = new Font("Arial", Font.BOLD, 14);
		label = new Label("キャラクター選択");
		label.setBounds(90, 320, 220, 40);
		label.setFont(f);
		this.add(label);

		character.add("村瀬慶和");
		character.add("手島史博");
		character.add("井上優希");
		character.add("柴田さん");
		character.setBounds(50, 360, 220, 40);
		this.add(character);
	}

	public void intMainMenu() {

		showList(CLOCKSNUM);
		showCharacter();

		Button showStartButton = new Button("ゲーム開始");
		showStartButton.setBounds(120, 400, 80, 40);
		this.add(showStartButton);

		showStartButton.addActionListener((e -> {
			Game frame = new Game((choice.getSelectedIndex() + 1), character.getSelectedIndex());
			frame.setVisible(true);
		}));
	}

	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.intMainMenu();

	}

}

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}