package java8.ch04.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FieldAndLabel extends Application {

	
	public void start(Stage stage) {
		Label message = new Label("Hello, JavaFX!");
	    message.setFont(new Font(100));
	    
	    TextField messageField = new TextField(message.getText());
	    messageField.textProperty().addListener(property -> message.setText(messageField.getText()));
	
	    VBox vRayout = new VBox();
	    vRayout.getChildren().addAll(message, messageField);
	    stage.setScene(new Scene(vRayout));
	    stage.setTitle("Ex04_01");
	    stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}