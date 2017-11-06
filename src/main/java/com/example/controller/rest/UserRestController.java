package com.example.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.customexceptionhandling.CustomBaseException;
import com.example.model.User;
import com.example.model.UserType;
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
	public String createUser(@RequestBody User user) throws CustomBaseException{	
			return userService.createUser(user);	
	}
	
	@RequestMapping(value="/User" , params = {"userId"}, method=RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody User getUser(@RequestParam (value = "userId") long userId ) throws CustomBaseException{
	  return userService.getUser(userId);
	}
	
	@RequestMapping(value="/User/All", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List<User> getAllUsers() throws CustomBaseException {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/User", params ={"userType"}, method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody UserType getUsersOfUserType(@RequestParam (value="userType") String userType) throws CustomBaseException{
		return userTypeService.geTypeOfUsers(userType);
	}
	
	@RequestMapping(value="/User",params ={"userId"}, method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody  String deleteUser(@RequestParam (value="userId") long userId) throws CustomBaseException
	{
		return userService.deleteUser(userId);
	}
	
	@RequestMapping(value="/User", params={"userId","userName"}, method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody String updateUser(@RequestParam (value="userId") long userId, @RequestParam(value="userName") String userName) throws CustomBaseException
	{
		return userService.updateUser(userId, userName);
	}
	
	@RequestMapping (value="/User", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody String updUser(@RequestBody User user) throws CustomBaseException
	{
		return userService.updUser(user);
	}
}
