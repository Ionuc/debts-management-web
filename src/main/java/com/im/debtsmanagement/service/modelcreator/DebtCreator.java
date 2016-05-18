package com.im.debtsmanagement.service.modelcreator;

import java.util.Arrays;
import java.util.List;

import com.im.debtsmanagement.api.Debt;

public class DebtCreator extends ManagementObjectCreator<Debt> {
	@Override
	public List<String> getAllFields() {
		return Arrays.asList("id", "toUsername", "fromUsername", "value", "description", "date");
	}

	@Override
	public Debt getNewObject() {
		return new Debt();
	}

}
