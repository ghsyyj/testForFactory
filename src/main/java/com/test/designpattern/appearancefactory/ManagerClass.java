package com.test.designpattern.appearancefactory;

/**
 *	基金管理者
 */
public class ManagerClass {
	
	private StorkClass storkClass;
	
	private Stork2Class stork2Class;
	
	private JIjinClass jIjinClass;
	
	public ManagerClass(){
		storkClass = new StorkClass();
		stork2Class = new Stork2Class();
		jIjinClass = new JIjinClass();
	}
	
	public void sell(){
		storkClass.sell();
		stork2Class.sell();
		jIjinClass.sell();
	}
	
	public void buy(){
		storkClass.buy();
		stork2Class.buy();
		jIjinClass.buy();
	}

}
