package jpl.ch14.ex03;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		SyncroSum syncroSum = new SyncroSum();
		
		
		for(int i = 0; i < 100; i++){
			CountUpThread thread = new CountUpThread(syncroSum);
			Thread th = new Thread(thread);
			th.start();
			
		}

	}

}
