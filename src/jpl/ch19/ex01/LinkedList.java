package jpl.ch19.ex01;

/**
 * LinkedList object defines an attribute as a status/next pair, where the status is a <code>Object</code>
 *and the next an arbitrary <code>LinkedList</code>
 *
 * @version 1.0
 * @author Shohgo Aizawa
 * @since 1.0
 *
 */
public class LinkedList {
	/** The attribute status. */
	private Object status;
	/** The attribute LinkedList. */
	private LinkedList next;

	/**
	 * Creates a new attribute with the given status and an
	 * initial next of <code>null</code>
	 * @see LinkedList#LinkedList(Object,LinkedList)
	 */
	public LinkedList(Object status){
		this.status = status;
		this.next = null;
	}

	/**
	 * Creates a new attribute with the given status and next
	 * @see LinkedList#LinkedList(Object)
	 */
	public LinkedList(Object status, LinkedList next){
		this.status = status;
		this.next = next;
	}

	/**Returns this attribute's next.
	 @return the original value */
	public LinkedList getNext() {
		return next;
	}

	/**set this attribute's status. 
	 * @param next the new value for the attribute */
	public void setNext(LinkedList next) {
		this.next = next;
	}

	/**Returns this attribute's status. 
	 * @return the original value */
	public Object getStatus() {
		return status;
	}

	/**set this attribute's status. 
	 * @param status the new value for the attribute */
	public void setStatus(Object status) {
		this.status = status;
	}

	/**Returns the number of connected elements in the list 
	 * @return the original value
	 * @param list the list you want to check number of elements*/
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
