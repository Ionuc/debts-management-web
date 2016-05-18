package com.im.debtsmanagement.service.modelcreator;

import java.util.Arrays;
import java.util.List;

import com.im.debtsmanagement.api.User;


public class UserCreator extends ManagementObjectCreator<User> {

	@Override
	public List<String> getAllFields() {
		return Arrays.asList("id","username", "password", "name", "surname", "age", "administrator");
	}

	@Override
	public User getNewObject() {
		return new User();
	}

}
