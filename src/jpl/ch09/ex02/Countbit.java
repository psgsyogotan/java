package jpl.ch09.ex02;

public class Countbit {

	public int countbit(int num) {
		int count = 0;
		int check = 1;

		for(int i = 0; i < 32; i++){
			if ((num & check) != 0) {
				count++;
			}
			check = check << 1;
		}
		return count;
	}
}
