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
	    assertEquals("Please enter a valid password. Must have at least: 8 characters, 1 capital character, 1 special characters and 1 number.",actualEnterPasswordError);
	    assertEquals("Please enter a valid email address.",actualEmailError);
	    assertEquals((URL + "/register#/home"), actualURL);
	}

	@Test
	public void checkThatValidUserNameAndPasswordRegisterNavigatesToLoginPageAndCanUseToLogin(){
		 RegisterPage register = new RegisterPage(driver);
		 register.sendKeys(By.id("registerUsername"), "tla@te.st");
		 register.sendKeys(By.id("registerPassword"), "Password1!");
		 register.sendKeys(By.id("confirmPassword"), "Password1!");
	        //wait 5 secs for username to be entered
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 register.click(By.id("registerSubmit"));
	        //wait 5 secs for username to be entered
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 register.sendKeys(By.id("username"), "tla@te.st");
		 register.sendKeys(By.id("password"), "Password1!");       
		 	//wait 5 secs for username to be entered
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 register.click(By.id("loginSubmit"));
		 
		 new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='createProjectBtn']")));
		 
		 String actualURL = register.getUrl();
		 assertEquals((URL + "/#/home"), actualURL);
	}

}
