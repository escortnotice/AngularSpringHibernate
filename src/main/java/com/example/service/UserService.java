package com.example.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.customexceptionhandling.CustomDaoException;
import com.example.dao.UserDao;
import com.example.model.User;
import com.example.model.UserType;
import com.example.util.MasterTableDBValues;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	UserTypeService userTypeService;

	/**
	 * The Custom Dao exception thrown should be a subclass of Unchecked
	 * exception, else the exception will not be propagated and handled by
	 * Controller Advice Exception handler class(ExceptionHandlerAdvice.java).
	 * 
	 * This happens because only unchecked exceptions cause rollbacks in spring
	 * transactions.
	 * 
	 * Or you can use @Transactional (rollbackFor= CustomDaoException.class) if
	 * customdaoexception class is checked exception class.
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = CustomDaoException.class)
	public String createUser(User user) throws CustomDaoException {
		// add user creation time
		user.setCreationDate(new Timestamp(System.currentTimeMillis()));
		// get the UserType object from the Master Map which is loaded during
		// application startup during restart
		user.setUserType((UserType) MasterTableDBValues.masterTableMap.get("UserType").get(user.getUserTypeValue()));
		return userDao.createUser(user);
	}

	@Transactional(readOnly = true, rollbackFor = CustomDaoException.class)
	public User getUser(long userId) throws CustomDaoException {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

	@Transactional(readOnly = true, rollbackFor = CustomDaoException.class)
	public List<User> getAllUsers() throws CustomDaoException {

		return userDao.getAllUsers();
	}

	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = CustomDaoException.class)
	public String deleteUser(long userId) throws CustomDaoException {
		User user = getUser(userId);
		return userDao.deleteUser(user);
	}

	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = CustomDaoException.class)
	public String updateUser(long userId, String userName) throws CustomDaoException {
		// TODO Auto-generated method stub
		User user = getUser(userId);
		user.setUsername(userName);
		return userDao.updateUser(user);

	}

	@Transactional(isolation = Isolation.DEFAULT, rollbackFor = CustomDaoException.class)
	public String updUser(User updatedUser) throws CustomDaoException {
		// TODO Auto-generated method stub
		// User existingUser;
		User existingUser = getUser(updatedUser.getUserId());
		if (existingUser != null) {
			existingUser.setUser(updatedUser);
			return userDao.updUser(existingUser);
		} 
		else {
			return "User Does not Exist";
		}
	}

}
