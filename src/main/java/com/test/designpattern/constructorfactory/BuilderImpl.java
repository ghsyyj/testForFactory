package com.test.designpattern.constructorfactory;

public class BuilderImpl implements Builder{
	
	private House house;
	
	public BuilderImpl() {
		house = new House();
	}

	@Override
	public void buildeBasic() {
		house.setBasic("打基础");
		
	}

	@Override
	public void buildWall() {
		house.setWall("造墙");
		
	}

	@Override
	public void buildRoofed() {
		house.setRoofed("造屋顶");
		
	}

	@Override
	public void buildWindow() {
		house.setWindow("这是窗子");
		
	}

	@Override
	public House buildHouse() {
		
		return house;
	}

}
