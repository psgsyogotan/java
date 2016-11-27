package jpl.ch03.ex10;

public class LinkedList implements Cloneable {
	private Object Status; // Object型のフィールド
	private LinkedList next;// リストの次の要素



	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

	public Object getStatus() {
		return Status;
	}

	public void setStatus(Object status) {
		Status = status;
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

	public Object Clone() {
		try {
			LinkedList list = (LinkedList) super.clone();
			if (next != null) {
				list.next = (LinkedList) next.clone();
			}
			return list;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
	// 以下、未実装

}
