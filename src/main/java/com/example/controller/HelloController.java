package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value="/test")
	public String hello(){
		System.out.println("In Test Method");
		return "resources/view/test.html";
	}
}
