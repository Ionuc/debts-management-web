package com.im.debtsmanagement.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.im.debtsmanagement.model.User;
import com.im.debtsmanagement.service.dao.UserDataService;

@Controller
@SessionAttributes("user")
public class RegisterController {

	private final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	private final UserDataService userDataService;
	
	@Autowired
	public RegisterController(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet(Model model) {
		 model.addAttribute("user", new User());
		logger.info("Register GET");
		return "register";
	}
	
	@RequestMapping(params = "register", method = RequestMethod.POST)
	public String registerPost(HttpServletRequest request, @Valid @ModelAttribute("user") User user, BindingResult result, SessionStatus status) {
		logger.info("Login POST");
		logger.info("UserName : ", user.getUsername());
		logger.info("Password : ", user.getPassword());
		
		userDataService.create(user, null);
		
		logger.info("User was created");
		
		return "redirect:/login.html";
	}
	
	@RequestMapping(params = "goToLogin", method = RequestMethod.POST)
	public String goToLogin(HttpServletRequest request) {
		System.out.println("goToLogin POST");
	    return "redirect:/login.html";
	}
	
}
