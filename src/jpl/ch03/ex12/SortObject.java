package jpl.ch03.ex12;

abstract class SortObject {
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	public final SortMetrics sort(Object[] data) {
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}

	abstract void doSort() ;

	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	protected final int getDataLength() {
		return values.length;

	}

	protected final Object probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}

	protected final int compare(int i, int j) {
		curMetrics.compareCnt++;
		int d1 = values[i].hashCode();
		int d2 = values[j].hashCode();
		if (d1 == d2)
			return 0;

		else
			return (d1 < d2 ? -1 : i);
	}
	
	protected final void swap(int i, int j){
		curMetrics.swapCnt++;
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

}
