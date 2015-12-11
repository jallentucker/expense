package com.catalyst.tla_expense.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.catalyst.tla_expense.validation.Validate;


public class ValidateTest {

	@Test
	public void goodEmailTest() {
		Validate validation = new Validate("Ohnoitsyou2@yahoo.com");
		assertTrue(validation.email());
	}
	
	@Test
	public void badEmailTest(){
		Validate validation = new Validate("ohnoitsyou2yahoo.com");
		assertFalse(validation.email());
	}
	
	@Test
	public void goodPasswordTest(){
		Validate validation = new Validate("Password1!");
		assertTrue(validation.password());
	}
	
	@Test
	public void badPasswordTest(){
		Validate validation = new Validate("password");
		assertFalse(validation.password());
	}
	
}
