package com.demo.basicTypes;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicTypesTest {
//	@Test
	public void  intArrayToIntegerArray() {
		int[] intArray = new int[] {1, 2, 3};
		Integer[] IntegerArray = new Integer[] {4, 5, 6};
//		IntegerArray = intArray; // Error
//		intArray = IntegerArray; // Error
	}
	
//	@Test
	public void testBasicTypesConvert() {
		// 整型
		int a = 1;
		short b = 66;
		long c = 3;
		byte d = 69;
		// 浮点型
		float e = 9.5f;
		double f = 70.14;
		// char
		char g = 'A';
		
		// 类型之间都可以强制类型转换
		d = (byte) g;
		System.out.println(d);
 	}
	
	@Test
	public void testByteAndChar() throws UnsupportedEncodingException {
		// utf-8编码英文和数字是一个字符(char)，一个字节(byte)，中文是一个字符，三个字节
		String a = "ab中def";
		System.out.println(a.getBytes().length);
		byte[] aBytes = a.getBytes();
//		printByteArray(aBytes);
		String chinese = new String(aBytes, "utf-8");
//		System.out.println(chinese);
	}
	
	private void printByteArray(byte[] array) {
		for (byte item : array) {
			System.out.println(item);
		}
	}
	
	
}
