package jpl.ch01.ex10;

public class InprovedFibonacci {

	public static int MAX_INDEX = 9;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int lo = 1;
		int hi = 1;

		 NumandBool[] numbool = new NumandBool[MAX_INDEX];
		 for(int i = 0; i <MAX_INDEX; i++){
			 numbool[i] = new NumandBool();
		 }

		numbool[0].num = 1;
		numbool[0].IsEven = false;

		for (int i = 1; i < MAX_INDEX; i++) {
			if (hi % 2 == 0)
				numbool[i].IsEven = true;
			
			else
				numbool[i].IsEven = false;
			numbool[i].num = hi;
			hi = lo + hi;
			lo = hi - lo;
		}

		for (int i = 1; i < numbool.length; i++) {
			if (numbool[i].IsEven == true) {
				System.out.println(i + ":" + numbool[i].num + " *");
			}
			else{
				System.out.println(i + ":" + numbool[i].num);
				
			}
				
		}

	}
}
