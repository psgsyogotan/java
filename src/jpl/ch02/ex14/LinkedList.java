package jpl.ch02.ex14;

import jpl.ch02.ex05.Vehicle;


public class LinkedList {
	private Object Status; // Object型のフィールド
	private LinkedList next;// リストの次の要素

	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		Vehicle taxi = new Vehicle();
		
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.Status = car;
		list2.Status = taxi;
		list1.next = list2;
		
	}

	public Object getStatus() {
		return Status;
	}

	public void setStatus(Object status) {
		Status = status;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

}

/*LinkedListのStatusフィールドは条件によって変わる可能性があるので
 * アクセッサーメソッドはあっても問題ないと思われる。
 * nextフィールドも次につながるものは変更される可能性があるので
 * 問題ないと思われる
 * */
