package com.demo.rtti;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.bean.DynamicProxyImpl;
import com.demo.bean.Subject;
import com.demo.bean.SubjectImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyTest {
	
	@Test
	public void testProxy() {
		// TODO Auto-generated method stub
		Subject realSubject = new SubjectImpl();
		InvocationHandler handler = new DynamicProxyImpl(realSubject);
		Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
		System.out.println("subject的name: " + subject.getClass().getName());
		subject.hello("yang");
		subject.rent();
	}
	

}
