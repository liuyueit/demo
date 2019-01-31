package com.demo.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {
	private static final Logger log = LoggerFactory.getLogger(StreamTest.class);

//	@Test
	public void testFilter() {
		// filter的用法
		List<String> strings = Arrays.asList("abc", "", " ", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream()
				.filter(item -> (!item.isEmpty() && !item.trim().isEmpty()))
				.collect(Collectors.toList());
		log.info("第一个filter结果:{}", filtered);

		long filtered2 = strings.parallelStream()
				.filter(item -> {
					if (item.length() >= 4) {
						return true;
					} else {
						return false;
					}
				})
				.count();
		log.info("filter2计数结果:{}", filtered2);

		
		
	}
	
	@Test
	public void testMap() {
		List<String> nameList = Arrays.asList("Wenhan YANG", "Super Liu", "Dian LEI");
		// 测试map
		List<String> newName2 = nameList .stream().map((name) -> name.replace('W', 'w'))
				.collect(Collectors.toList());
		newName2.forEach((name) -> System.out.println(name));

		List<Object[]> splitNames = Arrays.asList("Wenhan YANG", "Super Liu", "Dian LEI").stream()
				.map(name -> name.split(" ")).collect(Collectors.toList());
		splitNames.forEach((name) -> System.out.println(name[0]));
	}




}
