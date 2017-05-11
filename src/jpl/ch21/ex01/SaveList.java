package jpl.ch21.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SaveList {
	String filePath;

	public SaveList(String filePath) {
		this.filePath = filePath;

	}

	public List<String> saveList() throws IOException {

		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		List<String> list = new LinkedList<String>();

		String str;


		while ((str = br.readLine()) != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).compareTo(str) < 0) {
					list.add(i, str);
					break;
				}
				if (i == list.size() - 1) {
					list.add(str);
					break;
				}
			}
			if(list.size() == 0)
				list.add(str);
		}
		br.close();
		return list;

	}

	public static void main(String[] args) throws IOException {
		SaveList sl = new SaveList("C:\\Users\\Syogo\\git\\java\\src\\jpl\\ch21\\ex01\\test.txt");
		List<String> list = sl.saveList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
