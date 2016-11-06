package jpl.ch03.ex07;

public class ColorAttr extends Attr {

	private ScreenColor myColor;
	private int hash;

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}

	public ColorAttr(String name) {
		this(name, "transarent");
	}

	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;

	}

	public Object setValue(Object newValue) {
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}

	public ScreenColor setValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	public ScreenColor getColr() {
		return myColor;
	}

	protected void decodeColor() {
		if (getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}

	public boolean Equals(ColorAttr value) {
		if (this == value)
			return true;
		else
			return false;
	}

	//直したい
	public int hashCode() {
		if ((this.getName()).equals("red")) {
			return 0;
		} else if ((this.getName()).equals("blue")) {
			return 1;
		} else if ((this.getName()).equals("green")) {
			return 2;
		}
		else
		return 3;
	}

}
