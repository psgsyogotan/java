package jpl.ch04.ex01;

public class Battery implements EnergySorce {
	private int Electricity;

	public int getElectricity() {
		return Electricity;
	}

	public void setElectricity(int electricity) {
		Electricity = electricity;
	}

	@Override
	public void empty() {

		setElectricity(0);
		// TODO 自動生成されたメソッド・スタブ

	}

}
