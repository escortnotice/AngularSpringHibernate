package com.example.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.customexceptionhandling.CustomDaoException;
import com.example.model.User;


@Repository
public class UserDao {

	Logger logger = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	SessionFactory sessionFactory;

	public static final String OK = "OK";
	
	/**
	 * The Custom Dao exception thrown should be a subclass of Unchecked exception, else the exception
	 * will not be propagated and handled by Controller Advice Exception handler class(ExceptionHandlerAdvice.java).
	 * 
	 * This happens because only unchecked exceptions cause rollbacks in spring transactions.
	 * 
	 * Or you can use @Transactional (rollbackFor= CustomDaoException.class) if customdaoexception class is checked exception class.
	 */
	// creates a new user
	public String createUser(User user) throws CustomDaoException {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(user);
			logger.info("User saved successfully");
			return OK;
		} catch (HibernateException ex) {
			logger.error("Error Occured while saving user to Database: " + ex);
			throw new CustomDaoException("Error Occured while saving user to Database: " + ex);
		}
	}

}