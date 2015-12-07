package com.catalyst.tla_expense.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.entities.User;
import com.catalyst.tla_expense.services.UserService;

/**
 * The Service Implementation for a user. All service validation gets called from here.
 * @author cmiller
 */
@Service
public class UserServiceImpl implements UserService {

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
	 */
	@Override
	public void createUser(User user) {
		userDao.createUser(user);
		
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
