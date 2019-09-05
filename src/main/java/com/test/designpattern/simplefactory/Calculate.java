package com.test.designpattern.simplefactory;

public class Calculate {

	private int a;
	private int b;
	
	public Calculate() {
		super();
	}
	public Calculate(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
}
