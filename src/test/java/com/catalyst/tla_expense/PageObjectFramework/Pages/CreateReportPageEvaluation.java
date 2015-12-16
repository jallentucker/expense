package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.catalyst.tla_expense.SeleniumFramework.TestPageObject;
import com.catalyst.tla_expense.SeleniumFramework.Pages.CreateReportPage;
import com.catalyst.tla_expense.utility.SeleniumConstants;

public class CreateReportPageEvaluation extends TestPageObject
{
	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();	
	
	@Test
	public void checkThatItGoesToTheRightPage() {
		seleniumConstants.registerUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/createReport"), actualURL);
	}
	
	@Test
	public void checkThatWhitespaceDoesNotGetAdded() {
		seleniumConstants.registerUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		report.sendKeys(By.id("reportName"), "        ");
		report.click(By.id("ReportSubmit"));
		
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/createReport"), actualURL);
	}
	
	@Test
	public void checkThatReportWasSubmitted() {
		seleniumConstants.registerUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		report.sendKeys(By.id("reportName"), generateString);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new Select (driver.findElement(By.id("projectDropDown"))).selectByIndex(1);
		report.click(By.id("ReportSubmit"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/home"), actualURL);
	}
	
	@Test
	public void checkThatCancelButtonWorks() {
		seleniumConstants.registerUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		report.click(By.id("ReportCancel"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/home"), actualURL);
	}
	
	@Test 
	public void checkThatAReportIsntSubmittedWithoutAProject() {
		seleniumConstants.registerUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		report.sendKeys(By.id("reportName"), generateString);
		report.click(By.id("ReportSubmit"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/createReport"), actualURL);
	}
	
}
