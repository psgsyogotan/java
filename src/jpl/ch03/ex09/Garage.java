package jpl.ch03.ex09;

public class Garage implements Cloneable {
	private Vehicle[] buffer;
	

	public Garage(int array) {
		buffer = new Vehicle[array];
		for (int i = 0; i < array; i++) {
			buffer[i] = new Vehicle();

			
		}
	}

	public Vehicle getBuffer(int num) {
		return buffer[num];
	}

	public Vehicle[] getBuffer() {
		return buffer;

	}

	public void setBuffer(Vehicle[] buffer) {
		this.buffer = buffer;
	}

	public Garage Clone() {
		try {
			Garage nObj = (Garage) super.clone();
			nObj.buffer = buffer.clone();
			return nObj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());

		}

	}

}
