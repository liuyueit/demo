package com.demo.concurrent;

import java.util.concurrent.ForkJoinPool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForkJoinTest {
	@Test
	public void sumTest() {
	      int nThreads = Runtime.getRuntime().availableProcessors();
	      System.out.println(nThreads);
	      
	      int[] numbers = new int[1000]; 

	      for(int i = 0; i < numbers.length; i++) {
	         numbers[i] = i;
	      }

	      ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
	      Long result = forkJoinPool.invoke(new SumTask(numbers,0,numbers.length));
	      System.out.println(result);
	}
}
