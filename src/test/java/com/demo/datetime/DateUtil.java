package com.demo.datetime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateUtil {
//	@Test
	public void constructDate() {
		Date now = new Date();
		System.out.println(now.toString());
	}
	
	@Test
	public void localDateTest() {
		LocalDate now = LocalDate.now();
		System.out.println(now.toString());
		LocalDate day = LocalDate.of(2019, 1, 1);
		System.out.println(day.toString());
		LocalDate plusday = day.plusDays(3);
	}
	
}
