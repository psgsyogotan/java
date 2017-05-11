package jpl.ch21.ex07;

import java.util.ArrayList;

public class OriginalStack<E> {
	private ArrayList<E> stack = new ArrayList<E>();

	public boolean empty() {
		return stack.isEmpty();
	}

	public E push(E element) {
		stack.add(element);
		return element;
	}

	public E pop() {
		E element = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return element;
	}

	public E peek() {
		return stack.get(stack.size() - 1);
	}

	public int search(Object element) {
		return stack.indexOf(element);
	}

}