package com.test.designpattern.proxyfactory;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyFactoryCglib implements MethodInterceptor{
	
	private Object object;
	
	public ProxyFactoryCglib(Object object) {
		this.object = object;
	}
	
	public Object getProxyInstance(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(object.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {
		System.out.println("BEGIN SING");
		Object returnVlue = method.invoke(object, arg2);
		System.out.println("END SING");
		return returnVlue;
	}

}
