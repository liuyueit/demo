package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	private static final Logger log = LoggerFactory.getLogger(MyController.class);
	
	@GetMapping("/login")
//	@RequestMapping("login")
	@CrossOrigin()
	public Object login(@RequestParam("tel") String tel, @RequestParam("pwd") String pwd, HttpServletResponse response) {
		log.info("手机号:{}, 密码{}", tel, pwd);
		return "ok";
	}
	
	@RequestMapping(value = "/books/1", method = RequestMethod.GET)
	@CrossOrigin()
	public Object fetchDb() {
//		HashMap<String, String> config = new HashMap<String, String>();
//		config.put("url", "/books/1");
//		config.put("method", "get");
//		Map<String, HashMap<String, String>> rs = new HashMap<String, HashMap<String, String>>();
//		rs.put("config", config);
		return "ok";
	}
	
	@RequestMapping(value = "/books/1", method = RequestMethod.PUT)
	@CrossOrigin()
	public Object saveDb(@RequestBody Object req) {
		log.info("@RequestBody:{}", req);
		return "ok";
	}
}
