package com.im.debtsmanagement.web;

import static com.im.debtsmanagement.apihelpers.DebtsManagementConstants.LOGGED_USER;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.im.debtsmanagement.api.User;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		User loggedUser = (User) request.getSession().getAttribute(LOGGED_USER);
		if (loggedUser == null) {
			return "redirect:/welcome.html";
		}
		return "home";
	}

}
