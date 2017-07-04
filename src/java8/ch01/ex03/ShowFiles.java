package java8.ch01.ex03;

import java.io.File;

public class ShowFiles {
	String pass;
	String suffix;

	public ShowFiles(String pass,String suffix){
		this.pass = pass;
		this.suffix = suffix;
	}

	public String[] getFilesName(){
		File file = new File(pass);
		String[] files = file.list((f, s) -> s.endsWith(suffix));
		return files;

	}

	public static void main(String[] args) {
		ShowFiles sf = new ShowFiles("C:\\Test","txt");
		String[] filenames = sf.getFilesName();
		for(String s : filenames){
			System.out.println(s);
		}
	}

}
