package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	
	@RequestMapping(value="/Welcome")
	public ModelAndView WelcomeUser(HttpServletRequest request, HttpServletResponse response)
	{
		String name=request.getParameter("userName");
		String message="Hello " + name;
		return new ModelAndView("helloPage","message",message);
	}

	
	@RequestMapping(value="/login")
	public String loginUser()
	{
		return "login";
	}
}
