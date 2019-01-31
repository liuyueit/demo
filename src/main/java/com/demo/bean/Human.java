package com.demo.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
@Data
public class Human {
	private static final Logger log = LoggerFactory.getLogger(Human.class);
	private String name;
	static {
		log.info("Human static代码块");
	}
	private Integer height; 
	public Human(String name) {
		this.name = name;
		log.info("human构造函数");
	}
}
