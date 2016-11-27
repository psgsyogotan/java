package jpl.ch03.ex11;

abstract class SortDouble {
	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	
	abstract void doSort();
	
	public final SortMetrics sort(double[]data){
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}
	
	public final SortMetrics getMetrics(){
		return curMetrics.clone();
	}
	
	protected final int getDatalength(){
		return values.length;
	}
	
	protected final double probe(int i){
		curMetrics.ProbeCntInc();
		return values[i];
	}
	
	protected final int compare(int i, int j){
		curMetrics.CompareCntInc();;
		double d1 = values[i];
		double d2 = values[j];
		if(d1 == d2)
			return 0;
		else
			return(d1 < d2 ? -1:1);
	
	}
	
	protected final void swap(int i, int j){
		curMetrics.SwapCntInc();
		double tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

}

//SortMetricsのフィールドの値がpublicであるため、アクセッサーを帰すことなく値を変更できてします。
//そこでSortMetric内のフィールドをprivateにする
