package java8.ch03.ex05;

import java.awt.Color;
import java.awt.Image;

public class makeFrameForImage {
	
	public static Image transform(Image in, ColorTransformer f) {
	    int width  = (int)in.getWidth();
	    int height = (int)in.getHeight();
	    WritableImage out = new WritableImage(width, height);
	    for (int x = 0; x < width; x++) {
	        for (int y = 0; y < height; y++) {
	            out.getPixelWriter().setColor(
	                x, y,
	                f.apply(x, y, in.getPixelReader().getColor(x, y))
	            );
	        }
	    }
	    return out;
	}
	
	interface ColorTransformer {
	    Color apply(int x, int y, Color colorAtXY);
	}
	

}
