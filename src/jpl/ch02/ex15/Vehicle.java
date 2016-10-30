package jpl.ch02.ex15;

public class Vehicle {
	private int Speed;
	// 角度
	private int Angle;
	// 所有者
	private String Owner;
	// 車のID
	private int Id;
	// 次の車のID
	static int NextId;
	
	public int getSpeed() {
		return Speed;
	}
	public void setSpeed(int speed) {
		Speed = speed;
	}
	public int getAngle() {
		return Angle;
	}
	public void setAngle(int angle) {
		Angle = angle;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public void changeSpeed(int Speed){
		setSpeed(Speed);
	}
	
	public void stop(){
		setSpeed(0);
	}

}
