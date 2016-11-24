package jpl.ch06.ex02;

enum TURN{
	TURN_LEFT, TURN_RIGHT;

	};

public class Vehicle {
	
	private int Speed;
	// 角度
	private double Angle;
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

	public double getAngle() {
		return Angle;
	}

	public void setAngle(double angle) {
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

	public void changeSpeed(int Speed) {
		setSpeed(Speed);
	}

	public void stop() {
		setSpeed(0);
	}

	public void turn(double Angle) {
		setAngle(Angle);
	}

	public void turn(TURN turn) {
		if (turn == TURN.TURN_LEFT) {
			setAngle(90);
		} 
		else if (turn == TURN.TURN_RIGHT) {
			setAngle(-90);
		}

	}

}
