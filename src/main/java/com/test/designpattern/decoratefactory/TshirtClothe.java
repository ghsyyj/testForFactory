package com.test.designpattern.decoratefactory;

public class TshirtClothe extends ClotheDecorate {

	private String color;
	
	public TshirtClothe(String color) {
		super();
		this.color = color;
	}

	@Override
	public void dressing(){
		super.dressing();
		System.out.println("wearing "+ color+" Tshirt");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
