package com.test.designpattern.singletonmodel;

public class MainMethod {
	
	public static void main(String[] args) {
//		Singleton s1 = Singleton.getInstance();
//		Singleton s2 = Singleton.getInstance();	
//		System.out.println(s1 == s2);
		
		
		Thread2[] ThreadArr = new Thread2[10];
		for (int i = 0; i < ThreadArr.length; i++) {
			ThreadArr[i] = new Thread2();
			ThreadArr[i].start();
		}
	}

}

class Thread2 extends Thread {
	
	public void run() {
		System.out.println(Singleton5.getSingleton5().hashCode());
	}
}