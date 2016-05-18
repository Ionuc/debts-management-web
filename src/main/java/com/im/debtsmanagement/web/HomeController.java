package com.im.debtsmanagement.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.im.debtsmanagement.api.User;
import com.im.debtsmanagement.service.HelloWorldService;

import static com.im.debtsmanagement.apihelpers.DebtsManagementConstants.LOGGED_USER;

@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	private final HelloWorldService helloWorldService;

	@Autowired
	public HomeController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		User loggedUser = (User)request.getSession().getAttribute(LOGGED_USER);
		if (loggedUser == null){
			return "redirect:/welcome.html"; 
		}
		return "home";
	}

}
