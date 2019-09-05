package com.test.designpattern.watchedfactory;

import java.util.ArrayList;
import java.util.List;

public class CreateSubject implements Subject {
	
	private List<Observer> observers ;
	
	public CreateSubject() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void detachObserver(Observer observer) {
		observers.remove(observer);

	}

	@Override
	public void noticeObserver() {
		for(Observer o : observers){
			o.update();
		}
	}
	
	public void happened(String something){
		System.out.println(something);
		noticeObserver();
	}

}
