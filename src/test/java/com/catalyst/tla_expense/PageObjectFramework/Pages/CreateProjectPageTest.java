package com.catalyst.tla_expense.PageObjectFramework.Pages;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProjectPageTest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
				
		// Create a new instance of the html unit driver
		driver = new ChromeDriver();
	}
	
	@Before
	public void logIn(){
		driver.get("http://localhost:8080/");

		WebElement element = driver.findElement(By.id("username"));
        element.sendKeys("dummy");
        
        //wait 5 secs for username to be entered
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        WebElement element1 = driver.findElement(By.id("password"));
        element1.sendKeys("password1");
        
        element.submit();
        
        driver.get("http://localhost:8080/#/home");
	}
	
	@Test
    public void navigateToNewProject(){
		
		driver.get("http://localhost:8080/#/home");
		
		driver.findElement(By.id("createProjectBtn")).click();
        
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://localhost:8080/#/createProject" );
    	
    }
	
	@Test
	public void validNewProject(){
		
		//finds project name field and enters a string
		WebElement element = driver.findElement(By.id("Projectname"));
        element.sendKeys("A Valid Project");
		
        //wait 5 secs for project name to be entered
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
        //finds the submit button and clicks it
        WebElement element1 = driver.findElement(By.id("ProjectSubmit"));
        element1.click();
		
		//checks to make sure you end up on the correct page after a successful submit
		String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://localhost:8080/#/home" );
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
}
