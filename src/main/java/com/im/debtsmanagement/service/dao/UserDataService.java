package com.im.debtsmanagement.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.im.debtsmanagement.api.User;
import com.im.debtsmanagement.service.dao.proxy.ProxyConnector;
import com.im.debtsmanagement.service.modelcreator.UserCreator;

@Service
public class UserDataService extends AbstractDataService<User> {

	public static final String TABLE_NAME = "user";

	@Autowired
	@Qualifier("MongodbConnectorConnector")
	private ProxyConnector proxyConnector;
	
	public UserDataService() {
		super( new UserCreator(), TABLE_NAME);
	}

	public User login(String username, String password) {
		User user = getUser(username);
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("true");
			return user;
		}
		System.out.println("false");
		return null;
	}

	public User getUser(String username) {
		return get(tableName, "username", username);
	}

	@Override
	protected User retrieveFrom(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getString("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setSurname(rs.getString("surname"));
		user.setAge(Short.parseShort(rs.getString("age")));
		user.setAdministrator(rs.getBoolean("administrator"));

		return user;
	}

	@Override
	public void create(User user) {
		List<String> columnNames = new ArrayList<String>();
		columnNames.add("username");
		columnNames.add("password");
		columnNames.add("name");
		columnNames.add("surname");
		columnNames.add("age");
		columnNames.add("administrator");

		List<String> columnValues = new ArrayList<String>();
		columnValues.add(user.getUsername());
		columnValues.add(user.getPassword());
		columnValues.add(user.getName());
		columnValues.add(user.getSurname());
		columnValues.add(String.valueOf(user.getAge()));
		columnValues.add(user.isAdministrator() ? "1" : "0");

		create(user, columnNames, columnValues);
	}

	@Override
	public void update(User oldObject, User newObject) {
		List<String> columnNames = new ArrayList<String>();
		columnNames.add("username");
		columnNames.add("password");
		columnNames.add("name");
		columnNames.add("surname");
		columnNames.add("age");
		columnNames.add("administrator");

		List<String> columnValues = new ArrayList<String>();
		columnValues.add(newObject.getUsername());
		columnValues.add(newObject.getPassword());
		columnValues.add(newObject.getName());
		columnValues.add(newObject.getSurname());
		columnValues.add(String.valueOf(newObject.getAge()));
		columnValues.add(newObject.isAdministrator() ? "1" : "0");

		update(oldObject, newObject, columnNames, columnValues);

	}

	@Override
	protected ProxyConnector getProxyConnector() {
		// TODO Auto-generated method stub
		return proxyConnector;
	}

}
