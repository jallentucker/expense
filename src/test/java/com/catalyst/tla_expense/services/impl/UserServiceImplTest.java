package com.catalyst.tla_expense.services.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.entities.User;
import com.catalyst.tla_expense.services.impl.UserServiceImpl;
import com.catalyst.tla_expense.validation.UserServiceValidation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImplTest {
	
	private UserServiceImpl target;
	private UserDao mockUserDao;
	private UserServiceValidation mockUserServiceValidation;
	private BCryptPasswordEncoder mockEncoder;
	
	@Before
	public void setup(){
		target = new UserServiceImpl();
		mockUserDao = mock(UserDao.class);
		mockUserServiceValidation = mock(UserServiceValidation.class);
		mockEncoder = mock(BCryptPasswordEncoder.class);
		target.setUserDao(mockUserDao);
		target.setUserServiceValidation(mockUserServiceValidation);
		target.setEncoder(mockEncoder);
		
	}
	
	@Test
	public void testAddUserWithValidUser(){
		User user = new User();
		user.setUserEmail("valid@email.com");
		//user.setUserPassword(encoder.encode("Password123@"));
		when(mockEncoder.encode(user.getUserPassword())).thenReturn("password");
		when(mockUserServiceValidation.validateUser(user)).thenReturn(true);
		
		assertTrue(target.createUser(user));
	}
	
	@Test
	public void testAddUserWithInvalidUser(){
		User user = new User();
		when(mockEncoder.encode(user.getUserPassword())).thenReturn("password");
		when(mockUserServiceValidation.validateUser(user)).thenReturn(false);
		assertFalse(target.createUser(user));
	}
	
	@Test
	public void testGetAllUsers(){
		target.getAllUsers();
		verify(mockUserDao, times(1)).getAllUsers();
	}
}
