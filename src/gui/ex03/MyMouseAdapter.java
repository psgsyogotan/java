package gui.ex03;

import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseAdapter extends MouseAdapter {
	int x;
	int y;
	Window window;

	public MyMouseAdapter(Window window) {
		this.window = window;
		window.addMouseListener(this);
		window.addMouseMotionListener(this);
	}

	public void mousePressed(MouseEvent e) {
		x = e.getXOnScreen() - window.getX();
		y = e.getYOnScreen() - window.getY();

	}

	public void mouseDragged(MouseEvent e) {
		
		int setx = e.getXOnScreen() - x;
		int sety = e.getYOnScreen() - y;
		window.setLocation(setx, sety);

	}

}
