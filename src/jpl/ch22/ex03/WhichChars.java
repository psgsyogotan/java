package jpl.ch22.ex03;

import java.util.BitSet;
import java.util.HashMap;

public class WhichChars {
	public HashMap<Integer, BitSet> hm = new HashMap<>();
	Integer higherBit;
	BitSet lowerBit;

	public WhichChars(String str) {
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			higherBit = ch  >>> 8;
			lowerBit = hm.get(higherBit);

			if (lowerBit == null)
				lowerBit= new BitSet();

			lowerBit.set(0x00ff & ch);
			hm.put(higherBit, lowerBit);
		}
	}

	public boolean contains(char ch){
		 		BitSet lowerBit = hm.get(ch >>> 8);
		 		if(lowerBit == null){
		 			return false;
		 		}
		 		return lowerBit.get(0x00ff & ch);
		 	}

}
