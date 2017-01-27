package gui.ex04;

import java.awt.Dialog;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DegitalClockMenu implements ActionListener {

	// MenuBar作成
	MenuBar mb = new MenuBar();
	DegitalClock frame;

	public DegitalClockMenu(DegitalClock frame) {
		this.frame = frame;
		Menu mn1 = new Menu("ファイル");
		MenuItem property = new MenuItem("プロパティ");

		frame.setMenuBar(mb);
		mb.add(mn1);

		mn1.add(property);
		property.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "プロパティ") {
			Dialog dig = null;
			DegitalClockDialog2 dcd = new DegitalClockDialog2(frame);
			dcd.show();
		}
	}

}
