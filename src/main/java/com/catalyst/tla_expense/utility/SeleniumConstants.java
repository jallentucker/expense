package com.catalyst.tla_expense.utility;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.catalyst.tla_expense.SeleniumFramework.Pages.LoginPage;
import com.catalyst.tla_expense.SeleniumFramework.Pages.RegisterPage;

public class SeleniumConstants {

	/**
	 * Constant made to use throughout the app.
	 */
	public static final String URL = "http://localhost:8080";

	public String getUrl() {
		return URL;
	}
	
	/**
	 * Generates a random string to use for testing.
	 * @return randomString.
	 */
	public static String generateString()
	{
		Random rng = new Random();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = 8;
		char[] text = new char[length];
		for(int i=0; i < length; i++)
		{
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		
		return new String(text);
	}
	
	/**
	 * Logs in the user in order to run selenium tests since a user must
	 * log in each time the app is launched.
	 * @param driver
	 */
	public void loginUser(WebDriver driver){
	    LoginPage register = new LoginPage(driver);
        register.sendKeys(By.id("username"), "dummy@gmail.com");
		register.sendKeys(By.id("password"), "Password1!"); 
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		register.click(By.id("loginSubmit"));
	}
}
