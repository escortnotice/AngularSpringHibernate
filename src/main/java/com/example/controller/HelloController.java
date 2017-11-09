package com.example.controller;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.customexceptionhandling.CustomBaseException;

@Controller
public class HelloController {

	@RequestMapping(value="/test")
	public String hello() throws CustomBaseException{
		try{
			System.out.println("In Test Method");
			if(true){
				throw new SQLException();
			}
			return "resources/view/test.html";
		}
		catch(Exception e){
			throw new CustomBaseException("SQL Exception Occured from Hello Controller",e);
		}
		
	}
	
	
	
}
