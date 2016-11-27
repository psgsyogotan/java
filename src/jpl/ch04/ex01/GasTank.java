package jpl.ch04.ex01;

public class GasTank implements EnergySorce {

	private double gas;
	@Override
	public void empty() {
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
