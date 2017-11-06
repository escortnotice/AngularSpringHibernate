package com.example.dao;

import java.util.ArrayList;
import java.util.List;

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

	public User getUser(long userId) throws CustomDaoException{
		Session session=null;
		try{
			session=sessionFactory.getCurrentSession();
			return ((User)session.get(User.class, userId));
		} catch(HibernateException e)
		{
			logger.error("Exception occured in getting user data: "+ e);
			throw new CustomDaoException("Exception occured in getting user data: "+ e);
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() throws CustomDaoException{
		try{
			Session session=sessionFactory.getCurrentSession();
			return session.createQuery("FROM User").list();
		} catch(HibernateException e)
		{
			logger.error("Exception occured in geting all user records");
			throw new CustomDaoException("Exception occured in geting all user records"+e);
		}
	}
	

	public String deleteUser(User user) throws CustomDaoException {
		// TODO Auto-generated method stub
		try{
			Session session=sessionFactory.getCurrentSession();
			session.delete(user);
			return "Deleted";
		}catch(HibernateException e)
		{
			logger.error("exception occured while deleting user");
			throw new CustomDaoException("Exception occured while deleting user"+e);
		}
	}

	/*public List<User> getUsersOfUserType() throws CustomDaoException{
		try{
			Session sesion= sessionFactory.getCurrentSession();
			return ((User)session.get(UserType.class, userType));
			
		}catch(HibernateException e)
		{
			logger.error("Exception occured in getting usertype users");
			throw new CustomDaoException("Exception occured in getting usertype users"+e);
		}
	}*/
	
	public String updateUser(User user) throws CustomDaoException {
		// TODO Auto-generated method stub
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(user);
			return "updated";
		}catch(HibernateException e)
		{
			logger.error("exception occured while updating user");
			throw new CustomDaoException("Exception occured while updating user"+e);
		}
	}
	
	public String updUser(User updatedUser) throws CustomDaoException {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(updatedUser);
			return "User successfully Updated";
			
		}catch(HibernateException e)
		{
			logger.error("Error in updating user");
			throw new CustomDaoException("Exception in updating user"+e);
		}
	}

}