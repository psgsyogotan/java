package java8.ch03.ex11;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;

public class ColorTransformeGenerator {
	public static ColorTransformer generate(int width, int height, int frameWidth, Color frameColor){
		ColorTransformer ct = (x, y, color) -> {
			if(x < frameWidth || y < frameWidth || x >= width - frameWidth || y >= height - frameWidth){
				return frameColor;
			}
			else {
				return color;
			}
		};
		return ct;
	}
	
	public static ColorTransformer generate(UnaryOperator<Color> op){
		return (x, y, color) -> op.apply(color);
	}



}
