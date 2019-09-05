package com.test.designpattern.modelFactory;

public abstract class QuestionModel {
	
	public abstract String answer1();	
	public abstract String answer2();
	public abstract String answer3();
	
	public void question1(){
		System.out.println("问题1 对应的答案是 " + answer1());
	}
	
	public void question2(){
		System.out.println("问题2 对应的答案是 " + answer2());
	}
	
	public void question3(){
		System.out.println("问题3 对应的答案是 " + answer3());
	}

}
