package com.test.designpattern.decoratefactory;

public class SkirtClothe extends ClotheDecorate {
	
	public void unDressing(){
		System.out.println("Tack off skirt");
	}

	@Override
	public void dressing(){
		super.dressing();
		this.unDressing();
		System.out.println("this is skirtClothe methods");
	}
}
