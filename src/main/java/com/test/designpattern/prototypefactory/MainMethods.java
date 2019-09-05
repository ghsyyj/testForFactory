package com.test.designpattern.prototypefactory;

public class MainMethods {

	public static void main(String[] args) throws CloneNotSupportedException {
		WorkExperience experience1 = new WorkExperience("上海一同","安徽省合肥市");
		PersonsExperience xy = new PersonsExperience();
		xy.setAge("22");
		xy.setName("xy");
		xy.setSex("M");
		xy.setWorkExperience(experience1);
		System.out.println("xy" + xy.toString());
		WorkExperience experience2 = (WorkExperience) experience1.clone();
		PersonsExperience ab = xy.clone();
		experience2.setAddress("上海");
		experience2.setName("上海22");
		ab.setWorkExperience(experience2);
		ab.setAge("24");
		System.out.println("ab" + ab.toString());
	}

}
