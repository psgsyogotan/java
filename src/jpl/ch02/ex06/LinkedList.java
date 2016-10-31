package jpl.ch02.ex06;

import jpl.ch02.ex05.Vehicle;

public class LinkedList {

	 Object Status; // Object型のフィールド
	 LinkedList next;// リストの次の要素

	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		Vehicle taxi = new Vehicle();
		
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.Status = car;
		list2.Status = taxi;
		list1.next = list2;
		
	}

}
