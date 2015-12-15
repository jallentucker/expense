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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

<<<<<<< HEAD:src/test/java/com/catalyst/tla_expense/PageObjectFramework/Pages/CreateProjectPageEvaluation.java
public class CreateProjectPageEvaluation {
=======
import com.catalyst.tla_expense.utility.SeleniumConstants;

public class CreateProjectPageTest {
>>>>>>> Constant_Localhost:src/test/java/com/catalyst/tla_expense/PageObjectFramework/Pages/CreateProjectPageTest.java

	private WebDriver driver;
	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
				
		// Create a new instance of the html unit driver
		driver = new ChromeDriver();
	}
	
	@Before
	public void logIn(){
		driver.get(URL);

		WebElement element = driver.findElement(By.id("username"));
        element.sendKeys("tla@te.st");
        
        //wait 5 secs for username to be entered
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        WebElement element1 = driver.findElement(By.id("password"));
        element1.sendKeys("Password1!");
        
        element.submit();
        
        driver.get(URL + "/#/home");
	}
	
	@Test
    public void navigateToNewProject(){
		
		/*driver.get("http://localhost:8080/#/home");*/
		
		driver.findElement(By.id("createProjectBtn")).click();
		
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Projectname']")));
        
        String URL = driver.getCurrentUrl();
        Assert.assertEquals((URL +"/#/createProject"), URL );
    	
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
        Assert.assertEquals(URL, (URL + "/#/home"));
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
}
