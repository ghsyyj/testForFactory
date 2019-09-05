package com.test.designpattern.strategyfactory;

public class Person {
	
	private CarInterface carInterface;
	
	public Person() {
		super();
	}
	
	public Person(CarInterface carInterface) {
		this.carInterface = carInterface;
	}
	
	public void doSomething(String name, String color){
		carInterface.car(name, color);
	}
	
}
