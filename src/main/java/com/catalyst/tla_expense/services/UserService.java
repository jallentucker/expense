package com.catalyst.tla_expense.services;

import java.util.List;

import com.catalyst.tla_expense.entities.User;

public interface UserService {

	List<User> getAllUsers();

	boolean createUser(User user);

	User getEmployeeByUsername(String username);

}
