package com.catalyst.tla_expense.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Jmiller
 *
 *	to use this class, instantiate 
 *	Validate(string).email() or
 *	Validate(string).password()
 *  for a true or false result
 *  
 *  Further Validation methods 
 *  should follow this pattern
 *  
 */
public class Validate {

	private Pattern pattern;
	private Matcher matcher;
	
	private String validation;
	
	//This regex pattern checks to see if the password is invalid instead of valid. 
	//This was written this way because its easier and cleaner to define and invalid
	//password than a valid password. 
	private String regexPassword = "^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$";
	
	//checks email meets a specific pattern. I think anyways.
	private String regexEmail = "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
		
	public Validate(String validation){
		this.validation = validation;
	}
	
	public boolean email(){
		pattern = Pattern.compile(regexEmail);
		matcher = pattern.matcher(validation);
		return matcher.matches();
	}
	
	public boolean password(){
		pattern = Pattern.compile(regexPassword);
		matcher = pattern.matcher(validation);
		return !(matcher.matches());
	}
	
	
}
