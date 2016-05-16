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
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private final UserDataService userDataService;
	
	@Autowired
	public LoginController(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(Model model) {
		 model.addAttribute("user", new User());
		logger.info("Login GET");
		return "login";
	}
	
	@RequestMapping(params = "login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request, @Valid @ModelAttribute("user") User user, BindingResult result, SessionStatus status) {
		logger.info("Login POST");
		logger.info("UserName : ", user.getUsername());
		logger.info("Password : ", user.getPassword());
		
		User registeredUser = userDataService.login(user.getUsername(), user.getPassword());
		
		logger.info("The registered  user is ", registeredUser);
		
		if (registeredUser != null)
		{
			return "redirect:/welcome.html";
		}
		return "login";
	}
	
	@RequestMapping(params = "createAccount", method = RequestMethod.POST)
	public String createAccount(HttpServletRequest request) {
		System.out.println("register GET");
	    return "redirect:/register.html";
	}
}
