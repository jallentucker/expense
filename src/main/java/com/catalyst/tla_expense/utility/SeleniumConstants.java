package com.catalyst.tla_expense.utility;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.catalyst.tla_expense.SeleniumFramework.Pages.LoginPage;
import com.catalyst.tla_expense.SeleniumFramework.Pages.RegisterPage;

public class SeleniumConstants {

	public static final String URL = "http://localhost:8080";

	public String getUrl() {
		return URL;
	}
	
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
	
	public void loginUser(WebDriver driver){
	    LoginPage register = new LoginPage(driver);
        register.sendKeys(By.id("username"), "dummy@gmail.com");
		register.sendKeys(By.id("password"), "Password1!"); 
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		register.click(By.id("loginSubmit"));
	}
	
	
	
	public void login(WebDriver driver){
		
	}

}
