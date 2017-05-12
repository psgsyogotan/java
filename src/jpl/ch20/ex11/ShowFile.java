package jpl.ch20.ex11;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class ShowFile {
	private String backword;

	public ShowFile(String backword) {
		this.backword = backword;
	}

	public void print(File directory) {
		for (File file : directory.listFiles(new Filter())) {
			System.out.println(file);
		}
	}

	private class Filter implements FileFilter {
		@Override
		public boolean accept(File pathname) {
			return pathname.isFile() && pathname.getName().endsWith(backword);
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		ShowFile sf = new ShowFile(".txt");
		File file = new File("C:\\Users\\Syogo\\git\\java\\src\\jpl\\ch20\\ex11");
		File.createTempFile("prefix1", "suffix", file);
		File.createTempFile("prefix2", ".txt", file);
		File.createTempFile("prefix3", "suffix", file);
		sf.print(file);
	}
}
