package com.catalyst.tla_expense.PageObjectFramework.Pages;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.catalyst.tla_expense.SeleniumFramework.TestPageObject;
import com.catalyst.tla_expense.utility.SeleniumConstants;

public class CreateProjectPageEvaluation extends TestPageObject {

	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();	
	
	@Test
    public void navigateToNewProject(){
		seleniumConstants.registerUser(driver);
		driver.get(URL + "/#/home");
		
		driver.findElement(By.id("createProjectBtn")).click();
		
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Projectname']")));
       
        String URL = driver.getCurrentUrl();

        Assert.assertEquals((SeleniumConstants.URL + "/#/createProject"), URL );

    	
    }
	
	@Test
	public void validNewProject(){
		seleniumConstants.registerUser(driver);
		
		driver.get(URL + "/#/createProject");
		
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Projectname']")));
		
		//finds project name field and enters a string
		WebElement element = driver.findElement(By.id("Projectname"));
        element.sendKeys(generateString);
		
        //wait 5 secs for project name to be entered
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
        //finds the submit button and clicks it
        WebElement element1 = driver.findElement(By.id("ProjectSubmit"));
        element1.click();
       
        new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("logout_button")));
		//checks to make sure you end up on the correct page after a successful submit
		String aURL = driver.getCurrentUrl();

        Assert.assertEquals(aURL, (URL  + "/#/home"));

		
	}
	
	@Test
	public void cancelButton(){
		seleniumConstants.registerUser(driver);
		
		driver.get(URL + "/#/createProject");

		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Projectname']")));
			
        //finds the submit button and clicks it
        WebElement element1 = driver.findElement(By.id("ProjectCancel"));
        element1.click();
		
		//checks to make sure you end up on the correct page after a successful submit
		String URL = driver.getCurrentUrl();

        Assert.assertEquals(URL, (SeleniumConstants.URL  + "/#/home"));

	}
	
	@Test
	public void duplicateProject(){
		seleniumConstants.registerUser(driver);
		
		driver.get(URL + "/#/createProject");
		
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Projectname']")));
		
		//finds project name field and enters a string
		WebElement element = driver.findElement(By.id("Projectname"));
        element.sendKeys(generateString);
		
        //finds the submit button and clicks it
        WebElement element1 = driver.findElement(By.id("ProjectSubmit"));
        element1.click();
        
        new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("logout_button")));
        
        driver.get(URL + "/#/createProject");
		
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Projectname']")));
		
		//finds project name field and enters a string
		WebElement element3 = driver.findElement(By.id("Projectname"));
        element3.sendKeys(generateString);
		
        //finds the submit button and clicks it
        WebElement element4 = driver.findElement(By.id("ProjectSubmit"));
        element4.click();
		
		//checks to make sure you end up on the correct page after a successful submit
		String aURL = driver.getCurrentUrl();

        Assert.assertEquals(aURL, (SeleniumConstants.URL  + "/#/createProject"));
	}
}
