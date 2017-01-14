package gui.ex02;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DegitalClockDialog extends Dialog implements ActionListener {

	// Okボタン
	Button b1 = new Button("OK");
	// 背景色
	Choice backcolor = new Choice();
	// フォント
	Choice mojifont = new Choice();
	// 文字サイズ
	Choice mojisize = new Choice();
	// 文字色
	Choice mojicolor = new Choice();

	public DegitalClockDialog(Dialog owner) {
		super(owner);
		setLayout(new GridLayout(5, 2));

		setTitle("プロパティ");
		setSize(200, 300);

		// ラベル
		Label backcolorlabel = new Label("背景色");
		Label fontlabel = new Label("フォント");
		Label mojisizelabel = new Label("文字サイズ");
		Label mojicolorlabel = new Label("文字カラー");

		// 背景色候補
		add(backcolorlabel);
		if (DegitalClock.color == "white") {
			backcolor.add("white");
			backcolor.add("black");
			add(backcolor);
		} else {
			backcolor.add("black");
			backcolor.add("white");
			add(backcolor);
		}

		// フォント
		add(fontlabel);
		if (DegitalClock.mojifont == " sans-serif") {
			mojifont.add("serif");
			mojifont.add("sans-serif");
			add(mojifont);
		} else {
			mojifont.add("sans-serif");
			mojifont.add("serif");
			add(mojifont);
		}

		// 文字サイズ
		add(mojisizelabel);
		if (DegitalClock.mojisize == 40) {
			mojisize.add("40");
			mojisize.add("50");
			add(mojisize);
		} else {
			mojisize.add("50");
			mojisize.add("40");
			add(mojisize);
		}

		// 文字カラー
		add(mojicolorlabel);
		if (DegitalClock.mojicolor == "white") {
			mojicolor.add("white");
			mojicolor.add("black");
			add(mojicolor);
		} else {
			mojicolor.add("black");
			mojicolor.add("white");
			add(mojicolor);

		}
		b1.addActionListener(this);
		add(b1);

		show();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "OK") {

			if (Integer.parseInt(mojisize.getSelectedItem()) != DegitalClock.mojisize)
				DegitalClock.frameflag = true;

			DegitalClock.color = backcolor.getSelectedItem();
			DegitalClock.mojifont = mojifont.getSelectedItem();
			DegitalClock.mojicolor = mojicolor.getSelectedItem();
			DegitalClock.mojisize = Integer.parseInt(mojisize.getSelectedItem());

			hide();
		}

	}

}
