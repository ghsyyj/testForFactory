package com.test.designpattern.simplefactory;

public class CalculateSubstract implements CalculateInterface{

	@Override
	public int getResult(int a, int b) {
		
		return a - b ;
	}

}
