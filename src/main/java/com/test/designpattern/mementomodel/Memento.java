package com.test.designpattern.mementomodel;

import java.util.List;

public class Memento {
	
	private List<String> states;
	
	private int index;
	
	public Memento(List<String> states, int index) {
		this.states = states;
		this.index = index;
	}

	public List<String> getStates() {
		return states;
	}

	public int getIndex() {
		return index;
	}

}
