package com.test.designpattern.watchedfactory;

import java.util.ArrayList;
import java.util.List;

//此处有点小问题，待后续优化。
public class EarthQuake implements Subject {
	
	private List<Observer> observers ;
	
	private String something;
	
	public EarthQuake() {
		observers = new ArrayList<Observer>();
	}
	
	//增加观察者
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	//移除观察者
	@Override
	public void detachObserver(Observer observer) {
		observers.remove(observer);
	}
	
	//通知所有的观察者
	@Override
	public void noticeObserver() {
		for(Observer observer : observers){
			observer.update();
		}

	}

	public String getSomething() {
		return something;
	}

	public void setSomething(String something) {
		this.something = something;
		System.out.println(something);
		noticeObserver();
	}

}
