package gui.ex09;

import java.awt.Container;

import javax.swing.JFrame;

public class Invader extends JFrame {
	public Invader() {
		setTitle("エイリアンの攻撃");
		setResizable(false);

		MainPanel panel = new MainPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);

		pack();
	}

}