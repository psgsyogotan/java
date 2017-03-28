package interpret;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class InterpretGUI extends Frame implements ActionListener {

	Label inputClassNameLabel;
	TextField classInputText;
	Button classInputButton;

	Label SelectConstructorLabel;
	Choice constructorChoice;
	Button selectConstructorButton;

	Label inputArgumentLabel;
	TextField argumentInputText;
	Button argumentInputButton;

	Label instanceListLabel;
	java.awt.List instanceList;
	TextField inputValueToInstance;
	Button selectInstanceButton;

	Label arrayListLabel;
	java.awt.List arrayList;
	TextField inputValueToArray;
	Button selectArrayButton;

	Constructor[] constructors;
	ArrayList<String> getconstructorName;

	Class<?> c;
	Object instance;

	public InterpretGUI() {

		setSize(800, 700);
		setResizable(false);
		setVisible(true);
		setLayout(null);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});
	}

	void init() {
		inputClassName();
		selectConstructors();
		inputArgument();
		showInstanceList();
		showArray();

	}

	private void inputClassName() {
		inputClassNameLabel = new Label("1: input ClassName");
		inputClassNameLabel.setBounds(50, 50, 150, 25);
		inputClassNameLabel.setVisible(true);
		add(inputClassNameLabel);

		classInputText = new TextField();
		classInputText.setBounds(50, 75, 400, 25);
		classInputText.setVisible(true);
		add(classInputText);

		classInputButton = new Button("Input");
		classInputButton.setBounds(450, 75, 50, 25);
		classInputButton.addActionListener(this);
		classInputButton.setVisible(true);
		add(classInputButton);
	}

	private void selectConstructors() {
		SelectConstructorLabel = new Label("2: Select Constructor");
		SelectConstructorLabel.setBounds(50, 125, 150, 25);
		SelectConstructorLabel.setVisible(false);
		add(SelectConstructorLabel);

		constructorChoice = new Choice();
		constructorChoice.setBounds(50, 150, 450, 25);
		constructorChoice.setVisible(false);
		add(constructorChoice);

		selectConstructorButton = new Button("Select");
		selectConstructorButton.setBounds(450, 175, 50, 25);
		selectConstructorButton.addActionListener(this);
		selectConstructorButton.setVisible(false);
		add(selectConstructorButton);

	}

	private void inputArgument() {
		inputArgumentLabel = new Label("3: input Argument");
		inputArgumentLabel.setBounds(50, 200, 150, 25);
		inputArgumentLabel.setVisible(false);
		add(inputArgumentLabel);

		argumentInputText = new TextField();
		argumentInputText.setBounds(50, 225, 380, 25);
		argumentInputText.setVisible(false);
		add(argumentInputText);

		argumentInputButton = new Button("Generation");
		argumentInputButton.setBounds(430, 225, 70, 25);
		argumentInputButton.addActionListener(this);
		argumentInputButton.setVisible(false);
		add(argumentInputButton);
	}

	private void showInstanceList() {
		instanceListLabel = new Label("InstanceList");
		instanceListLabel.setBounds(550, 50, 150, 25);
		instanceListLabel.setVisible(false);
		add(instanceListLabel);

		instanceList = new List();
		instanceList.setBounds(550, 75, 200, 100);
		instanceList.setVisible(false);
		add(instanceList);

		inputValueToInstance = new TextField();
		inputValueToInstance.setBounds(550, 180, 150, 25);
		inputValueToInstance.setVisible(false);
		add(inputValueToInstance);

		selectInstanceButton = new Button("Input");
		selectInstanceButton.setBounds(700, 180, 50, 25);
		selectInstanceButton.addActionListener(this);
		selectInstanceButton.setVisible(false);
		add(selectInstanceButton);

	}

	private void showArray() {
		arrayListLabel = new Label("Array");
		arrayListLabel.setBounds(550, 215, 150, 25);
		arrayListLabel.setVisible(false);
		add(arrayListLabel);

		arrayList = new List();
		arrayList.setBounds(550, 240, 200, 100);
		arrayList.setVisible(false);
		add(arrayList);

		inputValueToArray = new TextField();
		inputValueToArray.setBounds(550, 345, 150, 25);
		inputValueToArray.setVisible(false);
		add(inputValueToArray);

		selectArrayButton = new Button("Input");
		selectArrayButton.setBounds(700, 345, 50, 25);
		selectArrayButton.addActionListener(this);
		selectArrayButton.setVisible(false);
		add(selectArrayButton);

	}

	public static void main(String[] args) {
		InterpretGUI gui = new InterpretGUI();
		gui.init();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == classInputButton)
			showGotConstructors();
		else if (e.getSource() == selectConstructorButton) {
			if ((constructors[constructorChoice.getSelectedIndex()].getGenericParameterTypes()).length == 0) {
				try {
					instance = c.newInstance();
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
				instanceList.add(instance.toString());
				// 以下はあとでまとめてローカル関数化
				instanceListLabel.setVisible(true);
				instanceList.setVisible(true);
				inputValueToInstance.setVisible(true);
				selectInstanceButton.setVisible(true);

				arrayListLabel.setVisible(true);
				arrayList.setVisible(true);
				inputValueToArray.setVisible(true);
				selectArrayButton.setVisible(true);

			} else {
				inputArgumentLabel.setVisible(true);
				argumentInputText.setVisible(true);
				argumentInputButton.setVisible(true);
			}

		}
	}

	private void showEntryArgument() {

	}

	public void showGotConstructors() {
		c = null;
		try {
			c = Class.forName(classInputText.getText());
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		constructors = c.getConstructors();
		for (Constructor constructor : constructors)
			constructorChoice.add(constructor.toString());
		SelectConstructorLabel.setVisible(true);
		constructorChoice.setVisible(true);
		selectConstructorButton.setVisible(true);

	}

}
