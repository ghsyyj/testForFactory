package com.test.designpattern.decoratefactory;

public class ClientMethods {
	
	public static void main(String[] args) {
		
		Man man = new Man();
		
		SkirtClothe skirtClothe = new SkirtClothe();
		TshirtClothe tshirtClothe = new TshirtClothe("blur");
		skirtClothe.setPerson(man);
		tshirtClothe.setPerson(skirtClothe);
		tshirtClothe.dressing();
	}

}
