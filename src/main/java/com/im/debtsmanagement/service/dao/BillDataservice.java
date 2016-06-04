package com.im.debtsmanagement.service.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.debtsmanagement.api.Bill;
import com.im.debtsmanagement.api.Debt;
import com.im.debtsmanagement.api.User;

@Service
public class BillDataservice {

	private final DebtDataService debtDataService;

	@Autowired
	public BillDataservice(DebtDataService debtDataService) {
		this.debtDataService = debtDataService;
	}

	public void createBill(Bill bill, User loggedUser) {

		List<String> newUsers = filterUsers(bill);
		BigDecimal valuePerUser = bill.getValue().divide(
				new BigDecimal(bill.getParticipants().size()), 2, RoundingMode.DOWN);
		for (String user : newUsers) {
			Debt debt = new Debt();
			debt.setDescription(bill.getCompanyDescription());
			debt.setFromUsername(user);
			debt.setToUsername(bill.getOwner());
			debt.setValue(valuePerUser);
			debt.setDate(bill.getDate());
			debtDataService.create(debt);
		}
	}

	private List<String> filterUsers(Bill bill) {
		List<String> newUsers = new ArrayList<String>();
		for (String user : bill.getParticipants()) {
			if (!user.equals(bill.getOwner())) {
				newUsers.add(user);
			}
		}
		return newUsers;
	}
}
