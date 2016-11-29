package jpl.ch04.ex02;



final class SortMetrics implements Cloneable {
	public long probeCnt, compareCnt, swapCnt;

	public void init() {
		probeCnt = swapCnt = compareCnt = 0;

	}

	public String toString() {
		return probeCnt + "probe " + compareCnt + "compares " + swapCnt + "swaps";
	}

	public SortMetrics clone() {
		try {
			return (SortMetrics) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

}
