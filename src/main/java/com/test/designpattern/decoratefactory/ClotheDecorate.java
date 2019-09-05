package com.test.designpattern.decoratefactory;

public class ClotheDecorate implements Person {
	
	public Person person;
	
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public void dressing() {
		person.dressing();

	}

}
