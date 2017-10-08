package com.example.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.service.LoadMasterTablesService;

/**
 * Load all master tables from database on application start up, and put it in a
 * map<unique_column,object>.
 *
 */
@Component
class LoadAllMasterTablesListener implements ApplicationListener<ContextRefreshedEvent> {

	Logger logger = LoggerFactory.getLogger(LoadAllMasterTablesListener.class);
	
	@Autowired
	private LoadMasterTablesService loadMasterTablesService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		logger.info("Context Event Received");
		loadMasterTablesService.loadAllMasteTables();
		logger.info("All master tables loading completed successfully");
	}

}
