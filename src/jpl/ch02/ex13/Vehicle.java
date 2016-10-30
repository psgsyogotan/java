package jpl.ch02.ex13;

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

}
/*どのールドが変更を許すメソッドを持つべきか
 * Speed,Angle,Owner,IDは条件に応じて値が変わる可能性があるので
 * 変更を許すメソッド追加すべきである。
 * 
 * いっぽうNextIdに関しては値が変わると整合性が取れなくなると思われるので、
 * 変更を許すアクセッサーはもつべきではない。
 * */
