package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.UserType;

@Repository
public class UserTypeDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public UserType getUserType(long id){
		
		Session session = sessionFactory.getCurrentSession();
		return (UserType)session.get(UserType.class, id);
	}
}
