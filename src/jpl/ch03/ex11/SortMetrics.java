package jpl.ch03.ex11;



final class SortMetrics implements Cloneable {
	private long probeCnt, compareCnt, swapCnt;

	public void init() {
		probeCnt = swapCnt = compareCnt = 0;

	}
	public void ProbeCntInc(){
		probeCnt++;
	}
	
	public void SwapCntInc(){
		swapCnt++;
	}
	
	public void CompareCntInc(){
		compareCnt++;
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
