package jpl.ch01.ex15;

public class SimpleLookup implements InproveLookup {
	private String[]names;
	private Object[] values;

	@Override
	public Object find(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name))
				return values[i];
		}
		return null;
	}

	

	@Override
	public Object add(String name) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object remove(String name) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
