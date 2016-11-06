package jpl.ch03.ex06;

public class GasTank extends EnergySorce {
	private double gas;

	@Override
	void empty() {
		setGas(0);
	}
	
	public GasTank(){
		setGas(0);
	}
	
	public GasTank(double fuel){
		setGas(fuel);
	}

	public double getGas() {
		return gas;
	}

	public void setGas(double gas) {
		this.gas = gas;
	}

}
