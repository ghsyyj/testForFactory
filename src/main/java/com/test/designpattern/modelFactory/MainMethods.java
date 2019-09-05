package com.test.designpattern.modelFactory;

public class MainMethods {

	public static void main(String[] args) {
		System.out.println("A的答案是 ：");
		StudentA a = new StudentA();
		a.question1();
		a.question2();
		a.question3();
		System.out.println("B的答案是：");
		StudentB b = new StudentB();
		b.question1();
		b.question2();
		b.question3();
	}

}
