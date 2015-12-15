package com.catalyst.tla_expense.utility;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	
	public void registerUser(WebDriver driver){
	    RegisterPage register = new RegisterPage(driver);
	    register.sendKeys(By.id("registerUsername"), "dummy@dummy.com");
	    register.sendKeys(By.id("registerPassword"), "Password1!");
	    register.sendKeys(By.id("confirmPassword"), "Password1!");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    register.click(By.id("registerSubmit"));
	    register.goTo(URL + "/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        register.sendKeys(By.id("username"), "dummy@dummy.com");
		register.sendKeys(By.id("password"), "Password1!"); 
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		register.click(By.id("loginSubmit"));
	}

}
