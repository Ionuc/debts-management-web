package com.im.debtsmanagement.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.im.debtsmanagement.api.ManagementObject;
import com.im.debtsmanagement.service.dao.proxy.ProxyConnector;
import com.im.debtsmanagement.service.modelcreator.ManagementObjectCreator;


public abstract class AbstractDataService<OBJECT extends ManagementObject> {
	protected final String tableName;
	protected final ManagementObjectCreator<OBJECT> managementObjectCreator;

	public AbstractDataService(ManagementObjectCreator<OBJECT> managementObjectCreator, String tableName) {
		this.tableName = tableName;
		this.managementObjectCreator = managementObjectCreator;
	}

	protected abstract ProxyConnector getProxyConnector();
	
	protected void create(OBJECT object, List<String> columnNames, List<String> columnValues) {

		getProxyConnector().create(managementObjectCreator, columnNames, columnValues, tableName);
	}

	protected void update(OBJECT oldObject, OBJECT newObject, List<String> columnNames, List<String> columnValues) {
		getProxyConnector().update(managementObjectCreator, newObject.getId(), columnNames, columnValues,
				tableName);
	}

	protected void delete(String tableName, String id) {
		getProxyConnector().delete(tableName, id);
	}

	protected OBJECT get(String tableName, String columnName, String columnValue) {
		List<OBJECT> lists = getProxyConnector().get(managementObjectCreator, tableName, columnName, columnValue);
		return lists.stream().findFirst().orElse(null);
	}

	public OBJECT get(String id) {
		return get(tableName, "_id", String.valueOf(id));
	}

	public List<OBJECT> getAll() {
		return getProxyConnector().getAll(managementObjectCreator, tableName);
	}

	public OBJECT delete(String id) {
		OBJECT object = get(id);
		if (object != null) {
			delete(tableName, id);
		}
		return object;
	}

	public abstract void create(OBJECT object);

	public abstract void update(OBJECT oldObject, OBJECT newObject);

	protected abstract OBJECT retrieveFrom(ResultSet rs) throws SQLException;
}
