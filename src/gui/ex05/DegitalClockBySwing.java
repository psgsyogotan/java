package gui.ex05;

import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.ex01.MyWindowsAdapter;

public class DegitalClockBySwing extends JFrame {




	public DegitalClockBySwing() {
		setSize(300, 300);
		setVisible(true);
		setResizable(false);
		addWindowListener(new MyWindowsAdapter());
		DegitalClockPanel dcp = new DegitalClockPanel();
		add(dcp);
		Thread thread = new Thread(dcp);
		thread.start();

	}


	private class DegitalClockPanel extends JPanel implements Runnable{

		int hour;
		int minute;
		int second;
		Calendar calendar;

		public DegitalClockPanel(){
			this.setDoubleBuffered(true);
		}


		public void run() {
			while (true) {
				calendar = Calendar.getInstance();
				hour = calendar.get(Calendar.HOUR);
				minute = calendar.get(Calendar.MINUTE);
				second = calendar.get(Calendar.SECOND);
				repaint();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

			}

		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawString(hour + ":" + minute + ":" + second, 140, 150);
		}
	}




}