package com.im.debtsmanagement.web;

import static com.im.debtsmanagement.apihelpers.DebtsManagementConstants.LOGGED_USER;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.im.debtsmanagement.api.Debt;
import com.im.debtsmanagement.api.User;
import com.im.debtsmanagement.service.dao.DebtDataService;
import com.im.debtsmanagement.service.dao.UserDataService;

@Controller
@SessionAttributes("debt")
public class DebtController {

	private DebtDataService debtDataService;
	private UserDataService userDataService;

	@Autowired
	public DebtController(DebtDataService debtDataService, UserDataService userDataService) {
		this.debtDataService = debtDataService;
		this.userDataService = userDataService;
	}

	@RequestMapping(value = "/debt", method = RequestMethod.GET)
	public String debtGet(HttpServletRequest request, Model model) {
		User loggedUser = (User) request.getSession().getAttribute(LOGGED_USER);
		if (loggedUser == null) {
			return "redirect:/welcome.html";
		}
		model.addAttribute("debt", new Debt());
		return "debt";
	}

	@RequestMapping(params = "goToCreateDebt", method = RequestMethod.POST)
	public String goToCreateDebt(HttpServletRequest request) {
		return "redirect:/debt.html";
	}

	@RequestMapping(params = "createDebt", method = RequestMethod.POST)
	public String createDebt(HttpServletRequest request, @Valid @ModelAttribute("debt") Debt debt, BindingResult result,
			SessionStatus status) {
		if(result.hasErrors())
		{
			return "debt";
		}
		debtDataService.create(debt);
		return "redirect:/debts.html";
	}

	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public @ResponseBody List<User> findAllUsers() {
		return userDataService.getAll();
	}
}
