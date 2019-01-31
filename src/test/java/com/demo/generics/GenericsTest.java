package com.demo.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.bean.Human;
import com.demo.bean.Woman;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenericsTest {
	private static final Logger log = LoggerFactory.getLogger(GenericsTest.class);
	@Test
	public void testET() {
		// 泛型方法，用<T>来限制输入参数和返回参数的关系
		List<String> rs = ibatisDao(String.class); // 限定返回结果类型为String
		log.info("查询结果：{}", rs);
		
		// 得益于RTTI泛型方法会保留类型
		List<String> l1 = new ArrayList<String>();
		l1.add("yang");
//		String r = (String) unionList(l1, "wenhan");
		
		// 泛型类，在new的时候就指定类型
		ElementHold<Woman> eleHolder = new ElementHold<Woman>();
		eleHolder.setNode(new Woman());
		
	}
	
//	@Test
	public void testQuestionmark() {
		Woman woman = new Woman();
		List<Human> humanList = new ArrayList<Human>();
		List<Woman> womanList = new ArrayList<Woman>();
		womanList.add(woman);
		
		// 什么情况下要使用？？通配符只用于集合类
//		List<Human> humanList2 = womanList; // 报错，List<Woman>不是List<Human>的子类，为了解决这个问题引入 ? 
		List<?> humanList2 = womanList;
//		humanList2.add(new Human()); // 报错，不能添加或者修改, 因为并不知道应该添加什么类型
		
		// 使用？可以设置上界和下界, 这样可以向上转型成Human
		List<? extends Human> humanList3 = womanList;
		List<Human> humanList4 = (List<Human>) humanList3;
		
		// 得益于RTTI，humanList4仍然为Woman
		log.info("humanList4里面元素的确切类型：{}", humanList4.get(0).getClass().getName());
		
		log.info("对象集合json结果: {}", convertBeanToJsonStr(humanList4));
		
	}
	
	private <E> List<E> unionList(List<E> s1, E s2) {
		List<E> s3 = new ArrayList<E>();
		log.info("泛型类型为：{}", s1.get(0).getClass());
		return s3;
	}
	
	// 泛型方法一定是用<T>修饰，参数一定是T，返回值类型可以是int也可以是List<T>
	private <T> List<T> ibatisDao(Class<T> clazz) {
		// 模拟数库查询假设不知道查出来的结果是什么类型
		List<String> rs = new ArrayList<String>();
		rs.add("yangwenhan");
		return (List<T>) rs;
	}
	
	private String convertBeanToJsonStr(List<? extends Object> bean) {
		if (bean.isEmpty()) {
			return "集合为空";
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(bean);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

// 泛型类， 防止显示cast，在new一个泛型类的时候告诉编译器想使用什么类型
class ElementHold<E extends Human> {
	E node;
	public E getNode() {
		return node;
	}
	public void setNode(E node) {
		 this.node = node;
	}
}
