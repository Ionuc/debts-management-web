package com.im.debtsmanagement.web;

import static com.im.debtsmanagement.apihelpers.DebtsManagementConstants.LOGGED_USER;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.im.debtsmanagement.api.Debt;
import com.im.debtsmanagement.api.User;
import com.im.debtsmanagement.service.dao.DebtDataService;

@Controller
public class DebtsController {

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private final DebtDataService debtDataService;

	@Autowired
	public DebtsController(DebtDataService debtDataService) {
		this.debtDataService = debtDataService;
	}

	@RequestMapping(value = "/debts", method = RequestMethod.GET)
	public String debtsGet(HttpServletRequest request) {
		User loggedUser = (User) request.getSession().getAttribute(LOGGED_USER);
		if (loggedUser == null) {
			return "redirect:/welcome.html";
		}
		return "debts";
	}

	@RequestMapping(value = "/allDebts", method = RequestMethod.GET)
	public @ResponseBody List<Debt> findAllDebts() {
		return debtDataService.getAll();
	}

	@RequestMapping(params = "goToDebts", method = RequestMethod.POST)
	public String goToDebts(HttpServletRequest request) {
		return "redirect:/debts.html";
	}

	@RequestMapping(value = "/removeDebt/{debtId}", method = RequestMethod.GET)
	public String removeDebt(@PathVariable("debtId") String debtId) {
		debtDataService.delete(debtId);
		return "redirect:/debts.html";
	}
}
