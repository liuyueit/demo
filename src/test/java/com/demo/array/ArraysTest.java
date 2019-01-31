package com.demo.array;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.bean.Human;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArraysTest {

	@Test
	public void testArrays() {
		Human[] humanArray = new Human[]{new Human("yang"), new Human("zhang")};
		Human[] humanCopy = Arrays.copyOf(humanArray, humanArray.length); // 浅拷贝
		humanArray[0].setName("wenhan");
		System.out.println(humanCopy[0]);
	}
}


