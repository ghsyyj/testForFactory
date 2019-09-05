package com.test.designpattern.decoratefactory2;

public class Skirt2 extends Clothe2 {
	
	private String size;

	public Skirt2() {
		super();
	}
	
	public Skirt2(String size) {
		this.size = size;
		System.out.println("wearing " + size + " skirt");
	}
	
	@Override
	public void dressing(){
		super.dressing();
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}
