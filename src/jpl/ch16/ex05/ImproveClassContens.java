package jpl.ch16.ex05;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImproveClassContens extends jpl.ch16.ex03.ClassContens {

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembersDelRepeat(c.getDeclaredFields(), c.getFields());
			System.out.println();
			printMembersDelRepeat(c.getDeclaredConstructors(), c.getConstructors());
			System.out.println();
			printMembersDelRepeat(c.getDeclaredMethods(), c.getMethods());
		} catch (ClassNotFoundException e) {
			System.out.println("unkown class: " + args[0]);
		}
	}

	private static void printMembers(Field[] field) {
		for (Field f : field) {
			if (f.getDeclaringClass() == Object.class)
				continue;
			String decl = f.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.util."));

			for (Annotation a : f.getAnnotations()) {
				System.out.print("  ");
				System.out.println(a.toString());
			}
		}
	}

	private static void printMembers(Constructor<?>[] constructor) {
		for (Constructor<?> c : constructor) {
			if (c.getDeclaringClass() == Object.class)
				continue;
			String decl = c.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.util."));

			for (Annotation a : c.getAnnotations()) {
				System.out.print("  ");
				System.out.println(a.toString());
			}
		}
	}

	private static void printMembers(Method[] method) {
		for (Method m : method) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.util."));

			for (Annotation a : m.getAnnotations()) {
				System.out.print("  ");
				System.out.println(a.toString());
			}
		}
	}

	private static void printMembersDelRepeat(Field[] Fields, Field[] rawFields) {
		Boolean flag = false;

		printMembers(rawFields);
		System.out.println();

		for (int i = 0; i < Fields.length; i++) {
			if (Fields[i].getDeclaringClass() == Object.class)
				continue;
			for (int j = 0; j < rawFields.length; j++) {
				if (Fields[i].getName().equals(rawFields[j].getName()))
					flag = true;

			}
			if (!flag) {
				String decl = Fields[i].toString();
				System.out.print(" ");
				System.out.println(strip(decl, "java.util."));

				for (Annotation a : Fields[i].getAnnotations()) {
					System.out.print("  ");
					System.out.println(a.toString());
				}
			}
		}

	}

	private static void printMembersDelRepeat(Constructor<?>[] constructors, Constructor<?>[] rawConstructors) {
		Boolean flag = false;

		printMembers(rawConstructors);
		System.out.println();

		for (int i = 0; i < constructors.length; i++) {
			if (constructors[i].getDeclaringClass() == Object.class)
				continue;
			for (int j = 0; j < rawConstructors.length; j++) {
				if (constructors[i].getName().equals(rawConstructors[j].getName()))
					flag = true;

			}
			if (!flag) {
				String decl = constructors[i].toString();
				System.out.print(" ");
				System.out.println(strip(decl, "java.util."));

				for (Annotation a : constructors[i].getAnnotations()) {
					System.out.print("  ");
					System.out.println(a.toString());
				}
			}
		}

	}

	private static void printMembersDelRepeat(Method[] Methods, Method[] rawMethods) {
		Boolean flag = false;

		printMembers(rawMethods);
		System.out.println();

		for (int i = 0; i < Methods.length; i++) {
			if (Methods[i].getDeclaringClass() == Object.class)
				continue;
			for (int j = 0; j < rawMethods.length; j++) {
				if (Methods[i].getName().equals(rawMethods[j].getName()))
					flag = true;

			}
			if (!flag) {
				String decl = Methods[i].toString();
				System.out.print(" ");
				System.out.println(strip(decl, "java.util."));

				for (Annotation a : Methods[i].getAnnotations()) {
					System.out.print("  ");
					System.out.println(a.toString());
				}
			}
		}

	}

	public static String strip(String rawStr, String delStr) {
		Pattern pattern = Pattern.compile(delStr);
		Matcher matcher = pattern.matcher(rawStr);
		String strtmp = matcher.replaceAll("");
		return strtmp;

	}

}
