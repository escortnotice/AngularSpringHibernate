package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.LoadMasterTablesDao;

@Service
public class LoadMasterTablesService {

	@Autowired
	LoadMasterTablesDao loadMasterTablesDao;
	
	@Transactional(readOnly=true)
	public void loadAllMasteTables(){
		loadMasterTablesDao.loadAllMasterTables();
	}
}
