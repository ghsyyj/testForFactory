package com.test.designpattern.watchedfactory;

public interface Subject {
	
	public void registerObserver(Observer observer);
	
	public void detachObserver(Observer observer);
	
	public void noticeObserver();

}
