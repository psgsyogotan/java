package gui.ex03;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClockMenu extends MouseAdapter implements ActionListener {

	PopupMenu popupmenu;
	Window window;

	public ClockMenu(Window window) {
		this.window = window;
		popupmenu = new PopupMenu();
		window.add(popupmenu);

		// 文字サイズのメニュー
		Menu sizemenu = new Menu("文字サイズ");
		MenuItem sizeitem1 = new MenuItem("30");
		MenuItem sizeitem2 = new MenuItem("50");
		popupmenu.add(sizemenu);
		sizemenu.add(sizeitem1);
		sizemenu.add(sizeitem2);
		sizeitem1.addActionListener(this);
		sizeitem2.addActionListener(this);

		// 文字フォントのメニュー
		Menu fontmenu = new Menu("文字フォント");
		MenuItem fontitem1 = new MenuItem("serif");
		MenuItem fontitem2 = new MenuItem("sans-serif");
		popupmenu.add(fontmenu);
		fontmenu.add(fontitem1);
		fontmenu.add(fontitem2);
		fontitem1.addActionListener(this);
		fontitem2.addActionListener(this);

		// 文字色のメニュー
		Menu colormenu = new Menu("文字色");
		MenuItem coloritem1 = new MenuItem("white");
		MenuItem coloritem2 = new MenuItem("black");
		popupmenu.add(colormenu);
		colormenu.add(coloritem1);
		colormenu.add(coloritem2);
		coloritem1.addActionListener(this);
		coloritem2.addActionListener(this);

		// 文字カラーのメニュー
		Menu backcolormenu = new Menu("背景色");
		MenuItem backcoloritem1 = new MenuItem("white");
		MenuItem backcoloritem2 = new MenuItem("black");
		popupmenu.add(backcolormenu);
		backcolormenu.add(backcoloritem1);
		backcolormenu.add(backcoloritem2);
		backcoloritem1.addActionListener(this);
		backcoloritem2.addActionListener(this);
		
		MenuItem end = new MenuItem("終了");
		popupmenu.add(end);
		

		popupmenu.addActionListener(this);	
		window.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			popupmenu.show(e.getComponent(), e.getX(), e.getY());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()== "終了"){
			System.exit(0);
			;
	
		}
		// TODO 自動生成されたメソッド・スタブ

	}
}
