package jpl.ch03.ex07;

public class Attr {
	private final String name;
	private Object value = null;
	
	public Attr(String name, Object value){
		this.name = name;
		this.value = value;
	}
	
	public Attr(String name){
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}

	public String getName() {
		return name;
	}
	
	public String toString(){
		return name + "=" + value + "'";
	}
	

}
