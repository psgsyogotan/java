package jpl.ch06.ex05;

public class Color {
	private String name;
	private int RGB;

	public Color(String name, int RGB){
		this.name = name;
		this.RGB = RGB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRGB() {
		return RGB;
	}

	public void setRGB(int rGB) {
		RGB = rGB;
	}
}
