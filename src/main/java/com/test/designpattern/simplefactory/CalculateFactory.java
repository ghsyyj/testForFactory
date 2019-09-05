package com.test.designpattern.simplefactory;

public class CalculateFactory {

	public static CalculateInterface getResult(String types){
		
		CalculateInterface calc = null;
		switch (types){
			case "+" :
				calc = new CalculateAdd();
				break;
			case "-" :
				calc = new CalculateSubstract();
				break;
			default:
				System.out.println("未找到对应的方法");
		}
		return calc;
		
	}
	
}
