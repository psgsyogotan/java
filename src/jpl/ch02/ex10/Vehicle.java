package jpl.ch02.ex10;

public class Vehicle {
	// 速さ
	private int Speed;
	// 角度
	private int Angle;
	// 所有者
	private int Owner;
	//車のID
	private int Id;
	//次の車のID
	static int NextId;
	
	public String ToString(){
		String name = Id + " (" + Owner +")";
		return name;
		
	}
}
