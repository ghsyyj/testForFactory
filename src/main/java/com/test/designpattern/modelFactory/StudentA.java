package com.test.designpattern.modelFactory;

public class StudentA extends QuestionModel {
	
	public String answer1(){
		return "A";
	}

	@Override
	public String answer2() {
		
		return "B";
	}

	@Override
	public String answer3() {
		
		return "C";
	}

}
