package com.im.debtsmanagement.service.modelcreator;

import java.util.Arrays;
import java.util.List;

import com.im.debtsmanagement.model.User;


public class UserCreator extends ManagementObjectCreator<User> {

	@Override
	public List<String> getAllFields() {
		return Arrays.asList("id","username", "password", "name", "surname", "fullname", "age", "administrator");
	}

	@Override
	public User getNewObject() {
		return new User();
	}

}
