package com.example.controller.rest;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.customexceptionhandling.CustomBaseException;
import com.example.model.User;
import com.example.service.UserService;
import com.example.service.UserTypeService;

@RestController
public class UserRestController {
	
	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	UserService userService;
	@Autowired
	UserTypeService userTypeService;
	
	@RequestMapping(value= "/User",method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String createUser(User user) throws CustomBaseException{
			user = new User();
			user.setUsername("Rockethuki");
			user.setPassword("Salesman123");
			user.setCreationDate(new Timestamp(System.currentTimeMillis()));
			user.setUserType(userTypeService.getUserType(1l));
			return userService.createUser(user);	
	}
}
