package jpl.ch03.ex10;

import static org.hamcrest.CoreMatchers.*;

public class LinkedList implements Cloneable {
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
	public int numElement(LinkedList list){
		int num = 1;
		LinkedList nowlist = list;
		while(nowlist.next != null){
			num++;
			nowlist = list.next;
		}
		return  num;
	}
	
	public LinkedList clone(){
		try {
			LinkedList nObj = this;
			nObj.
			
				
			return nObj;
		} catch (CloneNotSupportedException e) {
			// TODO 自動生成された catch ブロック
			throw new InternalError(e.toString());
		}
		
		
	}

}
