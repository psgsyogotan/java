package jpl.ch02.ex05;

public class Vehicle {
	int Speed;
	// 角度
	int Angle;
	// 所有者
	String Owner;
	// 車のID
	int Id;
	// 次の車のID
	static int NextId;

	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		car.Speed = 50;
		car.Angle = 20;
		car.Owner = "Smith";
		car.Id = 1;

		Vehicle taxi = new Vehicle();
		taxi.Speed = 40;
		taxi.Angle = 20;
		taxi.Owner = "Ibrahimovic";
		taxi.Id = 2;

		System.out.println(car.Speed);
		System.out.println(car.Angle);
		System.out.println(car.Owner);
		System.out.println(car.Id);
		System.out.println();

		System.out.println(taxi.Speed);
		System.out.println(taxi.Angle);
		System.out.println(taxi.Owner);
		System.out.println(taxi.Id);

	}
}
