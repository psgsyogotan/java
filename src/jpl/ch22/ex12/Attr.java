package jpl.ch22.ex12;

public class Attr {
	private  String name;
	private Object value;

	public Attr() {
		this.name = null;
		this.value = null;
	}

	public Attr(String name) {
		this.name = name;
		this.value = null;
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public Object getValue() {
		return this.value;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public Object setValue(Object obj) {
		Object old = this.value;
		this.value = obj;
		return old;
	}

	public String toString() {
		return name + "='" + this.value.toString() + "'";
	}
}