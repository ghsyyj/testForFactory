package com.test.designpattern.singletonmodel;

public class Singleton3 {
	
	private static Singleton3 singleton3;
	
	private Singleton3() {
		
	}
	
	public static Singleton3 getSingleton3() {
		return singleton3;
	}

}
