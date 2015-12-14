package com.catalyst.tla_expense.webservices;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.tla_expense.entities.User;
import com.catalyst.tla_expense.services.UserService;

@RestController
public class UserWebService {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/user/getCurrent", method=RequestMethod.GET)
	public User currentUser(Principal principal){
		return userService.getEmployeeByUsername(principal.getName());
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
