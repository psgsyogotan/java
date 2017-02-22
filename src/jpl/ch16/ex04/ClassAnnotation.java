package jpl.ch16.ex04;

import java.lang.annotation.Annotation;

public class ClassAnnotation {

	public static void main(String[] args) {
		try {
			System.out.println(args[0].toString());
			Class<?> cls = Class.forName(args[0]);
			Annotation[] annotations = cls.getAnnotations();
			for (Annotation a : annotations) {
				   System.out.println(a);
				 }
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}

	}

}
