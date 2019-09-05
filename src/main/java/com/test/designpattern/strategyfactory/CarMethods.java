package com.test.designpattern.strategyfactory;


//如果该策略模式，新增一个工厂，用来判断main方法中所传入的策略类
//main方法根据传入的某个参数，由工厂来判断调用哪个策略类
//策略模式+简单工厂模式
public class CarMethods {

	public static void main(String[] args) {
//		Person person = new Person(new LandRoverCar());
		Person person = new Person(new BeiJingHYUNDAI());
		person.doSomething("小明", "blue");
	}
}
