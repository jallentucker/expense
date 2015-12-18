package com.catalyst.tla_expense.utility;

public class RegexConstants {

	/*
	 * requires an @ sign
	 * requires at least 2 characters
	 * after the "." character
	 * 
	 * requires some characters 
	 * before the @ sign
	 */
	public static final String USER_EMAIl = "^[a-zA-Z0-9._%+-]{1,}[@]{1}[a-zA-Z0-9.-]{1,}[.]{1}[a-zA-Z]{2,}$";
	
	/* PASSWORD REGEX:
	 * a minimum of 8 characters
	 * one upper case
	 * one lower case
	 * one number
	 * one special character
	 */
	public static final String PASSWORD = "^((?=.*\\d)(?=.*[A-Z])(?=.*[\\W]).{8,})$";
}
