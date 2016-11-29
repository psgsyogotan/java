package jpl.ch04.ex02;



public abstract class SortObject implements Sortinterface {

	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	public final SortMetrics sort(Object[] data) {
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}

	protected abstract void doSort() ;

	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	public final int getDataLength() {
		return values.length;

	}

	public final Object probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}

	public final int compare(int i, int j) {
		curMetrics.compareCnt++;
		int d1 = values[i].hashCode();
		int d2 = values[j].hashCode();
		if (d1 == d2)
			return 0;

		else
			return (d1 < d2 ? -1 : i);
	}
	
	public final void swap(int i, int j){
		curMetrics.swapCnt++;
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

}
