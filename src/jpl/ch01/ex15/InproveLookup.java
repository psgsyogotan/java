package jpl.ch01.ex15;

public interface InproveLookup extends Lookup {
	Object add(String name);
	Object remove(String name);
	Object find(String name);

}
