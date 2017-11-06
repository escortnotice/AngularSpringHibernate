package com.example.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.customexceptionhandling.CustomDaoException;
import com.example.model.Product;

@Repository
public class ProductDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public static final String OK ="OK";
	
	
	//creates new product
	
	public String createProduct (Product product) throws CustomDaoException
	{
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.save(product);
			return OK;
			
		}catch(HibernateException e)
		{
			throw new CustomDaoException ("Exception occured"+ e);
		}
	}
	
}
