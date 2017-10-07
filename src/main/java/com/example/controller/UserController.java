package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.customexceptionhandling.CustomDaoException;
import com.example.model.ResidentialAddress;
import com.example.model.User;
import com.example.service.UserResidentialAddressService;

@Controller
public class UserController {

	@Autowired
	UserResidentialAddressService saveStudentResidentialAddressService;
	
	@RequestMapping(value = "/studentSave")
	public void saveStudent(){
		User st = new User();
		st.setGender("Female");
		st.setName("Kelly");
		long residentialAddressId = 2l;
		try {
			ResidentialAddress address = saveStudentResidentialAddressService.getResedentialAddress(residentialAddressId);
			st.setResidentialAddress(address);
			saveStudentResidentialAddressService.saveStudent(st);
		} 
		catch (CustomDaoException e) {
			System.out.println(e);
		}
	}
}
