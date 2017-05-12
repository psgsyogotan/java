package gui.ex05;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowsAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}



}
