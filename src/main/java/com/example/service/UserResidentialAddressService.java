package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.customexceptionhandling.CustomDaoException;
import com.example.dao.UserResidentialAddressDao;
import com.example.model.ResidentialAddress;
import com.example.model.User;

@Service
public class UserResidentialAddressService {

	@Autowired
	UserResidentialAddressDao saveStudentResidentialAddressDao;

//	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
//	public String saveResedentialAddress(ResidentialAddress residentialAddress) throws CustomDaoException {
//		System.out.println("service call");
//		saveStudentResidentialAddressDao.saveResedentialAddress(residentialAddress);
//		return "success";
//	}
//	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,readOnly = true)
	public ResidentialAddress getResedentialAddress(long id) throws CustomDaoException {
		System.out.println("service call");
		return saveStudentResidentialAddressDao.getStudentAddress(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void saveStudent(User st) throws CustomDaoException {
		System.out.println("service call");
		saveStudentResidentialAddressDao.saveUser(st);
		
	}
}
