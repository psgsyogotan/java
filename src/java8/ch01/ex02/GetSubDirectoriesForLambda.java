package java8.ch01.ex02;

import java.io.File;

public class GetSubDirectoriesForLambda {
	String pass;

	public GetSubDirectoriesForLambda(String pass) {
		this.pass = pass;
	}

	public void showSubDir() {
		File file = new File(pass);
		File[] dirs = file.listFiles(f -> f.isDirectory());
		for (int i = 0; i < dirs.length; i++) {
			System.out.println(dirs[i].getName());
		}
	};

	public static void main(String[] args) {
		GetSubDirectoriesForLambda gsd = new GetSubDirectoriesForLambda("C:\\Test");
		gsd.showSubDir();

	}

}
