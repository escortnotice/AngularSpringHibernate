package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	//creates a new user
	public String createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return "OK";
	}

	
}