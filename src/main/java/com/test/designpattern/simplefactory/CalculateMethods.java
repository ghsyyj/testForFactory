package com.test.designpattern.simplefactory;


 /**
 *	可以用反射来去除switch或者if，解除分支判断带来的耦合。
 */
public class CalculateMethods {

	public static void main(String[] args) throws Exception{
		
		CalculateInterface interface1 = CalculateFactory.getResult("+");
		
		System.out.println(interface1.getResult(12,12));
	}
}
