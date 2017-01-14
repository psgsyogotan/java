package jpl.ch11.ex02;

public class AttrGeneric<E> {
	
	private final String name;
	private E value = null;
	
	public AttrGeneric(String name){
		this.name = name;
		
	}
	
	public AttrGeneric(String name, E value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public E getValue(){
		return value;
	}
	
	public E setValue(E newValue){
		E oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	public String toString(){
		return name + "='" + value +"'";
	}
	

}
