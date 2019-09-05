package com.test.designpattern.proxyfactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SingMethods {
	
	public static void main(String[] args) {
//		ISinger iSinger = new Singer();
//		ISinger proxy = new SingerProxy(iSinger);
//		proxy.sing();
		
//		activeProxy();
		
		Singer singer = new Singer();
		Singer proxy = (Singer) new ProxyFactoryCglib(singer).getProxyInstance();
		proxy.sing();
	}
	
	//动态代理。
	public static void activeProxy(){
		
		Singer singer = new Singer();
		ISinger proxy = (ISinger) Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), 
				new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("begin sing");
				Object object = method.invoke(singer, args);
				System.out.println("end sing");
				return object;
			}
		});
		proxy.sing();
	}

}
