package jpl.ch03.ex01;

public class PassengerVehicle extends jpl.ch02.ex18.Vehicle {
	
	private int seat;
	private int passenger;

	PassengerVehicle() {
		super();
				// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public PassengerVehicle(String Owner){
		super(Owner);
	}

	public PassengerVehicle(int seat, int passenger) {
		super();
		this.seat = seat;
		this.passenger = passenger;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public int getPassenger() {
		return passenger;
	}

	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}
	
	public static void main(String []args){
		PassengerVehicle bus = new PassengerVehicle(20,5);
		PassengerVehicle taxi = new PassengerVehicle(4,1);
		
		System.out.println("Passenger = "+bus.getPassenger());
		System.out.println("Seat = "+bus.getSeat());
		System.out.println();
		System.out.println("Passenger = "+taxi.getPassenger());
		System.out.println("Seat = "+taxi.getSeat());
		
	}
	
	

}
