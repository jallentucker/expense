package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutTest {

	private WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/");
	}
	
	@Test
	public void doesItLogOutWhenYouClickTheLogOutButton(){
		driver.findElement(By.id("username")).sendKeys("tla@te.st");
		driver.findElement(By.id("password")).sendKeys("Password1!");
		driver.findElement(By.id("loginSubmit")).click();
		driver.get("http://localhost:8080/#/home");
		driver.findElement(By.id("logout_button")).click();
		driver.get("http://localhost:8080/#/createProject");
		
		String expUrl = "http://localhost:8080/login#/createProject";
		String actualUrl = driver.getCurrentUrl();
		assertEquals(expUrl, actualUrl);
	}
	
	@After
	public void closeDriver(){
		driver.quit();
	}
}
