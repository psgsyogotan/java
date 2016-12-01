package jpl.ch04.ex03;

public interface LinkedListInterface {

	LinkedList getNext();
	void setnext(LinkedList next);
	Object getStatus();
	void setStatus(Object status);
	int numElement(LinkedList list);
}
