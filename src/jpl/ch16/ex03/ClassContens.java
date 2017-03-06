package jpl.ch16.ex03;
import java.lang.reflect.Member;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassContens {

	public static void main(String[] args) {
		try{
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);	
			printMembersDelRepeat(c.getDeclaredFields(),c.getFields());
			System.out.println();
			printMembersDelRepeat(c.getDeclaredConstructors(), c.getConstructors());
			System.out.println();
			printMembersDelRepeat(c.getDeclaredMethods(), c.getMethods());
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
	private static void printMembersDelRepeat(Member[] mems, Member[] rawmems){
		Boolean flag = false;
		
		printMembers(rawmems);
		System.out.println();
		
		for(int i = 0; i < mems.length; i++){

			if(mems[i].getDeclaringClass() == Object.class)
				continue;
			for(int j = 0; j < rawmems.length; j++){
				if(mems[i].getName().equals(rawmems[j].getName()))
					flag = true;
			}
			if(!flag){
			String decl = mems[i].toString();
			System.out.print(" ");
			System.out.println(strip(decl,"java.util."));
			}
		}

	}

	public static String strip(String rawStr, String delStr){
		Pattern pattern = Pattern.compile(delStr);
		Matcher matcher =  pattern.matcher(rawStr);
		String strtmp = matcher.replaceAll("");
		return strtmp;

	}
}
