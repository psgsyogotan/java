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
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class InterpretGUI extends Frame implements ActionListener {

	public Button startButton;
	public Button resetButton;

	// 1.input ClassName
	public Label inputClassNameLabel;
	public TextField classInputText;
	public Button classInputButton;

	// 2.SelectConstructor
	public Label SelectConstructorLabel;
	public Choice constructorChoice;
	public Button selectConstructorButton;

	// 3.input Argument
	public Label inputArgumentLabel;
	public TextField argumentInputText;
	public Button argumentInputButton;

	// generate Array
	public Label arrayListLabel;
	public java.awt.List arrayList;
	public TextField inputValueToArray;
	public Button selectArrayButton;

	// InstanceList
	public Label instanceListLabel;
	public java.awt.List instanceNameList;
	public Button selectInstanceButton;

	// InstanceField
	public Label instanceField;
	public java.awt.List instanceFeildNameList;
	public TextField inputValueToInstance;
	public Button setNewValueToInstanceButton;

	// InstanceMethod
	public Label instanceMethodListLabel;
	public java.awt.List instanceMethodNameList;
	public TextField inputValueForMethod;
	public Button doInstanceMethodButton;

	Class<?> c = null;

	public Constructor[] constructors;
	public Field[] fields;
	public Method[] methods;

	public ArrayList<String> getconstructorName;

	int argumentsNum;

	public Object instance;
	public int instancecount = 1;

	public ArrayList<Object> instanceList = new ArrayList<>();

	public ArrayList<Object> instanceMethodList = new ArrayList<Object>();

	public InterpretGUI() {

		setSize(800, 700);
		setResizable(false);
		setVisible(true);
		setLayout(null);

		// start Button
		startButton = new Button("Start");
		startButton.setBounds(390, 50, 50, 25);
		startButton.setVisible(true);
		startButton.addActionListener(this);
		add(startButton);

		// reset Button
		resetButton = new Button("Reset");
		resetButton.setBounds(450, 50, 50, 25);
		resetButton.setVisible(true);
		resetButton.addActionListener(this);
		resetButton.setEnabled(false);
		add(resetButton);

		// Input ClassName
		inputClassNameLabel = new Label("1: input ClassName");
		inputClassNameLabel.setBounds(50, 75, 150, 25);
		inputClassNameLabel.setVisible(true);

		add(inputClassNameLabel);

		classInputText = new TextField();
		classInputText.setBounds(50, 100, 400, 25);
		classInputText.setVisible(true);
		classInputText.setEnabled(false);
		add(classInputText);

		classInputButton = new Button("Input");
		classInputButton.setBounds(450, 100, 50, 25);
		classInputButton.addActionListener(this);
		classInputButton.setVisible(true);
		classInputButton.setEnabled(false);
		add(classInputButton);

		// Select Constructor
		SelectConstructorLabel = new Label("2: Select Constructor");
		SelectConstructorLabel.setBounds(50, 150, 150, 25);
		SelectConstructorLabel.setVisible(true);
		add(SelectConstructorLabel);

		constructorChoice = new Choice();
		constructorChoice.setBounds(50, 175, 450, 25);
		constructorChoice.setVisible(true);
		constructorChoice.setEnabled(false);
		add(constructorChoice);

		selectConstructorButton = new Button("Select");
		selectConstructorButton.setBounds(450, 200, 50, 25);
		selectConstructorButton.addActionListener(this);
		selectConstructorButton.setVisible(true);
		selectConstructorButton.setEnabled(false);
		add(selectConstructorButton);

		// input Argument
		inputArgumentLabel = new Label("3: input Argument");
		inputArgumentLabel.setBounds(50, 225, 150, 25);
		inputArgumentLabel.setVisible(true);
		add(inputArgumentLabel);

		argumentInputText = new TextField();
		argumentInputText.setBounds(50, 250, 380, 25);
		argumentInputText.setVisible(true);
		argumentInputText.setEnabled(false);
		add(argumentInputText);

		argumentInputButton = new Button("Generation");
		argumentInputButton.setBounds(430, 250, 70, 25);
		argumentInputButton.addActionListener(this);
		argumentInputButton.setVisible(true);
		argumentInputButton.setEnabled(false);
		add(argumentInputButton);

		// Array area
		arrayListLabel = new Label("Array");
		arrayListLabel.setBounds(50, 285, 150, 25);
		arrayListLabel.setVisible(true);
		add(arrayListLabel);

		arrayList = new List();
		arrayList.setBounds(50, 310, 200, 100);
		arrayList.setVisible(true);
		add(arrayList);

		inputValueToArray = new TextField();
		inputValueToArray.setBounds(50, 415, 150, 25);
		inputValueToArray.setVisible(true);
		add(inputValueToArray);

		selectArrayButton = new Button("Input");
		selectArrayButton.setBounds(200, 415, 50, 25);
		selectArrayButton.addActionListener(this);
		selectArrayButton.setVisible(true);
		add(selectArrayButton);

		// Instance List
		instanceListLabel = new Label("InstanceList");
		instanceListLabel.setBounds(550, 50, 150, 25);
		instanceListLabel.setVisible(true);
		add(instanceListLabel);

		instanceNameList = new List();
		instanceNameList.setBounds(550, 75, 200, 100);
		instanceNameList.setVisible(true);
		add(instanceNameList);

		selectInstanceButton = new Button("Show");
		selectInstanceButton.setBounds(700, 180, 50, 25);
		selectInstanceButton.addActionListener(this);
		selectInstanceButton.setVisible(true);
		selectInstanceButton.setEnabled(false);
		add(selectInstanceButton);

		// InstanceField
		instanceField = new Label("InstanceField");
		instanceField.setBounds(550, 230, 150, 25);
		instanceField.setVisible(true);
		add(instanceField);

		instanceFeildNameList = new List();
		instanceFeildNameList.setBounds(550, 255, 200, 100);
		instanceFeildNameList.setVisible(true);
		add(instanceFeildNameList);

		inputValueToInstance = new TextField();
		inputValueToInstance.setBounds(550, 360, 150, 25);
		inputValueToInstance.setVisible(true);
		inputValueToInstance.setEnabled(false);
		add(inputValueToInstance);

		setNewValueToInstanceButton = new Button("Change");
		setNewValueToInstanceButton.setBounds(700, 360, 50, 25);
		setNewValueToInstanceButton.addActionListener(this);
		setNewValueToInstanceButton.setVisible(true);
		setNewValueToInstanceButton.setEnabled(false);
		add(setNewValueToInstanceButton);

		// InstanceMethod
		instanceMethodListLabel = new Label("InstanceMethod");
		instanceMethodListLabel.setBounds(550, 410, 150, 25);
		instanceMethodListLabel.setVisible(true);
		add(instanceMethodListLabel);

		instanceMethodNameList = new List();
		instanceMethodNameList.setBounds(550, 435, 200, 100);
		instanceMethodNameList.setVisible(true);
		add(instanceMethodNameList);

		inputValueForMethod = new TextField();
		inputValueForMethod.setBounds(550, 540, 150, 25);
		inputValueForMethod.setVisible(true);
		inputValueForMethod.setEnabled(false);
		add(inputValueForMethod);

		doInstanceMethodButton = new Button("Do");
		doInstanceMethodButton.setBounds(700, 540, 50, 25);
		doInstanceMethodButton.addActionListener(this);
		doInstanceMethodButton.setVisible(true);
		doInstanceMethodButton.setEnabled(false);
		add(doInstanceMethodButton);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});
	}

	public void clearInputAreaForMakingInstance() {
		startButton.setEnabled(true);
		resetButton.setEnabled(false);
		classInputText.setEnabled(false);
		classInputText.setText("");
		classInputButton.setEnabled(false);
		constructorChoice.setEnabled(false);
		constructorChoice.removeAll();
		selectConstructorButton.setEnabled(false);
		argumentInputText.setEnabled(false);
		argumentInputText.setText("");
		argumentInputButton.setEnabled(false);
		selectInstanceButton.setEnabled(true);
		selectArrayButton.setEnabled(true);
		inputValueToArray.setEnabled(true);
		selectArrayButton.setEnabled(true);

	}

	private void inputClassName() {
		startButton.setEnabled(false);
		resetButton.setEnabled(true);
		classInputText.setEnabled(true);
		classInputButton.setEnabled(true);
		constructorChoice.setEnabled(false);
		selectConstructorButton.setEnabled(false);
		argumentInputText.setEnabled(false);
		argumentInputButton.setEnabled(false);
		selectInstanceButton.setEnabled(false);
		selectArrayButton.setEnabled(false);
		inputValueToArray.setEnabled(false);
		selectArrayButton.setEnabled(false);

	}

	private void selectConstructors() {
		startButton.setEnabled(false);
		resetButton.setEnabled(true);
		classInputText.setEnabled(false);
		classInputButton.setEnabled(false);
		constructorChoice.setEnabled(true);
		selectConstructorButton.setEnabled(true);
		argumentInputText.setEnabled(false);
		argumentInputButton.setEnabled(false);
		selectInstanceButton.setEnabled(false);
		selectArrayButton.setEnabled(false);
		inputValueToArray.setEnabled(false);
		selectArrayButton.setEnabled(false);

	}

	private void inputArgument() {
		startButton.setEnabled(false);
		resetButton.setEnabled(true);
		classInputText.setEnabled(false);
		classInputButton.setEnabled(false);
		constructorChoice.setEnabled(false);
		selectConstructorButton.setEnabled(false);
		argumentInputText.setEnabled(true);
		argumentInputButton.setEnabled(true);
		selectInstanceButton.setEnabled(false);
		selectArrayButton.setEnabled(false);
		inputValueToArray.setEnabled(false);
		selectArrayButton.setEnabled(false);

	}

	public static void main(String[] args) {
		InterpretGUI gui = new InterpretGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			inputClassName();
		} else if (e.getSource() == resetButton) {
			clearInputAreaForMakingInstance();
		} else if (e.getSource() == classInputButton) {
			selectConstructors();
			showGotConstructors();
		}
		// 引数の有無によって分岐
		else if (e.getSource() == selectConstructorButton) {
			argumentsNum = (constructors[constructorChoice.getSelectedIndex()].getGenericParameterTypes()).length;
			if (argumentsNum == 0) {
				makeInstancefromDefaultConstructor();
				clearInputAreaForMakingInstance();
			} else {
				inputArgument();
			}
		} else if (e.getSource() == argumentInputButton) {
			makeInstanceFromConstructor(argumentsNum);
			clearInputAreaForMakingInstance();
		} else if (e.getSource() == selectInstanceButton) {
			showAndGetInstanceField();
			showAndGetInstanceMethod();
		} else if (e.getSource() == setNewValueToInstanceButton) {
			setNewValueToInstance();
		} else if (e.getSource() == doInstanceMethodButton)
			invokeMethod();

	}

	private void invokeMethod() {
		// TODO 自動生成されたメソッド・スタブ
		int selectedIndex = instanceMethodNameList.getSelectedIndex();
		Object selectedMethod = instanceMethodList.get(selectedIndex);
		
	}

	private void setNewValueToInstance() {
		fields = c.getFields();

	}

	private void showAndGetInstanceMethod() {
		int selectedIndex = instanceNameList.getSelectedIndex();
		Object selectedInstance = instanceList.get(selectedIndex);
		Class<?> selectedType = selectedInstance.getClass();

		instanceMethodNameList.removeAll();
		while (selectedType != Object.class) {
			methods = selectedType.getDeclaredMethods();

			for (Method method : methods) {
				method.setAccessible(true);
				instanceMethodNameList.add(method.getName());
				instanceMethodList.add(method);
			}
			selectedType = selectedType.getSuperclass();

		}
	}

	private void showAndGetInstanceField() {
		int selectedIndex = instanceNameList.getSelectedIndex();
		Object selectedInstance = instanceList.get(selectedIndex);
		Class<?> selectedType = selectedInstance.getClass();
		fields = selectedType.getDeclaredFields();
		instanceFeildNameList.removeAll();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				instanceFeildNameList.add(field.getName() + " : " + field.get(selectedInstance)); // field.getName()がダメな理由は？
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
	}

	public void showGotConstructors() {
		try {
			c = Class.forName(classInputText.getText());
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		constructors = c.getConstructors();
		constructorChoice.removeAll();
		for (Constructor constructor : constructors)
			constructorChoice.add(constructor.toString());
	}

	private void makeInstancefromDefaultConstructor() {
		try {
			instanceList.add(c.newInstance());
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		instanceNameList.add("@" + instancecount + ":"
				+ constructors[constructorChoice.getSelectedIndex()].getDeclaringClass().getSimpleName());
		instancecount++;

	}

	private void makeInstanceFromConstructor(int elements) {
		try {
			Object[] arguments = new Object[elements];
			arguments = toParamArr(argumentInputText.getText(), elements);
			try {
				instanceList.add(constructors[constructorChoice.getSelectedIndex()].newInstance(arguments));
			} catch (IllegalArgumentException | InvocationTargetException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		instanceNameList.add("@" + instancecount + ":"
				+ constructors[constructorChoice.getSelectedIndex()].getDeclaringClass().getSimpleName());
		instancecount++;

	}

	// カンマで区切られた文字列を対応する型オブジェクトの配列にするメソッド
	private Object[] toParamArr(String strParams, int elements) {
		String[] strParamsArray = toStrArray(strParams, elements);
		Object[] objParamsArray = toObjArray(strParamsArray);
		return objParamsArray;
	}

	private Object[] toObjArray(String[] strParamsArray) {
		Object[] objParamsArray = new Object[strParamsArray.length];
		for (int i = 0; i < strParamsArray.length; i++) {
			switch (checkParamsType(strParamsArray[i])) {
			case EMPTY:
				break;
			case STRING:
				objParamsArray[i] = strParamsArray[i].substring(1, strParamsArray[i].length() - 1);// ""を取り除く
				break;
			case CHAR:
				objParamsArray[i] = strParamsArray[i].charAt(1);// ''を取り除く
				// TODO 複数文字入力されたときどうするか
				break;
			case DOUBLE:
				objParamsArray[i] = Double.parseDouble(strParamsArray[i]);
				// TODO 値チェックを追加する
				break;
			case INT:
				objParamsArray[i] = Integer.parseInt(strParamsArray[i]);
				// TODO 値チェックを追加する
				break;
			case BOOLEAN:
				objParamsArray[i] = Boolean.valueOf(strParamsArray[i]);
				break;
			case INSTANCE:
				objParamsArray[i] = instanceList
						.get(Integer.parseInt(strParamsArray[i].substring(1, strParamsArray[i].length())));
				break;
			default:
				break;
			}
		}
		return objParamsArray;
	}

	private ParamsType checkParamsType(String params) {
		if (params.equals("")) {
			return ParamsType.EMPTY;
		} else if (params.charAt(0) == '\'' && params.charAt(params.length()) - 1 == '\'') {
			return ParamsType.CHAR;
		} else if (params.charAt(0) == '"' && params.charAt(params.length() - 1) == '"') {
			return ParamsType.STRING;
		} else if (params.indexOf('.') > -1 && params.indexOf('.', params.indexOf('.')) == -1) {
			return ParamsType.DOUBLE;
		} else if (params.equals("true") || params.equals("false")) {
			return ParamsType.BOOLEAN;
		} else if (params.charAt(0) == '@') {
			return ParamsType.INSTANCE;
		} else {
			return ParamsType.INT;
		}
	}

	private String[] toStrArray(String strParams, int argumentsCount) {
		// TODO 自動生成されたメソッド・スタブ

		int paramsNum = argumentsCount;
		String[] strParamsArray;
		if (strParams.equals("")) {
			strParamsArray = new String[0];
			return strParamsArray;
		} else {
			strParamsArray = new String[paramsNum];
		}
		int beginIndex = 0;
		int endIndex = strParams.indexOf(',');
		for (int i = 0; i < paramsNum; i++) {
			if (endIndex == -1) {
				strParamsArray[i] = strParams.substring(beginIndex, strParams.length());
				return strParamsArray;
			}
			strParamsArray[i] = strParams.substring(beginIndex, endIndex);
			beginIndex = endIndex + 1;
			endIndex = strParams.indexOf(',', beginIndex);
		}
		return strParamsArray;
	}

	private enum ParamsType {
		CHAR, STRING, INT, DOUBLE, BOOLEAN, INSTANCE, EMPTY, UNSUPPORTED
	}

}
