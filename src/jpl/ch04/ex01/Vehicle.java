package jpl.ch04.ex01;



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
	private int fuel;

	protected Vehicle(String Owner) {
		this.Owner = Owner;
	}

	protected Vehicle() {
		NextId++;
	}

	protected Vehicle(GasTank gastank) {
		gastank.setGas(0);
	}
	
	protected Vehicle(Battery battery) {
		battery.setElectricity(0);
	}



	void start(GasTank gas) {
		gas.setGas(5);

	}

	void start(Battery battery) {
		battery.setElectricity(5);
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
		} else if (Angle == TURN_RIGHT) {
			setAngle((int) TURN_RIGHT);
		}

	}

}