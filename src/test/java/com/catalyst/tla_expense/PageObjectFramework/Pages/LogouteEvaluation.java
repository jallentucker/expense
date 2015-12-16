package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.catalyst.tla_expense.SeleniumFramework.TestPageObject;
import com.catalyst.tla_expense.utility.SeleniumConstants;


public class LogouteEvaluation extends TestPageObject {
	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	
	@Test
	public void doesItLogOutWhenYouClickTheLogOutButton(){
		seleniumConstants.registerUser(driver);
		driver.get(URL + "/#/home");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("logout_button"))).click();
		driver.get(URL + "/#/createProject");
		
		String expUrl = (URL + "/login#/createProject");
		String actualUrl = driver.getCurrentUrl();
		assertEquals(expUrl, actualUrl);
	}
}
