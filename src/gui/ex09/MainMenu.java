package gui.ex09;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainMenu extends Frame {

	Image mainPic;
	private int level;
	Choice choice;

	public MainMenu() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		mainPic = tk.getImage("C:\\Users\\Syogo\\git\\java\\src\\gui\\ex09\\Zaku.jpg");
		addWindowListener(new MyWindowAdapter());
		setSize(320, 500);
		setVisible(true);
		setResizable(false);
		choice = new Choice();
		setLayout(null);
	}

	public void paint(Graphics g) {
		g.drawImage(mainPic, 0, 20, this);
	}

	private void showList(int level) {
		for (int i = 0; i <= level; i++) {
			choice.add("時計" + (i + 1));
		}
		choice.setBounds(50, 260, 220, 40);

		this.add(choice);
	}

	public void intMainMenu(int level) {

		Button showClockButton = new Button("時計を表示");
		showClockButton.setBounds(120, 300, 80, 40);
		this.add(showClockButton);

		showList(level);

		Button showStartButton = new Button("ゲーム開始");
		showStartButton.setBounds(120, 400, 80, 40);
		this.add(showStartButton);

		showClockButton.addActionListener((e -> new Clocks(choice.getSelectedItem()).show()));
		showStartButton.addActionListener((e -> {
			Invader frame = new Invader();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}));
	}

	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.intMainMenu(7);

	}

}

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}