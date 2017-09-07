package java8.ch04.ex03;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {
	private String text = "";
	private StringProperty textProp = null;

	public final StringProperty textProperty() {
		if (textProp == null) {
			textProp = new SimpleStringProperty(text);
			text = null;
		}
		return textProp;
	}

	public final void setText(String newValue) {
		textProperty().set(newValue);
	}

	public final String getText() {
		return textProp != null ? textProp.get() : text;
	}
	
}