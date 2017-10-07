package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserTypeDao;
import com.example.model.UserType;

@Service
public class UserTypeService {

	@Autowired
	UserTypeDao userTypeDao;
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=true)
	public UserType getUserType(long id){
		return userTypeDao.getUserType(id);
	}
}
