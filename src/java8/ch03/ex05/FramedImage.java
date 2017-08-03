package java8.ch03.ex05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FramedImage extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Image image = new Image("file:./src/java8/ch03/ex05/queen-mary.png");
		Image framedImage = makeFrameForImage.transform(image, (x, y, color) -> {
			if(x < 10 || y < 10 || (x >= image.getWidth() - 10) || (y >= image.getHeight() -10)){
				return Color.GREEN;
			}
			else {
				return color;
			}
		});
		stage.setScene(new Scene(new HBox(new ImageView(framedImage))));
		stage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
