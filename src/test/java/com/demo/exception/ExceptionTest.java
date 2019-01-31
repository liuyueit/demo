package com.demo.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExceptionTest {
	@Test
	public void testException() throws Exception {
		// 直接抛Exception，进程中断
		throwException();
		
	}
	
	private void throwException() throws Exception {
		throw new Exception("直接抛Exception");
	}
	
}
