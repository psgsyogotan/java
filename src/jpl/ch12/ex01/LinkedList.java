package jpl.ch12.ex01;

public class LinkedList {

	private Object status; // Object型のフィールド
	private LinkedList next;// リストの次の要素

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

	public Object getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = status;
	}

	public int numElement(LinkedList list) {
		int num = 1;
		LinkedList nowlist = list;
		while (nowlist.next != null) {
			num++;
			nowlist = list.next;
		}
		return num;
	}

	public LinkedList find(LinkedList list, Object object) throws ObjectNotFoundException {

		do {
			if (list.status.equals(object))
				return list;
			list = list.next;
		} while (list.next != null);
		
		//objectがlistを探索しても見つからなかったとき
		throw new ObjectNotFoundException(object.toString());

	}

}
