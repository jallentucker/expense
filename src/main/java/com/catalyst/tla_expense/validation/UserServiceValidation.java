package com.catalyst.tla_expense.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.entities.User;
import com.catalyst.tla_expense.utility.RegexConstants;

@Service
public class UserServiceValidation {
	@Autowired
	UserDao userDao;

	/**
	 * Function that wraps the all of the validation functions into a single call.
	 * @param lineItem
	 * @return boolean
	 */
	public boolean validateUser(User user){
		return validateEmail(user) && validatePassword(user);
	}

	/**
	 * Checks that both of the password fields match each other
	 * @param user
	 * @return boolean
	 */
	public boolean validatePassword(User user) {
		boolean result = false;
		String passwordRegex = RegexConstants.PASSWORD;
		String password = user.getUserPassword();
		if(password.matches(passwordRegex)){
			result = true;
		}
		return result;
	}

	/**
	 * Checks to see that a valid email was entered and checks to see if the user
	 * exists already or not.
	 * @param user
	 * @return boolean
	 */
	public boolean validateEmail(User user) {
			boolean result = false;
			String email = user.getUserEmail();
			String emailRegex = "^[a-zA-Z0-9._%+-]{1,}[@]{1}[a-zA-Z0-9.-]{1,}[.]{1}[a-zA-Z]{2,}$";
			if(email.matches(emailRegex)){
				result = true;
			}
			List<User> existingUser = userDao.getAllUsers();
			
			for(User u : existingUser){
				String existingUserEmail = u.getUserEmail();
				if(existingUserEmail == email){
					result = false;
				}
			}
		return result;
	}

	/**
	 * Sets the UserDao in order to exchange data.
	 * @param userDao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
