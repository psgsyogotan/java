package java8.ch01.ex04;

import java.io.File;
import java.util.Arrays;

public class SortFileArray {
	String pass;
	File[] files;

	public SortFileArray(String pass) {
		File file = new File(pass);
		files = file.listFiles(f -> f.isDirectory());
	}

	public File[] sortFiles() {
		Arrays.sort(files, (file1, file2) -> {
			int type1 = getFileType(file1);
			int type2 = getFileType(file2);

			if (type1 == type2) {
				return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
			} else {
				return type1 - type2;
			}
		});

		return files;

	}

	private int getFileType(File file) {
		if (file.isDirectory())
			return 1;
		else if (file.isFile())
			return 2;
		else
			return 3;
	}

	public static void main(String[] args) {
		SortFileArray sfa = new SortFileArray("C:\\Test");
		File[] files = sfa.sortFiles();
		for (File f : files) {
			System.out.println(f.getName());
		}

	}
}
