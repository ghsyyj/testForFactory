package com.test.designpattern.AdapterFactory;

public class Adapter extends ElectrictPower {
	
	@Override
	public void getPower(){
		System.out.println("经过转换的家用电");
	}

}
