package java8.ch04.ex07;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BorderApp extends Application {

	@Override
	public void start(Stage stage) {
		TextField textField = new TextField("Border");
		textField.setBorder(new Border(new BorderStroke(
				Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, null)));
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(4));
		pane.setCenter(textField);
		
		stage.setScene(new Scene(pane));
		stage.setTitle("ex04_07");
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}