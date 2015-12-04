package com.catalyst.tla_expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.tla_expense.entities.User;
import com.catalyst.tla_expense.services.UserService;

/**
 * User Controller class. Has all the end points for Post, Put, Delete, Get.
 * 
 * @author cmiller
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user/get", method = RequestMethod.GET)
	public  List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	
}
