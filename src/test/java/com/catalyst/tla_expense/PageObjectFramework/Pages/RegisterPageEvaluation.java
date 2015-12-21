package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.catalyst.tla_expense.SeleniumFramework.TestPageObject;
import com.catalyst.tla_expense.SeleniumFramework.Pages.RegisterPage;
import com.catalyst.tla_expense.utility.SeleniumConstants;

public class RegisterPageEvaluation extends TestPageObject{
	
	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	
	@Test
	public void checkThatItGoesToTheRightPage(){
	    RegisterPage register = new RegisterPage(driver);
	    String actualURL = register.getUrl();
	    assertEquals((URL + "/register"), actualURL);
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
	    assertEquals((URL + "/register"), actualURL);
	}

	@Test
	public void checkThatValidUserNameAndPasswordRegisterNavigatesToLoginPageAndCanUseToLogin(){
		 RegisterPage register = new RegisterPage(driver);
		 String userName =  SeleniumConstants.generateString() + "@aol.com";
		 register.sendKeys(By.id("registerUsername"), userName);
		 register.sendKeys(By.id("registerPassword"), "Password1!");
		 register.sendKeys(By.id("confirmPassword"), "Password1!");
	        //wait 5 secs for username to be entered
		 register.click(By.id("registerSubmit"));
	        //wait 5 secs for username to be entered
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 register.find(By.id("username"));

		 register.sendKeys(By.id("username"), userName);
		 register.sendKeys(By.id("password"), "Password1!");       
		 	//wait 5 secs for username to be entered
		 register.click(By.id("loginSubmit"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 register.find(By.id("logout_button"));
		 String actualURL = register.getUrl();
		 assertEquals((URL + "/#/home"), actualURL);
	}

}
