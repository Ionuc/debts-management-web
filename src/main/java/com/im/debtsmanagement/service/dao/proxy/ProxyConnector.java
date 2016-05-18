package com.im.debtsmanagement.service.dao.proxy;

import java.util.List;

import com.im.debtsmanagement.api.ManagementObject;
import com.im.debtsmanagement.service.modelcreator.ManagementObjectCreator;


public interface ProxyConnector {

	<OBJECT extends ManagementObject> OBJECT create(ManagementObjectCreator<OBJECT> managementObjectCreator,
			List<String> columnNames, List<String> columnValues, String tableName);

	<OBJECT extends ManagementObject> OBJECT update(ManagementObjectCreator<OBJECT> managementObjectCreator,
			String id, List<String> columnNames, List<String> columnValues, String tableName);

	void delete(String tableName, String id);

	<OBJECT extends ManagementObject> OBJECT get(ManagementObjectCreator<OBJECT> managementObjectCreator,
			String tableName, String columnName, String columnValue);

	<OBJECT extends ManagementObject> List<OBJECT> getAll(ManagementObjectCreator<OBJECT> managementObjectCreator,
			String tableName, String columnName, String columnValue);

	String getType();
}
