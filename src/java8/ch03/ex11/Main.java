package java8.ch03.ex11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	public Image transform(Image in, ColorTransformer ct) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, ct.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

	@Override
	public void start(Stage stage) {
		Image image = new Image("file:./src/java8/ch03/ex11/queen-mary.png");
		Image image2 = transform(transform(image, ColorTransformeGenerator.generate(Color::brighter)),
				(x, y, c) -> {
					if (x < 10 || y < 10 || (x >= image.getWidth() - 10) || (y >= image.getHeight() - 10)) {
						return Color.GRAY;
					} else {
						return c;
					}
				});
		stage.setScene(new Scene(new HBox(new ImageView(image2))));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
