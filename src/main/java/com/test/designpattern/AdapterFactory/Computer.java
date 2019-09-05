package com.test.designpattern.AdapterFactory;

public class Computer {
	
	private Adapter adapter;
	
	public void charging(){
//		System.out.println("电脑充电");
		adapter.getPower();
	}

}
