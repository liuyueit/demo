package com.demo.designPattern;

import java.text.NumberFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaticFactory {
	@Test
	public void staticFactory() {
		// 框架里面经常用到，实际业务代码用的少
		NumberFormat.getCurrencyInstance();
		NumberFormat.getPercentInstance();
	}
}
