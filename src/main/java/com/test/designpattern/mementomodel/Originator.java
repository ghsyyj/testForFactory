package com.test.designpattern.mementomodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 	备忘录模式发起人
 *
 */
public class Originator {
	
	private List<String> states;
	
	private int index;
	

	public Originator() {
		this.states = new ArrayList<String>();
		this.index = 0;
	}

	public Memento createMemento() {
		
		return new Memento(states, index);
	}
	
	public void resumeMemento(Memento memento) {
		states = memento.getStates();
		index = memento.getIndex();
	}
	
	public void setMemento(String state) {
		states.add(state);
		index++;
	}
	
	public void showMemento() {
		for(String state : states) {
			System.out.println(state);
		}
	}
}
