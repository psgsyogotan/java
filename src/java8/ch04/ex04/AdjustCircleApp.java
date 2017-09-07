package java8.ch04.ex04;

import static javafx.beans.binding.Bindings.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class AdjustCircleApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Circle circle = new Circle(100, 100, 100);
	    circle.setFill(Color.RED);
	    pane.getChildren().add(circle);
	    Scene scene = new Scene(pane);
	    
	    
	   
	    circle.centerXProperty().bind(divide(scene.widthProperty(),  2.0));
	    circle.centerYProperty().bind(divide(scene.heightProperty(), 2.0));
	    circle.radiusProperty().bind(
	    	    divide(min(scene.widthProperty(), scene.heightProperty()), 2.0));

	    primaryStage.setScene(scene);
	    primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}