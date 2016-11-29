package jpl.ch04.ex02;

public interface Sortinterface {
	
	SortMetrics sort(Object[] data);
	SortMetrics getMetrics();
	int getDataLength();
	Object probe(int i);
	int compare(int i, int j);
	void swap(int i, int j);
	

}
