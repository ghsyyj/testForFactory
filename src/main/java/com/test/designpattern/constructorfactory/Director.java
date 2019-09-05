package com.test.designpattern.constructorfactory;

public class Director {

	public static House buildHouse(BuilderImpl builderImpl){
		builderImpl.buildeBasic();
		builderImpl.buildWall();
		builderImpl.buildWindow();
		builderImpl.buildRoofed();
		
		return builderImpl.buildHouse();
	}
}
