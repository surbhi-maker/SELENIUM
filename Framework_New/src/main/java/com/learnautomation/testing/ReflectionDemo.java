package com.learnautomation.testing;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
	
	public static void main(String[] args) throws Exception, SecurityException {
		
		TestingClass obj1 = new TestingClass();
		
		Class cls = obj1.getClass();
		
		System.out.println(cls.getName());
		
		Constructor constructor = cls.getConstructor();
		
		System.out.println(constructor.getName());
		
		Method[] allMethods = cls.getMethods();
		
		for(Method m:allMethods) {
			System.out.println(m.getName());
		}
		
		Field field = cls.getDeclaredField("name");
		System.out.println(field.get(obj1));
		
		
		Method m3 = cls.getDeclaredMethod("showAllDetails");
		
		//changes visibility to public
		m3.setAccessible(true);
		m3.invoke(obj1);
		
//		System.out.println(cls.getme);
	}
}
