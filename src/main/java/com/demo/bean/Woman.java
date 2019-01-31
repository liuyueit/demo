package com.demo.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Woman extends Human {
	private static final Logger log = LoggerFactory.getLogger(Woman.class);
	static {
		log.info("Woman static代码块");
	}
	public Woman() {
		super("human name");
		log.info("Woman构造函数");
	}
	public void sayWomanHi(String msg) {
		log.info(msg);
	}
	
	public int longhair;
}
