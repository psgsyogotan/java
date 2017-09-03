package gui.ShootingGame;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Game extends JFrame {
	public Game(int level, int characterIndex) {
		setTitle("Game");

		setResizable(false);

		Configuration config = new Configuration(level);
		MainPanel panel = new MainPanel(config, this, characterIndex);
		Container contentPane = getContentPane();
		contentPane.add(panel);

		pack();
	}

	public void showGameOver() {
		JDialog dialog = new JDialog(this, "Game Over");
		dialog.setLocationRelativeTo(this);
		dialog.setSize(200, 160);
		dialog.setVisible(true);
		JButton button = new JButton("OK");
		dialog.add(button);
		button.setBounds(50, 50, 100, 60);
		button.setVisible(true);

		button.addActionListener(e -> {
			this.dispose();
		});
	}

	public void showClearScreen(Configuration configuration) {
		Clocks clock = new Clocks(configuration.getLevel());
		JDialog dialog = new JDialog(this, "Game Clear");
		dialog.setLocationRelativeTo(this);
		dialog.setSize(200, 160);
		dialog.setVisible(true);
		JButton button = new JButton("OK");
		dialog.add(button);
		button.setBounds(50, 50, 100, 60);
		button.setVisible(true);

		button.addActionListener(e -> {
			this.dispose();
			clock.show();

		});
	}

}
