package com.catalyst.tla_expense.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.entities.User;
import com.catalyst.tla_expense.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
		
	}

	@Override
	public User getEmployeeByUsername(String username) {
		return userDao.getEmployeeByUsername(username);
	}

}
