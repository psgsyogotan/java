package gui.ex04;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DegitalClockDialog2 extends Dialog implements ActionListener {

	// Okボタン
	Button b1 = new Button("OK");
	//キャンセルボタン
	Button b2 = new Button("キャンセル");
	// 背景色
	Choice backcolor = new Choice();
	// フォント
	Choice mojifont = new Choice();
	// 文字サイズ
	Choice mojisize = new Choice();
	// 文字色
	Choice mojicolor = new Choice();

	DegitalClock dc;
	GridBagLayout grid = new GridBagLayout();

	public DegitalClockDialog2(DegitalClock frame) {
		super(frame);
		dc = frame;
		setLayout(grid);

		setTitle("プロパティ");
		setSize(200, 150);
		setResizable(false);
	
		addWindowListener(new MyWindowsListenerForDialog());
		

		// ラベル
		Label backcolorlabel = new Label("背景色");
		Label fontlabel = new Label("フォント");
		Label mojisizelabel = new Label("文字サイズ");
		Label mojicolorlabel = new Label("文字カラー");

		//
		if (frame.color == "white") {
			backcolor.add("white");
			backcolor.add("black");
		} else {
			backcolor.add("black");
			backcolor.add("white");
		}
		addComponent(backcolor, 0, 0, 1, 1);
		addComponentOnLabel(backcolorlabel, 2, 0, 1, 1);

		// フォント
		if (frame.mojifont == " sans-serif") {
			mojifont.add("serif");
			mojifont.add("sans-serif");
		} else {
			mojifont.add("sans-serif");
			mojifont.add("serif");
		}

		addComponent(mojifont, 0, 1, 1, 1);
		addComponentOnLabel(fontlabel, 2, 1, 1, 1);

		// 文字サイズ
		if (frame.mojisize == 40) {
			mojisize.add("40");
			mojisize.add("50");
		} else {
			mojisize.add("50");
			mojisize.add("40");
		}
		addComponent(mojisize, 0, 2, 1, 1);
		addComponentOnLabel(mojisizelabel, 2, 2, 1, 1);

		// 文字カラー
		if (frame.mojicolor == "white") {
			mojicolor.add("white");
			mojicolor.add("black");
		} else {
			mojicolor.add("black");
			mojicolor.add("white");
		}
		addComponent(mojicolor, 0, 3, 1, 1);
		addComponentOnLabel(mojicolorlabel, 2, 3, 1, 1);

		b1.addActionListener(this);
		addComponent(b1, 1, 4, 1, 1);
		b2.addActionListener(this);
		addComponent(b2, 2, 4, 1, 1);
		

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "OK") {

			dc.color = backcolor.getSelectedItem();
			dc.mojifont = mojifont.getSelectedItem();
			dc.mojicolor = mojicolor.getSelectedItem();
			dc.mojisize = Integer.parseInt(mojisize.getSelectedItem());

			hide();
		}
		else if(e.getActionCommand() == "キャンセル"){
			hide();
		}

	}

	void addComponent(Component com, int x, int y, int w, int h) {
		GridBagConstraints gridcom = new GridBagConstraints();
		gridcom.anchor = GridBagConstraints.WEST;
		gridcom.fill = GridBagConstraints.BOTH;
		gridcom.gridx = x;
		gridcom.gridy = y;
		gridcom.gridwidth = w;
		gridcom.gridheight = h;
		grid.setConstraints(com, gridcom);
		add(com);
	}
	
	void addComponentOnLabel(Component com, int x, int y, int w, int h) {
		GridBagConstraints gridcom = new GridBagConstraints();
		gridcom.anchor = GridBagConstraints.EAST;		
		gridcom.gridx = x;
		gridcom.gridy = y;
		gridcom.gridwidth = w;
		gridcom.gridheight = h;
		grid.setConstraints(com, gridcom);
		add(com);
	}
	
	public class MyWindowsListenerForDialog  extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			hide();
		}
		
	}



}
