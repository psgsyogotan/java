package java8.ch03.ex09;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

public class MakeComparator2 {
	
	private static Object getFieldValue(Object target, String fieldName) {
	    for (Class<?> c = target.getClass(); c != null; c = c.getSuperclass()) {
	        Field field;
	        try {
	            field = c.getDeclaredField(fieldName);
	            field.setAccessible(true);
	            return field.get(target);
	        } catch (IllegalAccessException ex) {
	        } catch (NoSuchFieldException ex) {
	        }
	        
	    }
		return null;
	}
	
	public static Comparator<Object> lexicographicComparator(String... fieldNames) {
	    return (obj1, obj2) -> {
	        for (String fieldName : fieldNames) {
	            Object f1 = getFieldValue(obj1, fieldName);
	            Object f2 = getFieldValue(obj2, fieldName);
	            if (f1.equals(f2)) {
	                continue;
	            }
	            return ((Comparable<Object>)f1).compareTo(f2);
	        }
	        return 0;
	    };
	}
	

		
	public static void main(String[]args){
		Person aizawa = new Person("aizawa", 26);
		Person aruga = new Person("aruga",31);
		Person murase = new Person("murase", 25);
		Person aruga2 = new Person("aruga",29);
		Person[] persons = {murase,aizawa,aruga,aruga2};
		Arrays.sort(persons,lexicographicComparator("name","age"));
		
		for(Person p : persons){
			System.out.println("name: "+p.name+"  age: "+p.age);
		}
	}
	


}
