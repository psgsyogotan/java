package jpl.ch04.ex03;



public class LinkedList implements LinkedListInterface {
	private Object Status; // Object型のフィールド
	private LinkedList next;// リストの次の要素

	@Override
	public LinkedList getNext() {
		return next;
	}

	@Override
	public void setnext(LinkedList next) {
		this.next = next;
	}

	@Override
	public Object getStatus() {
		return Status;
	}

	@Override
	public void setStatus(Object status) {
		Status = status;
		
	}
	@Override
	public int numElement(LinkedList list) {
		int num = 1;
		LinkedList nowlist = list;
		while (nowlist.next != null) {
			num++;
			nowlist = list.next;
		}
		return num;
	}
	
	

	

}
