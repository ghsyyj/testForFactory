package com.test.designpattern.normalfactory;

public class CalculateAddFactory implements CalculateFactory {

	@Override
	public CalculateInterface createCalculate() {
		
		return new CalculateAdd();
	}

}
