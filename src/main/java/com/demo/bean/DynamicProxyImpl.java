package com.demo.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyImpl implements InvocationHandler {
	private Object subject;
	public DynamicProxyImpl(Object subject) {
		this.subject = subject;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("调用被代理的对象的方法前");
		System.out.println("调用的方法是： " + method);
		method.invoke(subject, args);
		System.out.println("调用被代理的对象的方法后");
		return null;
	}

}
