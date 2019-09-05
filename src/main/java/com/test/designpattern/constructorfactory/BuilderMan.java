package com.test.designpattern.constructorfactory;

public class BuilderMan {
	
	public static void main(String[] args) {
		
		System.out.println(Director.buildHouse(new BuilderImpl()));
	}

}
	