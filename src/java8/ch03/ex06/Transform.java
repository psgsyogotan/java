package java8.ch03.ex06;

import java.awt.Color;
import java.awt.Image;
import java.util.function.BiFunction;

public class Transform {
	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
	    int width  = (int)in.getWidth();
	    int height = (int)in.getHeight();
	    WritableImage out = new WritableImage(width, height);
	    for (int x = 0; x < width; x++) {
	        for (int y = 0; y < height; y++) {
	            out.getPixelWriter().setColor(
	                x, y,
	                f.apply(in.getPixelReader().getColor(x, y), arg)
	            );
	        }
	    }
	    return out;
	}

}
