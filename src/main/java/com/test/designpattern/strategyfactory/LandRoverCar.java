package com.test.designpattern.strategyfactory;

public class LandRoverCar implements CarInterface {

	@Override
	public void car(String name ,String color) {
		System.out.println(name + "driving" + color + "land rover car");

	}
	
}
