package com.test.designpattern.watchedfactory;

public class Animal implements Observer {
	
	private String something;
	
	public Animal(String something) {
		this.something = something;
	}
	
	@Override
	public void update() {
		setDoSomething();
	}

	public void setDoSomething() {
		System.out.println(something);
	}
	
}
