package jpl.ch02.ex16;

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
	public int numElement(LinkedList list){
		int num = 0;
		LinkedList nowlist = list;
		while(nowlist.next != null){
			num++;
			nowlist = list.next;
		}
		return  num;
	}

}

/*LinkedListのStatusフィールドは条件によって変わる可能性があるので
 * アクセッサーメソッドはあっても問題ないと思われる。
 * ただし、nextフィールドが安易に変えることが可能だと
 * つながりがなくなるといった整合性の問題があると思うので、
 * アクセッサーメソッドを用意すべきではない
 * */
