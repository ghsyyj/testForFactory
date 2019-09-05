package com.test.designpattern.normalfactory;

public class CalculateSubtractFactory implements CalculateFactory {

	@Override
	public CalculateInterface createCalculate() {
		
		return new CalculateSubtract();
	}

}
