package interpret;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class AizawaInterpretGUI extends Frame implements ActionListener {

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
	public TextField inputTypeToArray;
	public TextField inputlengthToArray;
	public TextField changeValueToArray;
	public Button changeArrayButton;
	public Button showArrayButton;

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
	public ArrayList<String> getconstructorName;

	int argumentsNum;

	public Object instance;
	public int instancecount = 0;

	public ArrayList<Object> instanceList = new ArrayList<>();
	public ArrayList<Field> instanceFieldList = new ArrayList<Field>();
	public ArrayList<Method> instanceMethodList = new ArrayList<Method>();

	public Label executeLabel;
	public TextArea executeText;

	public int xlength = 800;
	public int ylength = 700;

	private Class<?> type;

	public AizawaInterpretGUI() {

		setSize(xlength, ylength);
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

		argumentInputButton = new Button("generate");
		argumentInputButton.setBounds(430, 250, 70, 25);
		argumentInputButton.addActionListener(this);
		argumentInputButton.setVisible(true);
		argumentInputButton.setEnabled(false);
		add(argumentInputButton);

		// Array area
		arrayListLabel = new Label("Array Type");
		arrayListLabel.setBounds(50, 325, 150, 25);
		arrayListLabel.setVisible(true);
		add(arrayListLabel);

		inputTypeToArray = new TextField();
		inputTypeToArray.setBounds(50, 355, 150, 25);
		inputTypeToArray.setVisible(true);
		add(inputTypeToArray);

		// Array area
		arrayListLabel = new Label("Array Length");
		arrayListLabel.setBounds(50, 385, 150, 25);
		arrayListLabel.setVisible(true);
		add(arrayListLabel);

		inputlengthToArray = new TextField();
		inputlengthToArray.setBounds(50, 415, 150, 25);
		inputlengthToArray.setVisible(true);
		add(inputlengthToArray);

		selectArrayButton = new Button("Generate");
		selectArrayButton.setBounds(200, 415, 60, 25);
		selectArrayButton.addActionListener(this);
		selectArrayButton.setVisible(true);
		add(selectArrayButton);

		showArrayButton = new Button("Show");
		showArrayButton.setBounds(265, 415, 60, 25);
		showArrayButton.addActionListener(this);
		showArrayButton.setVisible(true);
		add(showArrayButton);

		arrayList = new List();
		arrayList.setBounds(50, 445, 200, 100);
		arrayList.setVisible(true);
		add(arrayList);

		changeValueToArray = new TextField();
		changeValueToArray.setBounds(50, 550, 150, 25);
		changeValueToArray.setVisible(true);
		add(changeValueToArray);

		changeArrayButton = new Button("change");
		changeArrayButton.setBounds(200, 550, 60, 25);
		changeArrayButton.addActionListener(this);
		changeArrayButton.setVisible(true);
		add(changeArrayButton);

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

		// Instance List
		executeLabel = new Label("execute");
		executeLabel.setBounds(550, 570, 150, 25);
		executeLabel.setVisible(true);
		add(executeLabel);

		executeText = new TextArea();
		executeText.setBounds(550, 600, 200, 50);
		executeText.setVisible(true);
		add(executeText);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});
	}

	public void clearInputAreaForMakingInstance() {
		startButton.setEnabled(true);
		resetButton.setEnabled(true);
		classInputText.setEnabled(true);
		classInputText.setText("");
		classInputButton.setEnabled(true);
		constructorChoice.setEnabled(true);
		constructorChoice.removeAll();
		selectConstructorButton.setEnabled(true);
		argumentInputText.setEnabled(true);
		argumentInputText.setText("");
		argumentInputButton.setEnabled(true);
		selectInstanceButton.setEnabled(true);

		setNewValueToInstanceButton.setEnabled(true);
		doInstanceMethodButton.setEnabled(true);
		inputValueToInstance.setEnabled(true);
		inputValueForMethod.setEnabled(true);

	}

	private void inputClassName() {
		startButton.setEnabled(true);
		resetButton.setEnabled(true);
		classInputText.setEnabled(true);
		classInputButton.setEnabled(true);
		constructorChoice.setEnabled(true);
		selectConstructorButton.setEnabled(true);
		argumentInputText.setEnabled(true);
		argumentInputButton.setEnabled(true);
		selectInstanceButton.setEnabled(true);
		setNewValueToInstanceButton.setEnabled(true);
		doInstanceMethodButton.setEnabled(true);
		inputValueToInstance.setEnabled(true);
		inputValueForMethod.setEnabled(true);

	}

	private void selectConstructors() {
		startButton.setEnabled(true);
		resetButton.setEnabled(true);
		classInputText.setEnabled(true);
		classInputButton.setEnabled(true);
		constructorChoice.setEnabled(true);
		selectConstructorButton.setEnabled(true);
		argumentInputText.setEnabled(true);
		argumentInputButton.setEnabled(true);
		selectInstanceButton.setEnabled(true);
		setNewValueToInstanceButton.setEnabled(true);
		doInstanceMethodButton.setEnabled(true);
		inputValueToInstance.setEnabled(true);
		inputValueForMethod.setEnabled(true);

	}

	private void inputArgument() {
		startButton.setEnabled(true);
		resetButton.setEnabled(true);
		classInputText.setEnabled(true);
		classInputButton.setEnabled(true);
		constructorChoice.setEnabled(true);
		selectConstructorButton.setEnabled(true);
		argumentInputText.setEnabled(true);
		argumentInputButton.setEnabled(true);
		selectInstanceButton.setEnabled(true);
		setNewValueToInstanceButton.setEnabled(true);
		doInstanceMethodButton.setEnabled(true);

	}

	private void setNewValueOrInvokeMethod() {
		startButton.setEnabled(true);
		resetButton.setEnabled(true);
		classInputText.setEnabled(true);
		classInputButton.setEnabled(true);
		constructorChoice.setEnabled(true);
		selectConstructorButton.setEnabled(true);
		argumentInputText.setEnabled(true);
		argumentInputButton.setEnabled(true);
		selectInstanceButton.setEnabled(true);
		setNewValueToInstanceButton.setEnabled(true);
		doInstanceMethodButton.setEnabled(true);
		inputValueToInstance.setEnabled(true);
		inputValueForMethod.setEnabled(true);

	}

	public static void main(String[] args) {
		AizawaInterpretGUI gui = new AizawaInterpretGUI();
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
			int selectedIndex = instanceNameList.getSelectedIndex();// 選択されているインスタンスのIndex取得
			String selectedItem = instanceNameList.getSelectedItem();
			if (selectedItem.charAt(selectedItem.length() - 1) == ']') {
				showArray();
			} else {
				showAndGetInstanceField();
				showAndGetInstanceMethod();
				setNewValueOrInvokeMethod();
			}
		} else if (e.getSource() == setNewValueToInstanceButton) {
			setNewValueToInstance();
			showAndGetInstanceField();
		} else if (e.getSource() == doInstanceMethodButton) {
			invokeMethod();
		} else if (e.getSource() == selectArrayButton) {
			generateArray();
		} else if (e.getSource() == showArrayButton) {
			showContentInArray();
		} else if (e.getSource() == changeArrayButton) {
			changeArray();
		}

	}

	private void showContentInArray() {
		int selectedIndex = instanceNameList.getSelectedIndex();// 選択されているインスタンスのIndex取得
		if (selectedIndex == -1) {
		} else {
			String selectedItem = instanceNameList.getSelectedItem();
			Object selectedInst = null;
			// 選択されているのが配列のインスタンスか確認
			if (selectedItem.charAt(selectedItem.length() - 1) == ']') {
				int selectedArrIndex = arrayList.getSelectedIndex();// 選択されている配列要素のIndexを取得
				if (selectedArrIndex == -1) {
				}
				String selectedArrItem = arrayList.getItem(selectedArrIndex);

				// 選択されているインスタンスと配列要素の対応が正しいか確認（インスタンスの番号が同じか比較）
				if (selectedArrItem.charAt(1) == selectedItem.charAt(1)) {
					Object[] selectedArrInst = (Object[]) instanceList.get(selectedIndex);// 選択されている配列を取得
					selectedInst = selectedArrInst[selectedArrIndex];// 選択されている配列の要素を取得
				} else {
				}
			} else {
				selectedInst = instanceList.get(selectedIndex);// 選択されているインスタンスを取得
			}
			if (selectedInst == null) {
			}

			instanceMethodNameList.removeAll();
			instanceMethodList.clear();
			Class<?> selectedType = selectedInst.getClass();
			while (selectedType != Object.class) {
				Method[] methods = selectedType.getDeclaredMethods();

				for (Method method : methods) {
					method.setAccessible(true);
					Class<?>[] params = method.getParameterTypes();
					String displayParam = "";
					for (Class<?> param : params) {
						displayParam += param.getSimpleName();
					}
					instanceMethodNameList.add(method.getName() + "(" + displayParam + ")");
					instanceMethodList.add(method);
				}
				selectedType = selectedType.getSuperclass();
			}
			inputValueForMethod.setText("");

			selectedType = selectedInst.getClass();
			Field[] fields = selectedType.getDeclaredFields();

			instanceFeildNameList.removeAll();
			instanceFieldList.clear();
			for (Field field : fields) {
				field.setAccessible(true);
				try {
					instanceFeildNameList.add(field.getName() + " : " + field.get(selectedInst)); // field.getName()がダメな理由は？
					instanceFieldList.add(field);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					ShowException(e.toString());
				}
				inputValueToInstance.setText("");

			}
		}
	}

	private void changeArray() {
		String newContents = changeValueToArray.getText();
		int selectedIndex = instanceNameList.getSelectedIndex();// 選択されているインスタンスのIndex取得
		String selectedItem = instanceNameList.getSelectedItem();// 選択されているインスタンスのString取得
		if (selectedIndex == -1) {
		} else if (selectedItem.charAt(selectedItem.length() - 1) == ']') {
			Object[] selectedInst = (Object[]) instanceList.get(selectedIndex);
			int selectedArrIndex = arrayList.getSelectedIndex();// 選択されている配列要素のIndex取得
			if (selectedArrIndex == -1) {
			} else {
				try {
					selectedInst[selectedArrIndex] = toObj(newContents);
				} catch (java.lang.ArrayStoreException e1) {
					e1.printStackTrace();
				}
				instanceList.set(selectedIndex, selectedInst);
			}
		} else {
		}
		arrayList.removeAll();
	}

	private Object toObj(String strParams) {
		Object objParams = new Object();
		try {
			switch (checkParamsType(strParams)) {
			case EMPTY:
				break;
			case STRING:
				objParams = strParams.substring(1, strParams.length() - 1);// ""を取り除く
				break;
			case CHAR:
				objParams = strParams.charAt(1);// ''を取り除く
				// TODO 複数文字入力されたときどうするか
				break;
			case DOUBLE:
				objParams = Double.parseDouble(strParams);
				// TODO 値チェックを追加する
				break;
			case INT:
				objParams = Integer.parseInt(strParams);
				// TODO 値チェックを追加する
				break;
			case BOOLEAN:
				objParams = Boolean.valueOf(strParams);
				break;
			case INSTANCE:
				objParams = instanceList.get(Integer.parseInt(strParams.substring(1, strParams.length())));// #を取り除く
				break;
			case ARR_INSTANCE:
				String[] instNum = strParams.substring(1).split("@");
				Object[] inst = (Object[]) instanceList.get(Integer.parseInt(instNum[0]));
				objParams = inst[Integer.parseInt(instNum[1])];
				break;
			default:
				break;
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}
		return objParams;
	}

	private void showArray() {
		arrayList.removeAll();
		int selectedIndex = instanceNameList.getSelectedIndex();
		String selectedItem = instanceNameList.getSelectedItem();
		Object[] selectedInst = (Object[]) instanceList.get(selectedIndex);
		Class<?> arrType = selectedInst.getClass();
		for (int i = 0; i < selectedInst.length; i++) {
			String arrTypeName = arrType.getSimpleName();
			arrayList.add("@" + selectedIndex + "@" + i + arrTypeName + ":" + selectedInst[i]);
		}
	}

	private void generateArray() {
		String className = inputTypeToArray.getText();
		int arrayLength = Integer.parseInt(inputlengthToArray.getText());
		// TODO null check
		try {
			type = Class.forName(className);
			Object[] newArray = toArray(type, arrayLength);
			instanceList.add(newArray);
			instanceNameList.add("@" + instancecount + ":" + type.getSimpleName() + "[" + arrayLength + "]");
			instancecount++;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			ShowException(e1.toString());
		}
	}

	private Object[] toArray(Class<?> type, int arrayLength) {
		Object[] arr = (Object[]) Array.newInstance(type, arrayLength);
		return arr;
	}

	private void invokeMethod() {
		int selectedIndex = instanceNameList.getSelectedIndex();// 選択されているインスタンスのIndex取得
		String selectedItem = instanceNameList.getSelectedItem();
		Object selectedInstance = null;
		if (selectedItem.charAt(selectedItem.length() - 1) == ']') {

			int selectedArrIndex = arrayList.getSelectedIndex();//
			String selectedArrItem = arrayList.getItem(selectedArrIndex);

			if (selectedArrItem.charAt(1) == selectedItem.charAt(1)) {
				Object[] selectedArrInst = (Object[]) instanceList.get(selectedIndex);
				selectedInstance = selectedArrInst[selectedArrIndex];
			}
		} else {
			selectedInstance = instanceList.get(selectedIndex);
		}
		// java.lang.reflect.Type[] paramTypes =
		// instanceMethodList.get(selectedIndex).getGenericParameterTypes();
		java.lang.reflect.Type[] paramTypes = instanceMethodList.get(instanceMethodNameList.getSelectedIndex())
				.getGenericParameterTypes();
		Object[] params = new Object[paramTypes.length];
		params = toParamArr(inputValueForMethod.getText(), paramTypes.length);
		executeText.setText("");

		if (params.length == 0) {
			try {
				Object obj = instanceMethodList.get(instanceMethodNameList.getSelectedIndex()).invoke(selectedInstance);
				if (obj.equals(null))
					executeText.setText("null");
				else
					executeText.setText(obj.toString());
			} catch (IllegalAccessException | IllegalArgumentException e) {
				ShowException(e.toString());
			} catch (InvocationTargetException e2) {
				ShowException(e2.getCause().toString());
			}

		} else
			try {
				Object obj = instanceMethodList.get(instanceMethodNameList.getSelectedIndex()).invoke(selectedInstance,
						params);
				if (obj.equals(null))
					executeText.setText("null");
				else
					executeText.setText(obj.toString());
			} catch (IllegalAccessException | IllegalArgumentException e) {
				ShowException(e.toString());
			} catch (InvocationTargetException e2) {
				ShowException(e2.getCause().toString());
			}

	}

	private void setNewValueToInstance() {
		int selectedIndex = instanceNameList.getSelectedIndex();
		Object selectedInstance = instanceList.get(selectedIndex);
		Object newObj = strToObj(inputValueToInstance.getText());
		try {
			instanceFieldList.get(instanceFeildNameList.getSelectedIndex()).set(selectedInstance, newObj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			ShowException(e.toString());
		}

	}

	private void showAndGetInstanceMethod() {
		int selectedIndex = instanceNameList.getSelectedIndex();
		Object selectedInstance = instanceList.get(selectedIndex);
		Class<?> selectedType = selectedInstance.getClass();

		instanceMethodNameList.removeAll();
		instanceMethodList.clear();
		while (selectedType != Object.class) {
			Method[] methods = selectedType.getDeclaredMethods();

			for (Method method : methods) {
				method.setAccessible(true);
				Class<?>[] params = method.getParameterTypes();
				String displayParam = "";
				for (Class<?> param : params) {
					displayParam += param.getSimpleName();
				}
				instanceMethodNameList.add(method.getName() + "(" + displayParam + ")");
				instanceMethodList.add(method);
			}
			selectedType = selectedType.getSuperclass();
		}
		inputValueForMethod.setText("");
	}

	private void showAndGetInstanceField() {
		int selectedIndex = instanceNameList.getSelectedIndex();
		Object selectedInstance = instanceList.get(selectedIndex);
		Class<?> selectedType = selectedInstance.getClass();
		Field[] fields = selectedType.getDeclaredFields();

		instanceFeildNameList.removeAll();
		instanceFieldList.clear();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				instanceFeildNameList.add(field.getName() + " : " + field.get(selectedInstance)); // field.getName()がダメな理由は？
				instanceFieldList.add(field);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				ShowException(e.toString());
			}
			inputValueToInstance.setText("");

		}
	}

	public void showGotConstructors() {
		try {
			c = Class.forName(classInputText.getText());
		} catch (ClassNotFoundException e1) {
			ShowException(e1.toString());
		}

		constructors = c.getConstructors();
		constructorChoice.removeAll();
		for (Constructor constructor : constructors)
			constructorChoice.add(constructor.toString());
	}

	private void makeInstancefromDefaultConstructor() {
		try {
			instanceList.add(c.newInstance());
			instanceNameList.add("@" + instancecount + ":"
					+ constructors[constructorChoice.getSelectedIndex()].getDeclaringClass().getSimpleName());
			instancecount++;
		} catch (InstantiationException | IllegalAccessException e1) {
			ShowException(e1.toString());
		}

	}

	private void makeInstanceFromConstructor(int elements) {
		try {
			Object[] arguments = new Object[elements];
			arguments = toParamArr(argumentInputText.getText(), elements);
			try {
				instanceList.add(constructors[constructorChoice.getSelectedIndex()].newInstance(arguments));
				instanceNameList.add("@" + instancecount + ":"
						+ constructors[constructorChoice.getSelectedIndex()].getDeclaringClass().getSimpleName());
				instancecount++;

			} catch (IllegalArgumentException e) {
				ShowException(e.toString());
			} catch (InvocationTargetException e2) {
				ShowException(e2.getCause().toString());
			}
		} catch (InstantiationException | IllegalAccessException e) {
			ShowException(e.toString());
		}

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
				break;
			case DOUBLE:
				objParamsArray[i] = Double.parseDouble(strParamsArray[i]);
				break;
			case INT:
				objParamsArray[i] = Integer.parseInt(strParamsArray[i]);
				break;
			case BOOLEAN:
				objParamsArray[i] = Boolean.valueOf(strParamsArray[i]);
				break;
			case INSTANCE:
				objParamsArray[i] = instanceList
						.get(Integer.parseInt(strParamsArray[i].substring(1, strParamsArray[i].length())));
				break;
			//case ARR_INSTANCE:
				//String[] instNum = strParamsArray[i].split("@");
				//Object[] inst = (Object[]) instanceList.get(Integer.parseInt(instNum[0]));
				//objParamsArray[i] = inst[Integer.parseInt(instNum[1])];
				//break;
			case ARR_INSTANCE:
				String[] instNum = strParamsArray[i].split("@");
				Object[] inst = (Object[]) instanceList.get(Integer.parseInt(instNum[1]));
				objParamsArray[i] = inst[Integer.parseInt(instNum[2])];
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
			if (params.indexOf('@', 1) == -1) {
				return ParamsType.INSTANCE;
			} else {
				return ParamsType.ARR_INSTANCE;
			}
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

	private Object strToObj(String text) {
		Object changeTypedObject = new Object();
		switch (checkParamsType(text)) {
		case DOUBLE:
			changeTypedObject = Double.parseDouble(text);
			break;
		case CHAR:
			changeTypedObject = text.charAt(1);
			break;
		case STRING:
			changeTypedObject = text.substring(1, text.length() - 1);
			break;
		case INT:
			changeTypedObject = Integer.parseInt(text);
			break;
		case BOOLEAN:
			changeTypedObject = Boolean.valueOf(text);
			break;
		case INSTANCE:
			changeTypedObject = instanceList.get(Integer.parseInt(text.substring(1, text.length())));
			break;
		case ARR_INSTANCE:
			String[] instNum = text.substring(1).split("@");
			Object[] inst = (Object[]) instanceList.get(Integer.parseInt(instNum[0]));
			changeTypedObject = inst[Integer.parseInt(instNum[1])];
			break;
		case EMPTY:
			break;
		default:
			break;

		}
		return changeTypedObject;
	}

	private enum ParamsType {
		CHAR, STRING, INT, DOUBLE, BOOLEAN, INSTANCE, EMPTY, UNSUPPORTED, ARR_INSTANCE
	}

	private void ShowException(String exception) {
		Frame frame;
		frame = new Frame("Exception");
		frame.setSize(360, 240);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();

			}
		});

		Label label;
		label = new Label(exception);
		frame.add(label);

	}

}
