package com.catalyst.tla_expense.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginAndRegisterWebServices {

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "/loginpage.html";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(){
		return "/register.html";
	}
}
