package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.UserType;
import com.example.util.MasterTableDBValues;

@Repository
public class LoadMasterTablesDao {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Load all master tables
	 */
	public void loadAllMasterTables() {
		loadUserTypeTable();
	}

	/**
	 * 1. load UserType table
	 */
	@SuppressWarnings("unchecked")
	private void loadUserTypeTable() {
		Session session = sessionFactory.getCurrentSession();
		List<UserType> userTypeList = session.createCriteria(UserType.class).list();
		Map<String, UserType> userTypeMap = new HashMap<>();
		for (UserType userType : userTypeList) {
			userTypeMap.put(userType.getTypeOfUser(), userType);
		}
		MasterTableDBValues.masterTableMap.put(UserType.class.getSimpleName(), userTypeMap);
	}

}
