package com.im.debtsmanagement.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomeGet(Map<String, Object> model) {
		return "welcome";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String welcomePost(Map<String, Object> model) {
		return "redirect:/login.html";
	}
}