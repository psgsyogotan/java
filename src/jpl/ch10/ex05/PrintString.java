package jpl.ch10.ex05;

public class PrintString {

	public PrintString() {

	}

	public void printchartochar(char c1, char c2) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int i = 0;

		if (c1 < 'A' || c1 > 'z')
			System.out.println("No Alphabet");
		else if (c2 < 'A' || c2 > 'Z')
			System.out.println("No Alphabet");
		else {
			if (c1 < c2) {
				while (alphabet.charAt(i) != c1)
					i++;
				i++;
				while (true) {
					if (alphabet.charAt(i) != c2) {
						System.out.print(alphabet.charAt(i));
						i++;
					
					}
					else
						break;
				}
			}else
				System.out.println("Please c1 .c2");
		}
}

}
