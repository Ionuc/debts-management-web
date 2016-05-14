package com.im.debtsmanagement.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.im.debtsmanagement.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(Model model) {
		 model.addAttribute("user", new User()); 
		System.out.println("Login GET");
		return "login";
	}
	
	@RequestMapping(params = "login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request, @Valid @ModelAttribute("user") User user, BindingResult result, SessionStatus status) {
		System.out.println("Login POST");
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		return "login";
	}
	
	@RequestMapping(params = "register", method = RequestMethod.POST)
	public String createAccount(HttpServletRequest request) {
		System.out.println("register GET");
	    return "redirect:/login.html";
	}
}
