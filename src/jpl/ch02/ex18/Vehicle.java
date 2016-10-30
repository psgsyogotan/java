package jpl.ch02.ex18;

public class Vehicle {
	final static int TURN_LEFT = 90;
	final static int TURN_RIGHT = -90;
	private int Speed;
	// 角度
	private double Angle;
	// 所有者
	private String Owner;
	// 車のID
	private int Id;
	// 次の車のID
	static int NextId;

	Vehicle(String Owner){
		this.Owner = Owner;
	}
	Vehicle(){
		NextId++;
	}
	
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

	public void turn(int Angle) {
		if (Angle == TURN_LEFT) {
			setAngle((int) TURN_LEFT);
		} 
		else if (Angle == TURN_RIGHT) {
			setAngle((int) TURN_RIGHT);
		}

	}
	public static void main(String []args){
		Vehicle car = new Vehicle(args[0]);
		System.out.println("car's owner is "+ car.getOwner());
		
	}

}
