package jpl.ch03.ex06;

public class Battery extends EnergySorce {
	private int Electricity;

	public int getElectricity() {
		return Electricity;
	}

	public void setElectricity(int electricity) {
		Electricity = electricity;
	}

	@Override
	void empty() {
	 setElectricity(0);
	}

}
