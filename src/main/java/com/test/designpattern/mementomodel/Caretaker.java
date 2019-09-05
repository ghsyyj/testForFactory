package com.test.designpattern.mementomodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 	管理者
 *
 */
public class Caretaker {

	private Originator o;
	
	private List<Memento> mementos = new ArrayList<Memento>();
	
	private int current;
	
	public Caretaker(Originator o) {
		this.o = o;
		current = 0;
	}
	
	//创建一个新的检查点
	public int createMemento() {
		Memento memento = o.createMemento();
		mementos.add(memento);
		return current++;
	}
	
	//删除某个节点检查点
	public void removeMemento(int index) {
		mementos.remove(index);
	}
	
	//回复某个检查点
	public void resumeMemento(int index) {
		Memento memento = mementos.get(index);
		o.resumeMemento(memento);
	}
}
