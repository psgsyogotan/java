package java8.ch03.ex08;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MakeOriginalFrame extends Application {

	interface ColorTransformer {
		Color apply(int x, int y, Color colorAtXY);
	}
	
	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

	public static ColorTransformer colorTransformer(int width, int height, int frameWidth, Color frameColor) {
		return (x, y, c) -> x < frameWidth || y < frameWidth || x >= width - frameWidth || y >= height - frameWidth
				? frameColor : c;
	}

	@Override
	public void start(Stage stage) throws Exception {
		Image image = new Image("file:./src/java8/ch03/ex08/queen-mary.png");
	    int width  = (int)image.getWidth();
	    int height = (int)image.getHeight();
	    Image image2 = transform(image, colorTransformer(width, height, 50, Color.GREEN));
	    stage.setScene(new Scene(new HBox(new ImageView(image2))));
	    stage.show();

	}
	
	public static void main(String[] args){
		launch(args);
	}

}
