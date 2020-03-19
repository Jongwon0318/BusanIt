package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("test.go")
	public String test() { // String -> View(jsp)
		return "result";
	}	
	@RequestMapping("test222.go")
	public String test222() {
		return "result222";
	}
}
