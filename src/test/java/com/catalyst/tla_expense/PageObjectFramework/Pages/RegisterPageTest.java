package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import com.catalyst.tla_expense.SeleniumFramework.TestPageObject;
import com.catalyst.tla_expense.SeleniumFramework.Pages.LoginPage;
import com.catalyst.tla_expense.SeleniumFramework.Pages.RegisterPage;

public class RegisterPageTest extends TestPageObject{
	
	
	@Test
	public void checkThatItGoesToTheRightPage(){
	    RegisterPage register = new RegisterPage(driver);
	    String actualURL = register.getUrl();
	    assertEquals("http://localhost:8080/register", actualURL);
	}

	@Test
	public void checkThatInvalidPasswordAndUsernameDisplaysErrorsAndStaysOnSamePage(){
	    RegisterPage register = new RegisterPage(driver);
	    register.sendKeys(By.id("registerUsername"), "dummy");
	    register.sendKeys(By.id("registerPassword"), "password1");
	    register.sendKeys(By.id("confirmPassword"), "password");
	    register.click(By.id("registerSubmit"));
	    String actualConfirmPasswordError = register.getInnerHtml(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/p"));
	    String actualEnterPasswordError = register.getInnerHtml(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/p"));
	    String actualEmailError = register.getInnerHtml(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[1]/div[2]/p"));
	    String actualURL = register.getUrl();
	    assertEquals("Passwords do not match.",actualConfirmPasswordError);
	    assertEquals("Please enter a valid password. Must have at least:",actualEnterPasswordError);
	    assertEquals("Please enter a valid email address.",actualEmailError);
	    assertEquals("http://localhost:8080/register", actualURL);
	}

	@Test
	public void checkThatValidUserNameAndPasswordNavigatesToLoginPageAndCanUseToLogin(){
		 RegisterPage register = new RegisterPage(driver);
		 register.sendKeys(By.id("registerUsername"), "tla@catalyst.com");
		 register.sendKeys(By.id("registerPassword"), "Pass1234$");
		 register.sendKeys(By.id("confirmPassword"), "Pass1234$");
		 register.click(By.id("registerSubmit"));
		 register.sendKeys(By.id("username"), "tla@catalyst.com");
		 register.sendKeys(By.id("password"), "Pass1234$");
		 register.click(By.id("loginSubmit"));
		 String actualURL = register.getUrl();
		 assertEquals("http://localhost:8080/#/home", actualURL);
	    
	}

}
