package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/java/com/catalyst/tla_expense/PageObjectFramework/Drivers/chromedriver.exe");
				
		// Create a new instance of the html unit driver
		driver = new ChromeDriver();

		

	}

	@Test
	public void getTitle() {

	
		// Navigate to desired web page
		driver.get("http://github.com");
	
		// Get the title and store in string
		String actualTitle = driver.getTitle();

		// verify title
		assertEquals("GitHub · Where software is built", actualTitle);

	}

	

	//Always close the browser and release the driver.
	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
}