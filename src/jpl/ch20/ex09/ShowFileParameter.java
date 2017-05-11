package jpl.ch20.ex09;

import java.io.File;

public class ShowFileParameter {
	File file;
	public ShowFileParameter(File file){
		this.file = file;
	}

	public void showParameter(){
		System.out.println(file);
		System.out.println(file.getName());
		System.out.println(file.getPath());
	}

}
