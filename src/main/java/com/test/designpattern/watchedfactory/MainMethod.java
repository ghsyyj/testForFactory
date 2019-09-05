package com.test.designpattern.watchedfactory;

public class MainMethod {
	
	public static void main(String[] args) {
		Observer human = new Animal("人类赶紧跑");
		Observer animal = new Animal("动物发生了动乱");
		
//		EarthQuake earthQuake = new EarthQuake();
//		earthQuake.registerObserver(animal);
//		earthQuake.registerObserver(human);
//		earthQuake.setSomething("地震了");
		CreateSubject earthQuake = new CreateSubject();
		earthQuake.registerObserver(animal);
		earthQuake.registerObserver(human);
		earthQuake.happened("地震了");
		
		System.out.println("---------------------");
		earthQuake.detachObserver(animal);
		earthQuake.happened("发生了严寒酷暑");
	}

}
