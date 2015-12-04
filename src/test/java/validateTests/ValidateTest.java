package validateTests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.catalyst.tla_expense.validation.Validate;

import junit.framework.Assert;

public class ValidateTest {

	@Test
	public void goodEmailTest() {
		Validate validation = new Validate("Ohnoitsyou2@yahoo.com");
		Assert.assertTrue(validation.email());
	}
	
	@Test
	public void badEmailTest(){
		Validate validation = new Validate("ohnoitsyou2yahoo.com");
		Assert.assertFalse(validation.email());
	}
	
	@Test
	public void goodPasswordTest(){
		Validate validation = new Validate("Password1!");
		Assert.assertTrue(validation.password());
	}
	
	@Test
	public void badPasswordTest(){
		Validate validation = new Validate("password");
		Assert.assertFalse(validation.password());
	}

}
