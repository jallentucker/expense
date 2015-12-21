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

	/**
	 * Used by the userFactory.js in order to retrieve the current user that's logged
	 * into the app.
	 * @param principal
	 * @return
	 */
	@RequestMapping(value="/user/getCurrent", method=RequestMethod.GET)
	public User currentUser(Principal principal){
		return userService.getEmployeeByUsername(principal.getName());
	}
	
	/**
	 * Sets the UserService
	 * @param userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
