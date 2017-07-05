package jpl.ch22.ex12;

import java.util.Iterator;
import java.util.LinkedList;

public class AttributedImpl implements Attributed, Iterable<Attr> {
	private LinkedList<Attr> list = new LinkedList<Attr>();

	@Override
	public Iterator<Attr> iterator() {
		return this.attrs();
	}

	@Override
	public void add(Attr newAttr) {
		list.add(newAttr);

	}

	@Override
	public Attr find(String attrName) {
		for (Attr attr : this.list) {
			if (attr.getName().equals(attrName)) {
				return attr;
			}
		}
		return null;
	}

	@Override
	public Attr remove(String attrName) {
		Attr attr = find(attrName);
		if (attr == null) {
			return null;
		}

		this.list.remove(attr);
		return attr;
	}

	@Override
	public Iterator<Attr> attrs() {
		return list.iterator();
	}

}
