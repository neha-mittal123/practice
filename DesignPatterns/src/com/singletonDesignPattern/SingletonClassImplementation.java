package com.singletonDesignPattern;

import java.lang.reflect.Constructor;

public class SingletonClassImplementation {
//	public enum Singleton 
//	{
//	  INSTANCE;
//	}
	private static SingletonClassImplementation instance=null;
    String s;
	

	private SingletonClassImplementation() {
		s="testing";
	}
//	public static SingletonClassImplementation getInstance() {
//		if(instance==null)
//		instance= new SingletonClassImplementation();
//		return instance;
//		
//	}
	public static SingletonClassImplementation getInstance() {
		if(instance==null) {
			synchronized (SingletonClassImplementation.class) {
				if(instance==null)
					instance= new SingletonClassImplementation();
			}
		}
		return instance;
	}
	
	//getInstance() method is synchronized so it causes slow performance as multiple threads 
	//can’t access it simultaneously.
//	public static synchronized SingletonClassImplementation getInstance() {
//		if(instance==null)
//		instance= new SingletonClassImplementation();
//		return instance;
//		
//	}

	public static void main(String[] args) {
//		SingletonClassImplementation x=SingletonClassImplementation.getInstance();
//		SingletonClassImplementation y=SingletonClassImplementation.getInstance();
//		System.out.println("x="+x.s+" "+"y="+y.s);
//		y.s=y.s.toUpperCase();
//		System.out.println("x="+x.s+" "+"y="+y.s);
		
		
		SingletonClassImplementation instance1 = SingletonClassImplementation.getInstance();
		SingletonClassImplementation instance2 = null;
        try
        {
            Constructor[] constructors = 
            		SingletonClassImplementation.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) 
            {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instance2 = (SingletonClassImplementation) constructor.newInstance();
                break;
            }
        }
      
        catch (Exception e) 
        {
            e.printStackTrace();
        }
          
    System.out.println("instance1.hashCode():- " 
                                      + instance1.hashCode());
    System.out.println("instance2.hashCode():- " 
                                      + instance2.hashCode());

	}

}
