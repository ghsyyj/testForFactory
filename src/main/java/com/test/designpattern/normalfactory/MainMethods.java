package com.test.designpattern.normalfactory;

public class MainMethods {
	
	public static void main(String[] args) {
		CalculateFactory factory = new CalculateAddFactory();
		CalculateInterface calculateInterface = factory.createCalculate();
		int rs1 = calculateInterface.getResult(3, 4);
		System.out.println(rs1);
		CalculateFactory factory2 = new CalculateSubtractFactory();
		CalculateInterface interface1 = factory2.createCalculate();
		int rs2 = interface1.getResult(3, 2);
		System.out.println(rs2);
	}

}
