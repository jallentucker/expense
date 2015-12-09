package com.catalyst.tla_expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/**
	 * GET
	 * Url "/user/get
	 * Returns a list of all users.
	 * @author cmiller
	 */
	@RequestMapping(value="/user/get", method = RequestMethod.GET)
	public  List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	/**
	 * POST
	 * Url "/user/post
	 * Sends a User through the layers and eventually persists in the dao.
	 * @author cmiller
	 */
	@RequestMapping(value="/user/post", method = RequestMethod.POST)
	public void createUser(@RequestBody User user){
		System.out.println("Post method called");
		userService.createUser(user);
	}
}
