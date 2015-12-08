package com.catalyst.tla_expense.daos;

import java.util.List;

import com.catalyst.tla_expense.entities.User;

public interface UserDao {

	List<User> getAllUsers();

	void createUser(User user);

	User getEmployeeByUsername(String username);

}
