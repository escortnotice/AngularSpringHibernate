package com.example.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class UserTypeRestController {
	
	@Autowired 
	UserTypeService userTypeService;
	
	@RequestMapping(value="/User", params = {"UserType"}, method=RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
	public @ResponseBody UserType getUserType(@RequestParam (value = "typeOfUser") String typeOfUser ) throws CustomBaseException{
		  return userTypeService.geTypeOfUsers(typeOfUser);
		}

}
