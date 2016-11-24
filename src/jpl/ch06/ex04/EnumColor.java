package jpl.ch06.ex04;

public class EnumColor {

}

enum TrafficLight{
	BLUE(new Color("blue",10)),
	YELLOW(new Color("yellow",20)),
	RED(new Color("red",30));
	
	Color color;
	TrafficLight(Color color){this.color = color;};
	public Color getColor(){return color;};
}
