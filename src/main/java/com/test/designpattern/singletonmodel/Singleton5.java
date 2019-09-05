package com.test.designpattern.singletonmodel;

public class Singleton5 {
	
	private static Singleton5 singleton5;
	
	private Singleton5() {
		
	}
	
	public static Singleton5 getSingleton5() {
		
		if(null == singleton5) {
			synchronized (Singleton5.class) {
				if(null == singleton5) {
					singleton5 = new Singleton5();
				}
			}
		}
		
		return singleton5;
	}

}
