package com.test.designpattern.prototypefactory;

public class WorkExperience implements Cloneable{
	
	private String name;
	
	private String address;
	
	public WorkExperience() {
		super();
	}

	public WorkExperience(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Object clone() throws CloneNotSupportedException{
		WorkExperience experience = (WorkExperience) super.clone();
		return experience;
	}

	@Override
	public String toString() {
		return "WorkExperience [name=" + name + ", address=" + address + "]";
	}

}
