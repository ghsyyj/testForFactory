package com.test.designpattern.decoratefactory2;

public class Man2 implements Person2 {
	
	public Person2 person2;
	
	public void setPerson2(Person2 person2) {
		this.person2 = person2;
	}

	@Override
	public void dressing() {
		person2.dressing();
	}

}
