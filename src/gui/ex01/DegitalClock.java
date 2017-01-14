package gui.ex01;

import java.awt.Frame;
import java.awt.Graphics;
import java.util.Calendar;

public class DegitalClock extends Frame implements Runnable {

	int hour;
	int minute;
	int second;

	public DegitalClock() {
		setSize(300, 300);
		setVisible(true);
		addWindowListener(new MyWindowsAdapter());
	}

	@Override
	public void run() {
		while (true) {
			Calendar calendar = Calendar.getInstance();
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

	public void paint(Graphics g) {
		g.drawString(hour + ":" + minute + ":" + second, 200, 100);
	}

}
