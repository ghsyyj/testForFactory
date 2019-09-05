package com.test.designpattern.singletonmodel;

public class Singleton4 {
	
	private static Singleton4 singleton4;
	
	private Singleton4() {
		
	}
	
	public static Singleton4 getSingleton4() {
		
		synchronized (Singleton4.class) {
			if(null == singleton4) {
				singleton4 = new Singleton4();
			}
		}
		
		return singleton4;
	}

}
