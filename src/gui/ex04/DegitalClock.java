package gui.ex04;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import gui.ex03.MyMouseAdapter;

public class DegitalClock extends Frame implements Runnable{
	int hour;
	int minute;
	int second;

	int mojisize = 40;
	String mojicolor = "black";
	String color = "white";
	String mojifont = "serif";

	int xframemag = 6;
	int yframemag = 4;
	
	private Preferences prefs = Preferences.userNodeForPackage(this.getClass());;

	public DegitalClock() {
		super();	
		mojisize = prefs.getInt("mojisize", 40);
		mojifont = prefs.get("mojifont", "serif");
		mojicolor = prefs.get("mojicolor", "black");
		color= prefs.get("mojisize", "white");
		
		setSize(300, 300);
		setVisible(true);
		setResizable(false);
		addWindowListener(new MyWindowsAdapter());

		DegitalClockMenu clockmenu = new DegitalClockMenu(this);
		MyMouseAdapter mma = new MyMouseAdapter(this);
		

	}

	public void run() {
		while (true) {
			Calendar calendar = Calendar.getInstance();
			hour = calendar.get(Calendar.HOUR);
			minute = calendar.get(Calendar.MINUTE);
			second = calendar.get(Calendar.SECOND);

			repaint();
			try {
				Thread.sleep(100);
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
		Image imgBuf = createImage(imagex, imagey);
		Graphics gBuf = imgBuf.getGraphics();
		Font font = new Font(mojifont, Font.BOLD, mojisize);
		gBuf.setFont(font);
		FontMetrics fm = gBuf.getFontMetrics();
		Rectangle rectText = fm.getStringBounds(text, gBuf).getBounds();

		int mojix = (x - rectText.width) / 2;
		int mojiy = (y - rectText.height) / 2 + fm.getMaxAscent() + 10;

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
	
	public class MyWindowsAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e){
			
			prefs.put("mojicolor", mojicolor);
			prefs.put("mojifont", mojifont);
			prefs.put("color", color);
			prefs.putInt("mojisize", mojisize);
			try {
				prefs.flush();
			} catch (BackingStoreException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			System.exit(0);
		}
		

	}



}
