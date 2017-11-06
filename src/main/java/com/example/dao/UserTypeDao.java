package com.example.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.customexceptionhandling.CustomDaoException;
import com.example.model.UserType;

@Repository
public class UserTypeDao {
	
	Logger logger = LoggerFactory.getLogger(UserTypeDao.class);

	@Autowired
	SessionFactory sessionFactory;
	
	public UserType getUserType(long id) throws CustomDaoException{
		try{
			Session session = sessionFactory.getCurrentSession();
			logger.info("Retrieving user type for user id - " + id);
			return (UserType)session.get(UserType.class, id);
		}
		catch(HibernateException ex){
			logger.error("Error Occured retreiving user_type from Database: " + ex);
			throw new CustomDaoException("Error Occured in UserTypeDao retreiving user_type from Database: " + ex);
		}
		
	}

	public UserType getTypeofUsers(String typeOfUser)throws CustomDaoException {
		// TODO Auto-generated method stub
		try{
			Session session = sessionFactory.getCurrentSession();
			logger.info("Retrieving users for usertype - " + typeOfUser);
			String hql = "FROM UserType where typeOfUser=:typeOfUser";
			Query query = session.createQuery(hql);
			query.setParameter("typeOfUser", typeOfUser);
			return (UserType)query.list().get(0);
					
		}
		catch(HibernateException ex){
			logger.error("Error Occured retreiving users of type from Database: " + ex);
			throw new CustomDaoException("Error Occured in UserTypeDao retreiving users from user_type from Database: " + ex);
		}
		
		
	}
}
