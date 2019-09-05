package com.test.designpattern.prototypefactory;

import java.io.Serializable;

public class PersonsExperience implements Serializable, Cloneable{
	
	private static final long serialVersionUID = -5765673039790526109L;

	private String name;
	
	private String sex;
	
	private String age;
	
	private WorkExperience workExperience;
	
	public PersonsExperience() {
		super();
	}

	public PersonsExperience(String name, String sex, String age, WorkExperience workExperience) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.workExperience = workExperience;
	}


	public PersonsExperience clone() throws CloneNotSupportedException{
		PersonsExperience personsExperience = (PersonsExperience) super.clone();
		return personsExperience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public WorkExperience getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(WorkExperience workExperience) {
		this.workExperience = workExperience;
	}

	@Override
	public String toString() {
		return "PersonsExperience [name=" + name + ", sex=" + sex + ", age=" + age + ", workExperience="
				+ workExperience + "]";
	}

}
