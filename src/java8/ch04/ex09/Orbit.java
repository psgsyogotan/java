package java8.ch04.ex09;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Orbit extends Application {

	@Override
	public void start(Stage primaryStage) {
		double radiusX = 400;
	    double radiusY = 180;
	    double centerX = radiusX + 50;
	    double centerY = radiusY + 50;
	    
	    Circle planet = new Circle(36, Color.GREEN);
	    planet.setCenterX(centerX + radiusX);
	    planet.setCenterY(centerY);
	    
	    Circle sun = new Circle(100, Color.GREEN);
	    sun.setCenterX(centerX);
	    sun.setCenterY(centerY);
	    
	    Ellipse orbit = new Ellipse(radiusX, radiusY);
	    orbit.setCenterX(centerX);
	    orbit.setCenterY(centerY);
	    orbit.setStroke(Color.GREEN);
	    orbit.setFill(null);
	    
	    PathTransition transition = new PathTransition();
	    transition.setNode(planet);
	    transition.setPath(orbit);
	    transition.setDuration(Duration.millis(10000));
	    transition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
	    transition.setInterpolator(Interpolator.EASE_OUT);
	    transition.setCycleCount(Animation.INDEFINITE);
	    transition.play();

	    Group group = new Group(orbit, planet, sun);
	    primaryStage.setScene(new Scene(group, 2*centerX, 2*centerY));
	    primaryStage.show();
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}