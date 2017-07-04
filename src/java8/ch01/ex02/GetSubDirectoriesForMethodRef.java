package java8.ch01.ex02;

import java.io.File;

public class GetSubDirectoriesForMethodRef {
	String pass;

	public GetSubDirectoriesForMethodRef(String pass) {
		this.pass = pass;
	}

	public void showSubDir() {
		File file = new File(pass);
		File[] dirs = file.listFiles(File::isDirectory);
		for (int i = 0; i < dirs.length; i++) {
			System.out.println(dirs[i].getName());
		}
	};

	public static void main(String[] args) {
		GetSubDirectoriesForMethodRef gsd = new GetSubDirectoriesForMethodRef("C:\\Test");
		gsd.showSubDir();

	}

}
