package com.example.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.customexceptionhandling.CustomDaoException;
import com.example.model.ResidentialAddress;
import com.example.model.User;

@Repository
public class UserResidentialAddressDao {

	@Autowired
	SessionFactory sessionFactory;

//	public String saveResedentialAddress(ResidentialAddress residentialAddress) throws CustomDaoException {
//		Session session = sessionFactory.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		try {
//			System.out.println("Dao Call");
//			session.save(residentialAddress);
//			System.out.println("Residential Address saved");
//			return "success";
//		} catch (HibernateException ex) {
//			System.out.println("Error occured while saving resedential address: " + ex);
//			throw new CustomDaoException("Error occured while saving resedential address");
//		} catch (Exception ex) {
//			System.out.println("Error occured while saving resedential address: " + ex);
//			throw new CustomDaoException("Error occured while saving resedential address");
//		} finally {
//			tx.commit();
//
//		}
//
//	}
//
	public ResidentialAddress getStudentAddress(long id) throws CustomDaoException {

		System.out.println("In get StudentAdress dao");
		Session session = sessionFactory.getCurrentSession();
		try {
			ResidentialAddress address = (ResidentialAddress) session.get(ResidentialAddress.class, id);
			return address;
		} catch (HibernateException ex) {
			System.out.println("Error occured while fetching resedential address: " + ex);
			throw new CustomDaoException("Error occured fetching saving resedential address");
		} catch (Exception ex) {
			System.out.println("Error occured while fetching resedential address: " + ex);
			throw new CustomDaoException("Error occured while fetching resedential address");
		}
	}

	public void saveUser(User st) throws CustomDaoException {
		System.out.println("save user in dao");
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(st);
		} catch (HibernateException ex) {
			System.out.println("Error occured while saving user details: " + ex);
			throw new CustomDaoException("Error occured saving user details");
		} catch (Exception ex) {
			System.out.println("Error occured while saving user details: " + ex);
			throw new CustomDaoException("Error occured saving user details");
		} 
	}

}
