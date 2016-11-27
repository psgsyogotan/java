package jpl.ch03.ex11;

public class SimpleSortDouble extends SortDouble{
	protected void doSort(){
		for(int i = 0; i < getDatalength();i++){
			for(int j = i + 1; j < getDatalength();j++){
				if(compare(i,j) > 0)
					swap(i,j);
			}
		}
	}

}
