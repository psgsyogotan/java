package jpl.ch16.ex03;
import java.lang.reflect.Member;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassContens {

	public static void main(String[] args) {
		try{
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(c.getFields());
			System.out.println();
			printMembers(c.getDeclaredFields());
			printMembers(c.getConstructors());
			System.out.println();
			printMembers(c.getDeclaredConstructors());
			System.out.println();
			printMembers1(c.getDeclaredConstructors(), c.getConstructors());
			printMembers(c.getMethods());
			printMembers(c.getDeclaredMethods());
		}catch(ClassNotFoundException e){
			System.out.println("unkown class: " + args[0]);
		}
	}

	private static void printMembers(Member[] mems){
		for(Member m : mems){
			if(m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl,"java.util."));
		}
	}
	private static void printMembers1(Member[] mems, Member[] delmems){
		for(int i = 0; i < mems.length; i++){
			if(mems[i].getDeclaringClass() == Object.class)
				continue;
			for(int j = 0; j < delmems.length; j++){
				String str1 = mems[i].getName();
				String str2 = delmems[j].getName();

				if(true){
					continue;
				}
			}
			String decl = mems[i].toString();
			System.out.print(" ");
			System.out.println(strip(decl,"java.util."));
		}

	}

	public static String strip(String rawStr, String delStr){
		Pattern pattern = Pattern.compile(delStr);
		Matcher matcher =  pattern.matcher(rawStr);
		String strtmp = matcher.replaceAll("");
		return strtmp;

	}
}
