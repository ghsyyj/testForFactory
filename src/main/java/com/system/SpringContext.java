package com.system;

import org.springframework.context.ApplicationContext;

public enum SpringContext {

	INSTANCE;
	
	private ApplicationContext ctx;
	
	private SpringContext() {
		
	}
	
	public void setContext(ApplicationContext ctx) {
		this.ctx = ctx;
	}
	
	@SuppressWarnings("unchecked")
	public <T>T getBean(String bean){
		return (T) ctx.getBean(bean);
	}
	
	public <T>T getBean(Class<T> clazz){
		return ctx.getBean(clazz);
	}
}
