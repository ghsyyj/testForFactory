package com.test.designpattern.decoratefactory2;

public class TShirtClothe extends Clothe2 {
	
	private String color;
	
	public TShirtClothe() {
		super();
	}
	
	public TShirtClothe(String color) {
		this.color = color;
	}

	@Override
	public void dressing(){
		super.dressing();
		System.out.println("wearing " + color + "TShirt");
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
