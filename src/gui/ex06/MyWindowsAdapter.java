package gui.ex06;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowsAdapter extends WindowAdapter {
	public void windowsClosing(WindowEvent e){
		System.exit(0);
	}

}
