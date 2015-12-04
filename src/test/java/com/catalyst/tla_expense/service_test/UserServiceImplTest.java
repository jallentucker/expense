package com.catalyst.tla_expense.service_test;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.entities.User;
import com.catalyst.tla_expense.services.impl.UserServiceImpl;

public class UserServiceImplTest {

	private UserServiceImpl target;
	private UserDao mockUserDao;
	
	@Before
	public void setup(){
		target = new UserServiceImpl();
		mockUserDao = mock(UserDao.class);
		target.setUserDao(mockUserDao);
	}
	
	@Test
	public void testAddUserWithValidUser(){
		User user = new User();
		user.setUserEmail("valid@email.com");
		user.setUserPassword("Password");
		
		target.createUser(user);
		verify(mockUserDao, times(1)).createUser(user);
	}
	
	@Test
	public void testGetAllUsers(){
		target.getAllUsers();
		verify(mockUserDao, times(1)).getAllUsers();
	}
}
