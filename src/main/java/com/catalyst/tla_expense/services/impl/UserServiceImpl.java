package com.catalyst.tla_expense.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.entities.User;
import com.catalyst.tla_expense.services.UserService;
import com.catalyst.tla_expense.validation.UserServiceValidation;

/**
 * The Service Implementation for a user. All service validation gets called from here.
 * @author cmiller
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserServiceValidation userServiceValidation;
	
	@Autowired
	UserDao userDao;
	
	/**
	 * Returns a list of users from the database
	 * @author cmiller
	 */
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	/**
	 * Sends a User to the dao layer.
	 * @author cmiller
	 * @return 
	 */
	@Override
	public boolean createUser(User user) {
		boolean valid = userServiceValidation.validateUser(user);
		boolean result = false;
		if(valid){
			String encryptedPass = encoder.encode(user.getUserPassword());
			user.setUserPassword(encryptedPass);
			userDao.createUser(user);
			result = true;
		}
		return result;
	}

	@Override
	public User getEmployeeByUsername(String username) {
		return userDao.getEmployeeByUsername(username);
	}

	public void setUserServiceValidation(UserServiceValidation userServiceValidation) {
		this.userServiceValidation = userServiceValidation;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setEncoder(BCryptPasswordEncoder encoder){
		this.encoder = encoder;
	}
}
