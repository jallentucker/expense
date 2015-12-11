package com.catalyst.tla_expense.validation;

import org.junit.Before;
import org.junit.Test;


import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.entities.User;
import com.catalyst.tla_expense.validation.UserServiceValidation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class UserServiceValidationTest {
	
	private UserServiceValidation target;
	private UserDao mockUserDao;
	
	@Before
	public void setup(){
		target = new UserServiceValidation();
		mockUserDao = mock(UserDao.class);
		target.setUserDao(mockUserDao);
		
		List<User> existingUsers = new ArrayList<>();
		User existingUser = new User();
		existingUser.setUserEmail("existing@user.com");
		existingUsers.add(existingUser);
		when(mockUserDao.getAllUsers()).thenReturn(existingUsers);
	}
	
	@Test
	public void testPasswordWithValidPassword(){
		User user = new User();
		user.setUserPassword("Password1.");
		
		assertTrue(target.validatePassword(user));
	}
	
	@Test
	public void testPasswordWithPasswordThatIsTooShort(){
		User user = new User();
		user.setUserPassword("Pass1.a");
		
		assertFalse(target.validatePassword(user));
	}
	
	@Test
	public void testPasswordWithPasswordThatHasNoSpecialCharacter(){
		User user = new User();
		user.setUserPassword("Password");
		
		assertFalse(target.validatePassword(user));
	}
	
	@Test
	public void testPasswordWithPasswordThatHasNoNumber(){
		User user = new User();
		user.setUserPassword("Passwor.");
		
		assertFalse(target.validatePassword(user));
	}
	
	@Test
	public void testPasswordWithPasswordThatHasNoCapitolLetter(){
		User user = new User();
		user.setUserPassword("password1.");
		
		assertFalse(target.validatePassword(user));
	}
	
	@Test
	public void testEmailWithValidEmail(){
		User user = new User();
		user.setUserEmail("tla@catalyst.com");
		
		assertTrue(target.validateEmail(user));
		
	}
	
	@Test
	public void testEmailWithEmailThatHasNothingBeforeTheAtSign(){
		User user = new User();
		user.setUserEmail("@catalyst.com");
		
		assertFalse(target.validateEmail(user));
		
	}
	
	@Test
	public void testEmailWithEmailThatHasNothingBetweenAtSignAndPeriod(){
		User user = new User();
		user.setUserEmail("tla@.com");
		
		assertFalse(target.validateEmail(user));
		
	}
	
	@Test
	public void testEmailWithEmailThatHasNothingAfterPeriod(){
		User user = new User();
		user.setUserEmail("tla@catalyst.");
		
		assertFalse(target.validateEmail(user));
		
	}
	
	@Test
	public void testEmailWithEmailThatAlreadyExists(){
		User user = new User();
		user.setUserEmail("existing@user.com");
		
		assertFalse(target.validateEmail(user));
		
	}
	
	@Test
	public void testValidateUserWithValidEmailAndPassword(){
		User user = new User();
		user.setUserEmail("tla@catalyst.com");
		user.setUserPassword("Password1.");
		
		assertTrue(target.validateUser(user));
	}
	
	@Test
	public void testValidateUserWithInvalidEmailAndPassword(){
		User user = new User();
		user.setUserEmail("tla@catalyst.");
		user.setUserPassword("Password1");
		
		assertFalse(target.validateUser(user));
	}
	
	@Test
	public void testValidateUserWithInvalidEmailAndValidPassword(){
		User user = new User();
		user.setUserEmail("tla@catalyst.");
		user.setUserPassword("Password1.");
		
		assertFalse(target.validateUser(user));
	}
	
	@Test
	public void testValidateUserWithValidEmailAndInvalidPassword(){
		User user = new User();
		user.setUserEmail("tla@catalyst.com");
		user.setUserPassword("Password1");
		
		assertFalse(target.validateUser(user));
	}

}
