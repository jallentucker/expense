package com.catalyst.tla_expense.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.UserDao;
import com.catalyst.tla_expense.entities.User;

@Service
public class UserServiceValidation {
	@Autowired
	UserDao userDao;

	public boolean validateUser(User user){
		return validateEmail(user) && validatePassword(user);
	}

	public boolean validatePassword(User user) {
		boolean result = false;
		String passwordRegex = "^((?=.*\\d)(?=.*[A-Z])(?=.*[\\W]).{8,})$";
		String password = user.getUserPassword();
		if(password.matches(passwordRegex)){
			result = true;
		}
		return result;
	}

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

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
