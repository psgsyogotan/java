package jpl.ch17.ex02;

import java.io.File;
import java.lang.ref.WeakReference;

public class DataHandler {
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	byte[] readFile(File file) {
		byte[] data;

		if (file.equals(lastFile.get())) {
			data = lastData.get();
			if (data != null)
				return data;
		}

		//記憶していないので、読み込む
		//readBytesFromFileの中身が不明
		//自分で実装するということ？
		//data = readBytesFromFile(file);
		//lastData = new WeakReference<byte[]>(data);
		//return data;

	}

}
