package com.test.designpattern.strategyfactory;

public class BeiJingHYUNDAI implements CarInterface {

	@Override
	public void car(String name, String color) {
		System.out.println(name + "selling" + color + "car");
	}

}
