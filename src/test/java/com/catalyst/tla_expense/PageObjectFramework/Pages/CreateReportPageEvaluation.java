package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.catalyst.tla_expense.SeleniumFramework.TestPageObject;
import com.catalyst.tla_expense.SeleniumFramework.Pages.CreateReportPage;
import com.catalyst.tla_expense.SeleniumFramework.Pages.RegisterPage;
import com.catalyst.tla_expense.utility.SeleniumConstants;

public class CreateReportPageEvaluation extends TestPageObject
{
	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	
	public void registerUser(){
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
	
	@Test
	public void checkThatItGoesToTheRightPage() {
		registerUser();
		CreateReportPage report = new CreateReportPage(driver);
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/createReport"), actualURL);
	}
	
	@Test
	public void checkThatWhitespaceDoesNotGetAdded() {
		registerUser();
		CreateReportPage report = new CreateReportPage(driver);
		report.sendKeys(By.id("reportName"), "        ");
		report.click(By.id("ReportSubmit"));
		
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/createReport"), actualURL);
	}
	
	@Test
	public void checkThatReportWasSubmitted() {
		registerUser();
		CreateReportPage report = new CreateReportPage(driver);
		report.sendKeys(By.id("reportName"), "Dummy");
		report.click(By.id("ReportSubmit"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/home"), actualURL);
	}
	
	@Test
	public void checkThatCancelButtonWorks() {
		registerUser();
		CreateReportPage report = new CreateReportPage(driver);
		report.click(By.id("ReportCancel"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/home"), actualURL);
	}
}
