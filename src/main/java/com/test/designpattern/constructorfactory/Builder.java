package com.test.designpattern.constructorfactory;

public interface Builder {
	
	public void buildeBasic();
	
	public void buildWall();
	
	public void buildRoofed();
	
	public void buildWindow();
	
	public House buildHouse();

}
