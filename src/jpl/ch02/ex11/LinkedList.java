package jpl.ch02.ex11;

import jpl.ch02.ex05.Vehicle;

public class LinkedList {

	private Object Status; // Object型のフィールド
	private LinkedList next;// リストの次の要素
	private String listname;

	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		Vehicle taxi = new Vehicle();
		
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.Status = car;
		list1.listname = "car";
		list1.next = list2;
		
		list2.Status = taxi;
		list2.listname = "taxi";
			
	}
	
	public String toString(){
		return listname;
		
	}

}
