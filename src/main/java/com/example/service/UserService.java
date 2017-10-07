package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.model.User;

@Service
public class UserService {

	@Autowired 
	UserDao userDao;
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public String createUser(User user){
		return userDao.createUser(user);
	}
}
