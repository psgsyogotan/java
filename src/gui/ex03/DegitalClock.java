package gui.ex03;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Window;
import java.util.Calendar;

public class DegitalClock extends Window implements Runnable {
	// 時刻
	int hour;
	int minute;
	int second;

	int mojisize = 40;
	String mojicolor = "black";
	String color = "white";
	String mojifont = "serif";

	int xframemag = 15;
	int yframemag = 10;

	Window window;

	public DegitalClock() {
		super(null);

		window = new Window(null);
		window.setSize(300, 300);
		window.setVisible(true);

		ClockMenu clockmenu = new ClockMenu(window);

	}

	public void run() {
		while (true) {
			Calendar calendar = Calendar.getInstance();
			hour = calendar.get(Calendar.HOUR);
			minute = calendar.get(Calendar.MINUTE);
			second = calendar.get(Calendar.SECOND);

			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

	}

	public void paint(Graphics g) {
		String text = hour + ":" + minute + ":" + second;
		int x = window.getSize().width;
		int y = window.getSize().height;

		Image imgBuf = createImage(mojisize * xframemag * 10, mojisize * yframemag * 10);
		Graphics gBuf = imgBuf.getGraphics();
		Font font = new Font(mojifont, Font.BOLD, mojisize);
		gBuf.setFont(font);
		FontMetrics fm = gBuf.getFontMetrics();
		Rectangle rectText = fm.getStringBounds(text, gBuf).getBounds();

		int mojix = (x - rectText.width) / 2;
		int mojiy = (y - rectText.height) / 2 + fm.getMaxAscent();

		if (mojicolor == "black")
			gBuf.setColor(Color.black);
		else if (mojicolor == "white") {
			gBuf.setColor(Color.WHITE);
		}
		if (color.equals("white"))
			gBuf.setColor(Color.white);
		else if (color.equals("black"))
			gBuf.setColor(Color.BLACK);

		gBuf.drawString(text, mojix, mojiy);

		g.drawImage(imgBuf, 0, 0, window);

		/*
		 * if (color.equals("white")) setBackground(Color.white); else if
		 * (color.equals("black")) setBackground(Color.BLACK);
		 */

	}

	public void update(Graphics g) {
		paint(g);
	}

}
