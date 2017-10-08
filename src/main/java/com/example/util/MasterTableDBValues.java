package com.example.util;

import java.util.HashMap;
import java.util.Map;

public interface MasterTableDBValues {

	/**
	 * Map will have <Classname, Map<UniqueColumnValue,EntityObject>>
	 */
	@SuppressWarnings("rawtypes")
	Map<String, Map> masterTableMap = new HashMap<>();
}
