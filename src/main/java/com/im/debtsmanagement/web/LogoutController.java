package com.im.debtsmanagement.web;

import static com.im.debtsmanagement.apihelpers.DebtsManagementConstants.LOGGED_USER;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.im.debtsmanagement.api.User;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout")
	public String logoutPost(HttpServletRequest request) {

		request.getSession().removeAttribute(LOGGED_USER);
		return "redirect:/welcome.html";
	}
}
