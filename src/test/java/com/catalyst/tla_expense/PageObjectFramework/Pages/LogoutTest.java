package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.catalyst.tla_expense.utility.SeleniumConstants;

public class LogoutTest {

	private WebDriver driver;
	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
	}
	
	@Test
	public void doesItLogOutWhenYouClickTheLogOutButton(){
		driver.findElement(By.id("username")).sendKeys("dummy@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Password1!");
		driver.findElement(By.id("loginSubmit")).click();
		driver.get(URL + "/#/home");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("logout_button"))).click();
		driver.get(URL + "/#/createProject");
		
		String expUrl = (URL + "/login#/createProject");
		String actualUrl = driver.getCurrentUrl();
		assertEquals(expUrl, actualUrl);
	}
	
	@After
	public void closeDriver(){
		driver.quit();
	}
}
