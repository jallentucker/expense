package com.catalyst.tla_expense.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    /**
     * Controller to navigate to the home page
     * @return String with location of html page to get
     */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "/index.html";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "/loginIndex.html";
	}
}