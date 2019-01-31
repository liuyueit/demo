package com.demo.lambda;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {
	@Test
	public void testLambda() {
		String[] strArray = new String[] {"a", "baf", "bc"};
		
		// 不使用lambda
		Arrays.sort(strArray, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) {
					return 1;
				} else if (o1.length() < o2.length()) {
					return -1;
				} else {
					return 0;
				}
			}
			
		});
		printObjectArray(strArray);
		
		// 使用lambda
		String[] strArray2 = new String[] {"a", "baf", "bc"};
		
	}
	
	private void printObjectArray(Object[] array) {
		for (Object obj : array) {
			System.out.println(obj);
		}
		System.out.println("-------------------");
	}
}
