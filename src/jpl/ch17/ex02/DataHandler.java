package jpl.ch17.ex02;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.file.Files;

public class DataHandler {
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	byte[] readFile(File file)throws IOException{
		byte[] data;

		if (file.equals(lastFile.get())) {
			data = lastData.get();
			if (data != null)
				return data;
		}
		data = readBytesFromFile(file);
		lastFile = new WeakReference<>(file);
		lastData = new WeakReference<>(data);
		return data;

	}

	private static byte[] readBytesFromFile(File file) throws IOException {
return Files.readAllBytes(file.toPath());
		}


}
