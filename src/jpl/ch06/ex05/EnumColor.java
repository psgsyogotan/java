package jpl.ch06.ex05;

public class EnumColor {

}
enum Trafficlight {
	BLUE{
		
		Color blue = new Color("Blue",10);
		@Override
		Color getColor() {
			// TODO 自動生成されたメソッド・スタブ
			return blue;		
		}
		
	},
	YELLOW{

		Color yellow = new Color("Yellow",20);
		@Override
		Color getColor() {
			// TODO 自動生成されたメソッド・スタブ
			return yellow;
		}
		
	},
	RED{

		Color red = new Color("Red",30);
		@Override
		Color getColor() {
			// TODO 自動生成されたメソッド・スタブ
			return red;
		}
		
	}
	;
	
	abstract  Color getColor();
}
