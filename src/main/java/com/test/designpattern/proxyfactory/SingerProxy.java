package com.test.designpattern.proxyfactory;

public class SingerProxy implements ISinger {
	
	private ISinger iSinger;
	
	public SingerProxy(ISinger iSinger) {
		this.iSinger = iSinger;
	}

	@Override
	public void sing() {
		System.out.println("begin sing");
		iSinger.sing();
		System.out.println("end sing");
	}

}
