package com.im.debtsmanagement.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.im.debtsmanagement.api.ManagementObject;
import com.im.debtsmanagement.api.User;
import com.im.debtsmanagement.service.dao.proxy.ProxyConnector;
import com.im.debtsmanagement.service.modelcreator.ManagementObjectCreator;


public abstract class AbstractDataService<OBJECT extends ManagementObject> {
	protected final String tableName;
	protected final String classCaller;
//	private final FileDataService fileDataService;
	protected final ManagementObjectCreator<OBJECT> managementObjectCreator;

	public AbstractDataService(ManagementObjectCreator<OBJECT> managementObjectCreator,
			String classCaller, String tableName) {
		this.tableName = tableName;
		this.managementObjectCreator = managementObjectCreator;
		this.classCaller = classCaller;
//		fileDataService = FileDataServiceFactory.getFileDataService();
	}

	protected abstract ProxyConnector getProxyConnector();
	
	protected void create(OBJECT object, List<String> columnNames, List<String> columnValues, User loggedUser) {

		getProxyConnector().create(managementObjectCreator, columnNames, columnValues, tableName);
//		fileDataService.writeCreateInfo(object, tableName, loggedUser, classCaller);
	}

	protected void update(OBJECT oldObject, OBJECT newObject, List<String> columnNames, List<String> columnValues,
			User loggedUser) {
		getProxyConnector().update(managementObjectCreator, newObject.getId(), columnNames, columnValues,
				tableName);
//		fileDataService.writeUpdateInfo(oldObject, newObject, tableName, loggedUser, classCaller);
	}

	protected void delete(String tableName, String id, User loggedUser) {
		getProxyConnector().delete(tableName, id);
//		fileDataService.writeDeleteInfo(String.valueOf(id), tableName, loggedUser, tableName);
	}

	protected OBJECT get(String tableName, String columnName, String columnValue) {
		List<OBJECT> lists = getProxyConnector().get(managementObjectCreator, tableName, columnName, columnValue);
		return lists.stream().findFirst().orElse(null);
	}

	public OBJECT get(String id) {
		return get(tableName, "id", String.valueOf(id));
	}

	public List<OBJECT> getAll() {
		return getProxyConnector().getAll(managementObjectCreator, tableName);
	}

	public OBJECT delete(String id, User loggedUser) {
		OBJECT object = get(id);
		if (object != null) {
			delete(tableName, id, loggedUser);
		}
		return object;
	}

	public abstract void create(OBJECT object, User loggedUser);

	public abstract void update(OBJECT oldObject, OBJECT newObject, User loggedUser);

	protected abstract OBJECT retrieveFrom(ResultSet rs) throws SQLException;
}
