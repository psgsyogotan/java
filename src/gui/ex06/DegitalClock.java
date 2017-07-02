package gui.ex06;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Calendar;

import javax.swing.JFrame;

import gui.ex01.MyWindowsAdapter;

public class DegitalClock extends JFrame implements Runnable {
	// 時刻
	int hour;
	int minute;
	int second;

	// フレームの大きさは時刻の文字列と下の倍率の積で計算
	int xframemag = 15;
	int yframemag = 10;

	// 時刻の文字列情報
	static int mojisize = 40;
	static String mojicolor = "black";
	static String color = "white";
	static String mojifont = "serif";

	// 画面の大きさ変更フラグ
	static boolean frameflag = false;

	public DegitalClock() {
		setSize(mojisize * xframemag, mojisize * yframemag);
		addWindowListener(new MyWindowsAdapter());
		DegitalClockMenu dcm = new DegitalClockMenu();
		setMenuBar(dcm.mb);
		setVisible(true);

	}

	@Override
	public void run() {
		while (true) {
			Calendar calendar = Calendar.getInstance();
			hour = calendar.get(Calendar.HOUR);
			minute = calendar.get(Calendar.MINUTE);
			second = calendar.get(Calendar.SECOND);

			if (frameflag) {
				frameflag = false;
				setSize(mojisize * xframemag, mojisize * yframemag);
			}

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
		int x = this.getSize().width;
		int y = this.getSize().height;

		int imagex = mojisize * xframemag * 10;
		int imagey = mojisize * yframemag * 10;

		this.setSize(mojisize * xframemag, mojisize * yframemag);
		Image imgBuf = createImage(mojisize * xframemag * 10, mojisize * yframemag * 10);
		Graphics gBuf = imgBuf.getGraphics();
		Font font = new Font(mojifont, Font.BOLD, mojisize);
		gBuf.setFont(font);
		FontMetrics fm = gBuf.getFontMetrics();
		Rectangle rectText = fm.getStringBounds(text, gBuf).getBounds();

		int mojix = (x - rectText.width) / 2;
		int mojiy = (y - rectText.height) / 2 + fm.getMaxAscent();

		if (color.equals("white"))
			gBuf.setColor(Color.white);
		else if (color.equals("black"))
			gBuf.setColor(Color.black);
		gBuf.fillRect(0, 0, imagex, imagey);

		if (mojicolor.equals("black"))
			gBuf.setColor(Color.black);
		else if (mojicolor.equals("white")) {
			gBuf.setColor(Color.WHITE);
		}
		gBuf.drawString(text, mojix, mojiy);

		g.drawImage(imgBuf, 0, 0, this);

	}

	public void update(Graphics g) {
		paint(g);
	}

}
