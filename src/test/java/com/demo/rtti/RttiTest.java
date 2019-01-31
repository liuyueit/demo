package com.demo.rtti;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.bean.Human;
import com.demo.bean.Woman;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RttiTest {
	private static final Logger log = LoggerFactory.getLogger(RttiTest.class);

		@Test
	public void testRTTI() throws ClassNotFoundException {
		Human aPerson = new Human("yangwenhan");
		Class<? extends Human> c1      = aPerson.getClass(); // 获得Human类的抽象，即Class，表示了Human类的所有信息（名字，方法，成员变量等）
		log.info("类1名为：{}, classloader为:{}", c1.getName(), c1.getClassLoader());

		Human anotherPerson = new Woman();
		Class<? extends Human> c2      = anotherPerson.getClass(); // 获得Woman类的抽象，虽然向上转型成了Human类，但还是保留的Woman类的信息，这就是多态的基础
		log.info("类2名为：{}", c2.getName()); 

		Class<?> c3 = Class.forName("com.demo.bean.Human"); // 如果对象已经存在（一个或多个，那么只是返回这个类的Class），如果不存在，不创建对象实例（不调用构造函数）但是要执行对象的static代码块和变量
		log.info("类3名为：{}", c3.getName()); 

		Class<Woman> c4 = Woman.class; // 如果对象 不存在，不创建对象实例，不执行static，只获得类的信息
		log.info("类4的信息：{}， {}", c4.getName(), c4.getFields()); 
	}

//	@Test
	public void testReflection() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<Woman> c4 = Woman.class; // 如果对象 不存在，不创建对象实例，不执行static，只获得类的信息
		Woman woman = c4.newInstance();
		log.info("Woman类的名字：{}", c4.getName()); 
		Method[] methods = c4.getMethods();
		for(Method m : methods) {
			log.info("方法信息：{},{}", m.getName(), m.getReturnType());
			if ("sayWomanHi".equals(m.getName())) {
				m.invoke(woman, "通过反射执行sayWomanHi"); // 已经获得了这个类的全部method，但是要执行，需要指定执行哪个对象实例的method，也就是说，这个类必须已经被实例化了
			}
		}
		
		Field[] fields = c4.getDeclaredFields();
		for(Field f : fields) {
			log.info("成员变量信息：{}", f.getName());
		}
	}

}
