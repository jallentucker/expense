package com.catalyst.tla_expense.daos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.daos.impl.UserDaoImpl;
import com.catalyst.tla_expense.entities.User;

public class UserDaoImplTest {

	UserDao dao;
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	EntityManager mockEm = mock(EntityManager.class);
	private UserDaoImpl target;
	
	@Before
	public void setup() {
		target = new UserDaoImpl();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetAllUsers() {
		List<User> expected = new ArrayList<>();

		TypedQuery<User> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(User.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getAllUsers();

		verify(mockTypedQuery, times(1)).getResultList();

	}
	
	@Test
	public void testCreateUserWithValidUser(){
		User user = new User();
		user.setUserEmail("valid@email.com");
		user.setUserPassword("Password");
		
		target.createUser(user);
		verify(mockEm, times(1)).merge(user);
	}
}
