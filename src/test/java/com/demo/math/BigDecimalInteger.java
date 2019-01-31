package com.demo.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BigDecimalInteger {
	@Test 
	public void testJingdu() {
		Double n = 0.1;
		Double m = 0.3;
		Double sum = n + n + n;
		
		// 所以Double存在精度损失的问题，一般都使用的BigDecimal
		System.out.println(sum.equals(m));
        System.out.println(0.1 + 0.1 == 0.2); // true
        System.out.println(0.1 + 0.1 + 0.1 == 0.3); // false
	}
	
//	@Test // 这个叫单元测试，可以只运行这一个方法
	public void testFloat() {
		System.out.println("Double类型的上限" + Double.MAX_VALUE); // 1.79769乘以10的308次方
		System.out.println("Double类型的下限" + Double.MIN_VALUE); // Double类型的下限
	}
}
