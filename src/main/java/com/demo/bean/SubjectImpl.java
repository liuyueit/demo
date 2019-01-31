package com.demo.bean;

public class SubjectImpl implements Subject {

	@Override
	public void rent() {
		// TODO Auto-generated method stub
		System.out.println("I want to rent");
	}

	@Override
	public void hello(String str) {
		// TODO Auto-generated method stub
		System.out.println("hello: " + str);
	}

}
