package jpl.ch12.ex01;

public class ObjectNotFoundException extends Exception {
	
	public final String listName;

	public ObjectNotFoundException(String name) {
		super("No object named \"" + name +"\" found");
		listName = name;
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	

}
