package com.test.designpattern.normalfactory;

public class CalculateAdd implements CalculateInterface {
	
	private int a;
	
	private int b;

	
	public CalculateAdd() {
		super();
	}

	public CalculateAdd(int a, int b) {
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

	@Override
	public int getResult(int a, int b) {
		
		return a + b;
	}

}
