package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.customexceptionhandling.CustomDaoException;
import com.example.dao.UserTypeDao;
import com.example.model.UserType;

@Service
public class UserTypeService {

	@Autowired
	UserTypeDao userTypeDao;
	
	@Transactional(readOnly=true)
	public UserType getUserType(long id) throws CustomDaoException{
		return userTypeDao.getUserType(id);
	}
}
