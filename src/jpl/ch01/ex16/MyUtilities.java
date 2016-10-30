package jpl.ch01.ex16;

import java.io.FileInputStream;
import java.io.IOException;

class BadDataSetException extends Exception {
}

public class MyUtilities {
	
	//データの集まりの名前と、問題を通知しているIO例外を保持できるフィールド
	private IOException exceptionName;
	public double[] getDataSet(String setName) throws BadDataSetException {
		String file = setName + ".dset";
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			return readDataSet(in);
		} catch (IOException e) {
			throw new BadDataSetException();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				;
			}
		}
	}
	
	//中身がわからないためとりあえず
	public double[] readDataSet(Object a){
		return null;
		
	}

}
