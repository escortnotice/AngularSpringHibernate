package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.customexceptionhandling.CustomDaoException;
import com.example.dao.UserDao;
import com.example.model.User;

@Service
public class UserService {

	@Autowired 
	UserDao userDao;
	
	/**
	 * The Custom Dao exception thrown should be a subclass of Unchecked exception, else the exception
	 * will not be propagated and handled by Controller Advice Exception handler class(ExceptionHandlerAdvice.java).
	 * 
	 * This happens because only unchecked exceptions cause rollbacks in spring transactions.
	 * 
	 * Or you can use @Transactional (rollbackFor= CustomDaoException.class) if customdaoexception class is checked exception class.
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=CustomDaoException.class)
	public String createUser(User user) throws CustomDaoException{
		return userDao.createUser(user);
	}
}
