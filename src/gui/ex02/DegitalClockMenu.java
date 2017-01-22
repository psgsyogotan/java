package gui.ex02;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DegitalClockMenu extends Frame implements ActionListener {

	// MenuBar作成
	MenuBar mb = new MenuBar();

	public DegitalClockMenu() {
		Menu mn1 = new Menu("ファイル");
		MenuItem close = new MenuItem("閉じる");
		MenuItem property = new MenuItem("プロパティ");
		// MenuItem nazobeme = new MenuItem("ナゾベーム");

		mb.add(mn1);

		mn1.add(close);
		mn1.add(property);
		// mn1.add(nazobeme);
		property.addActionListener(this);
		// nazobeme.addActionListener(this);
		close.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "閉じる") {
			System.exit(0);
		} else if (e.getActionCommand() == "プロパティ") {
			Dialog dig = null;
			DegitalClockDialog dialog = new DegitalClockDialog(dig);
			dialog.show();
		}

	}

}
