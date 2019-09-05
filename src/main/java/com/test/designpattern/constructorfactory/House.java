package com.test.designpattern.constructorfactory;

public class House {

	private String basic;// 地基

	private String wall;// 墙

	private String roofed;// 楼顶
	
	private String window;	//窗户

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getWall() {
		return wall;
	}

	public void setWall(String wall) {
		this.wall = wall;
	}

	public String getRoofed() {
		return roofed;
	}

	public void setRoofed(String roofed) {
		this.roofed = roofed;
	}

	public String getWindow() {
		return window;
	}

	public void setWindow(String window) {
		this.window = window;
	}

	@Override
	public String toString() {
		return "House [basic=" + basic + ", wall=" + wall + ", roofed=" + roofed + ", window=" + window + "]";
	}
	
}
